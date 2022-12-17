/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.web;

import edu.iit.sat.itmd4515.smk1.domain.Parent;
import edu.iit.sat.itmd4515.smk1.resources.service.ParentService;
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
public class ParentWelcomeController {

    private static final Logger LOG = Logger.getLogger(ParentWelcomeController.class.getName());


    @Inject LoginController logincontroller;
    @EJB ParentService parentService;
    private Parent parent;
    
    /**
     *
     */
    public ParentWelcomeController() {
    }

    /**
     *
     * @param parent
     * @param teacher
     */
    public ParentWelcomeController(Parent parent) {
        this.parent = parent;
    }
    
    @PostConstruct
    private void PostConstruct(){
        LOG.info("inside ParentWelcomeController.postConstruct");
        parent = parentService.findByUsername(logincontroller.getAuthenticatedUser());
        LOG.info("Leaving ParentWelcomeController.postConstruct with - " +parent.toString());
    }
    public Parent getParent() {
        return parent;
    }
    public void setParent(Parent parent) {
        this.parent = parent;
    }
    
    /**
     *
     */
    /**
     *
     * @return
     */
 
}
