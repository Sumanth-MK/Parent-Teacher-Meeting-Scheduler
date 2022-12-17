/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.web;

import edu.iit.sat.itmd4515.smk1.domain.Parent;
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
public class NewParentAdditionController {
    
    private static final Logger LOG = Logger.getLogger(NewParentAdditionController.class.getName());

    //Add model
    private Parent parent;
    
    @EJB UserService usvc;
    
    /**
     *
     */
    public NewParentAdditionController() {
    }
    
    @PostConstruct
    private void PostConstruct() {
        LOG.info("Inside NewParentAdditionController PostConstruct");
        
        parent = new Parent();
        parent.setUsers(new User());
    }
    
    /**
     *
     * @return
     */
    public String executeAddNewParentClick() {
        LOG.info(this.parent.toString());
        
        usvc.addNewParentUser(this.parent);
        return "/admin/welcome.xhtml?faces-redirect=true";
    }
    
    /**
     *
     * @return
     */
    public Parent getParent() {
        return parent;
    }

    /**
     *
     * @param parent
     */
    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
