/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.web;

import edu.iit.sat.itmd4515.smk1.domain.Teacher;
import edu.iit.sat.itmd4515.smk1.security.User;
import edu.iit.sat.itmd4515.smk1.security.UserService;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Sumanth M K
 */
@Named
@RequestScoped
public class NewTeacherAdditionController {

    private static final Logger LOG = Logger.getLogger(NewTeacherAdditionController.class.getName());

    
        private Teacher teacher;
        
        @EJB UserService usvc;
        
    /**
     *
     */
    public NewTeacherAdditionController() {
        }

         @PostConstruct
    private void PostConstruct(){
        LOG.info("Inside NewTeacherAdditionController PostConstruct");
        
        teacher = new Teacher();
        teacher.setUsers(new User());
    }
        
    /**
     *
     * @return
     */
    public String executeAddNewTeacherClick(){
        LOG.info(this.teacher.toString());
        
        usvc.addNewTeacherUser(this.teacher);
        return "/admin/welcome.xhtml?faces-redirect=true";
    }
    
    
    
    /**
     * Get the value of teacher
     *
     * @return the value of teacher
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * Set the value of teacher
     *
     * @param teacher new value of teacher
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    
}
