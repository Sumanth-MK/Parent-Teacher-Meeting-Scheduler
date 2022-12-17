/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.resources.service;

import edu.iit.sat.itmd4515.smk1.domain.Meeting;
import edu.iit.sat.itmd4515.smk1.domain.Parent;
import edu.iit.sat.itmd4515.smk1.domain.Student;
import edu.iit.sat.itmd4515.smk1.domain.Teacher;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author Sumanth M K
 */
@Named
@Stateless
public class MeetingService extends AbstractService<Meeting>{

    /**
     *
     */
    public MeetingService() {
        super(Meeting.class);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Meeting> findAll() {
        return em.createNamedQuery("Meeting.findAll", Meeting.class).getResultList();
    }
    
    /**
     *
     * @param m
     */
    public void ScheduleMeeting(Meeting m){
        Meeting newmeet = new Meeting();
        
        newmeet.setDate(m.getDate());
        newmeet.setTime(m.getTime());
        newmeet.setType(m.getType());
        
        Teacher tref = em.getReference(Teacher.class,m.getTeacher().getId());
        Student sref = em.getReference(Student.class, m.getStudent().getId());
        Parent pref = em.getReference(Parent.class, m.getParent().getId());
        
        newmeet.addMeet(pref, tref, sref);
        em.persist(newmeet);
    }
    
    /**
     *
     * @param meet
     */
    public void cancelMeet(Meeting meet){
        meet = em.getReference(Meeting.class, meet.getId());
        // manage all the relationships
        meet.delMeet();
        
        em.remove(meet);
    }
    
    /**
     *
     * @param meet
     */
    public void changeMeet(Meeting meet){
        Meeting managedmeet = em.getReference(Meeting.class, meet.getId());
        
        // user on the form can change vet, type, time and date.  That's all
        managedmeet.setDate(meet.getDate());
        managedmeet.setTime(meet.getTime());
        managedmeet.setType(meet.getType());
        
        // as far as relationships, the user can not change the pet or themselves (owner_
        // but they can change the vet
        // Short circuit approach is to cancel the appt and reschedule
        managedmeet.delMeet();
        managedmeet.addMeet(
                em.getReference(Parent.class, meet.getParent().getId()),
                em.getReference(Teacher.class, meet.getTeacher().getId()),
                em.getReference(Student.class, meet.getStudent().getId())
        );
        
        em.persist(managedmeet);
    }
}
