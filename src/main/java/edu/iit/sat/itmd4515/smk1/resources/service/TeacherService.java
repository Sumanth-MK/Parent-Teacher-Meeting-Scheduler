/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.resources.service;

import edu.iit.sat.itmd4515.smk1.domain.Meeting;
import edu.iit.sat.itmd4515.smk1.domain.Parent;
import edu.iit.sat.itmd4515.smk1.domain.Student;
import edu.iit.sat.itmd4515.smk1.domain.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Sumanth M K
 */
@Stateless
public class TeacherService extends AbstractService<Teacher> {

    /**
     *
     */
    public TeacherService() {
        super(Teacher.class);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Teacher> findAll() {
        return em.createNamedQuery("Teacher.findAll", Teacher.class).getResultList();
    }

    /**
     *
     * @param username
     * @return
     */
    public Teacher findByUsername(String username) {
        return em.createNamedQuery("Teacher.findByUsername", Teacher.class)
                .setParameter("username", username)
                .getSingleResult();

    }

    /**
     *
     * @param s
     * @param t
     */
    public void createStudentForTeacher(Student s, Teacher t) {
        em.persist(s);

        Teacher managedTeacherReference = em.getReference(Teacher.class, t.getId());
        managedTeacherReference.addStudent(s);
        em.merge(managedTeacherReference);
    }

    /**
     *
     * @param s
     */
    public void UpdateStudentForTeacher(Student s) {
        Student managedSReference = em.getReference(Student.class, s.getId());

        managedSReference.setName(s.getName());
        managedSReference.setDateofbirth(s.getDateofbirth());
        managedSReference.setSclass(s.getSclass());
        managedSReference.setGpa(s.getGpa());
    }

    /**
     *
     * @param s
     */
    public void DeleteStudentForTeacher(Student s) {

        Student managedSReference = em.getReference(Student.class, s.getId());

        List<Meeting> meetings = em.createNamedQuery("Meeting.findMeetingByStudent", Meeting.class)
                .setParameter("ID", managedSReference.getId())
                .getResultList();
        for (Meeting m : meetings) {
            m.delMeet();
            em.remove(m);
        }

        for (Teacher t : new ArrayList<Teacher>(managedSReference.getTeachers())) {
            t.removeStudent(managedSReference);
            em.merge(t);
        }

        Parent parent = em.createNamedQuery("Parent.findStudentById", Parent.class).setParameter("ID", managedSReference.getId()).getSingleResult();

        if (parent.getId() == null) {
            em.remove(managedSReference);
        } else {
            em.remove(parent);
            em.remove(managedSReference);
        }
    }
}
