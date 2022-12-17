/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.web;

import edu.iit.sat.itmd4515.smk1.domain.Meeting;
import edu.iit.sat.itmd4515.smk1.domain.Parent;
import edu.iit.sat.itmd4515.smk1.domain.Student;
import edu.iit.sat.itmd4515.smk1.resources.service.MeetingService;
import edu.iit.sat.itmd4515.smk1.resources.service.ParentService;
import edu.iit.sat.itmd4515.smk1.resources.service.StudentService;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Sumanth M K
 */
@Named
@RequestScoped
public class TeacherMeetingController {

    private static final Logger LOG = Logger.getLogger(TeacherMeetingController.class.getName());

    private Student student;

    private Meeting meet;
    @Inject
    private TeacherWelcomeController twc;
    @EJB
    StudentService svc;
    @EJB
    MeetingService msvc;

    /**
     *
     */
    public TeacherMeetingController() {
    }

    @PostConstruct
    private void PostConstruct() {
        LOG.info("Inside TeacherMeetingController PostConstruct");

        meet = new Meeting();
        meet.setStudent(new Student());
        meet.setTeacher(twc.getTeacher());
        meet.setParent(new Parent());

        LOG.info("Leaving TeacherMeetingController.postContruct with " + meet.toString());
    }

    /**
     *
     */
    public void initStudentById() {
        meet.setStudent(svc.read(this.meet.getStudent().getId()));
    }

    /**
     *
     */
    public void initMeetById() {
        LOG.info("initApptById before find " + this.meet.toString());
        this.meet = msvc.read(meet.getId());
        LOG.info("initApptById after find " + this.meet.toString());
    }

    /**
     *
     * @param s
     * @return
     */
    public String displayScheduleMeetingPage(Student s) {

        LOG.info("Inside displayScheduleMeetingPage with student " + s.toString());

        this.student = s;
        meet.setStudent(student);
        return "/teacher/schedMeet.xhtml";

    }

    /**
     *
     * @return
     */
    public String executeScheduleButtonClick() {

        LOG.info("Inside executeScheduleButtonClick with " + this.meet.toString());
        LOG.info("Inside executeScheduleButtonClick with " + this.meet.getStudent().toString());
        LOG.info("Inside executeScheduleButtonClick with " + this.meet.getTeacher().toString());
        LOG.info("Inside executeScheduleButtonClick with " + this.meet.getParent().toString());

        msvc.ScheduleMeeting(meet);
        twc.RefreshTeacher();
        return "/teacher/welcome.xhtml";
    }

    /**
     *
     * @return
     */
    public String executeChangeButtonClick() {

        LOG.info("Inside executeChangeButtonClick with " + this.meet.toString());
        LOG.info("Inside executeChangeButtonClick with " + this.meet.getStudent().toString());
        LOG.info("Inside executeChangeButtonClick with " + this.meet.getTeacher().toString());
        LOG.info("Inside executeChangeButtonClick with " + this.meet.getParent().toString());

        //msvc.ScheduleMeeting(meet);
        msvc.changeMeet(meet);
        twc.RefreshTeacher();
        return "/teacher/welcome.xhtml";
    }
    
    /**
     *
     * @return
     */
    public String executeDeleteButtonClick() {

        LOG.info("Inside executeDeleteButtonClick with " + this.meet.toString());
        LOG.info("Inside executeDeleteButtonClick with " + this.meet.getStudent().toString());
        LOG.info("Inside executeDeleteButtonClick with " + this.meet.getTeacher().toString());
        LOG.info("Inside executeDeleteButtonClick with " + this.meet.getParent().toString());

       // msvc.ScheduleMeeting(meet);
       msvc.cancelMeet(meet);
        twc.RefreshTeacher();
        return "/teacher/welcome.xhtml";
    }
    
    /**
     *
     * @return
     */
    public Student getStudent() {
        return student;
    }

    /**
     *
     * @param student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     *
     * @return
     */
    public Meeting getMeet() {
        return meet;
    }

    /**
     *
     * @param meet
     */
    public void setMeet(Meeting meet) {
        this.meet = meet;
    }
}
