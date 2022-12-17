/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.web;

import edu.iit.sat.itmd4515.smk1.domain.Teacher;
import edu.iit.sat.itmd4515.smk1.resources.service.TeacherService;
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
public class TeacherWelcomeController {

    private static final Logger LOG = Logger.getLogger(TeacherWelcomeController.class.getName());

    private Teacher teacher;

    @Inject LoginController logincontroller;
    @EJB TeacherService teachersvc;
    
    /**
     *
     */
    public TeacherWelcomeController() {
    }

    /**
     *
     * @param teacher
     */
    public TeacherWelcomeController(Teacher teacher) {
        this.teacher = teacher;
    }
    
    @PostConstruct
    private void PostConstruct(){
        LOG.info("inside TeacherWelcomeController.postConstruct");
        teacher = teachersvc.findByUsername(logincontroller.getAuthenticatedUser());
        LOG.info("Leaving TeacherWelcomeController.postConstruct with - " +teacher.toString());
    }
    
    /**
     *
     */
    public void RefreshTeacher(){
        teacher=teachersvc.findByUsername(logincontroller.getAuthenticatedUser());
    }

    /**
     *
     * @return
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     *
     * @param teacher
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
}
