/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.web;

import edu.iit.sat.itmd4515.smk1.domain.Student;
import edu.iit.sat.itmd4515.smk1.domain.StudentClass;
import edu.iit.sat.itmd4515.smk1.domain.Student;
import edu.iit.sat.itmd4515.smk1.resources.service.StudentService;
import edu.iit.sat.itmd4515.smk1.resources.service.TeacherService;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Sumanth M K
 */
@Named
@RequestScoped
public class TeacherNewStudentController {
    
    private static final Logger LOG = Logger.getLogger(TeacherNewStudentController.class.getName());
    private Student student;
    
    @EJB
    private TeacherService teachersvc;
    @Inject
    TeacherWelcomeController twc;
    @Inject
    FacesContext facesContext;
    
    private boolean showFacesMessages = false;
    
    /**
     *
     */
    public TeacherNewStudentController() {
    }
    
    @PostConstruct
    private void PostConstruct() {
        LOG.info("StudentController.PostConstruct");
        student = new Student();
    }
    
    /**
     *
     * @return
     */
    public StudentClass[] getStudentClass() {
        return StudentClass.values();
    }
    
    /**
     *
     * @param s
     * @return
     */
    public String displayReadStudentPage(Student s) {
        LOG.info("Inside displayReadStudentPage =  " + s.toString());
        this.student = s;
        return "/teacher/readStudent.xhtml";
    }
    
    /**
     *
     * @param s
     * @return
     */
    public String displayUpdateStudentPage(Student s) {
        LOG.info("Inside displayUpdateStudentPage =  " + s.toString());
        this.student = s;
        return "/teacher/updateStudent.xhtml";
    }
    
    /**
     *
     * @param s
     * @return
     */
    public String displaydeleteStudentPage(Student s) {
        LOG.info("Inside displaydeleteStudentPage =  " + s.toString());
        this.student = s;
        return "/teacher/deleteStudent.xhtml";
    }
    
    /**
     *
     * @return
     */
    public String executeCreateButtonClick() {
        LOG.info("Inside executeCreateButtonClick with " + this.student.toString());
        
        twc.getTeacher().addStudent(student);
        teachersvc.createStudentForTeacher(student, twc.getTeacher());
        
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Success!!",
                "New Student " + this.student.getName() + " was created"));
        this.showFacesMessages = true;
        return "/teacher/welcome.xhtml";
    }
    
    /**
     *
     * @return
     */
    public String executeUpdateButtonClick() {
        LOG.info("Inside executeUpdateButtonClick with " + this.student.toString());
        //studentsvc.create(student);
        teachersvc.UpdateStudentForTeacher(student);
        //teachersvc.createStudentForTeacher(student, twc.getTeacher());
        return "/teacher/welcome.xhtml?faces-redirect=true";
    }
    
    /**
     *
     * @return
     */
    public String executeDeleteButtonClick() {
        LOG.info("Inside executeDeleteButtonClick with " + this.student.toString());
        //studentsvc.create(student);
        teachersvc.DeleteStudentForTeacher(student);

        //teachersvc.createStudentForTeacher(student, twc.getTeacher());
        return "/teacher/welcome.xhtml?faces-redirect=true";
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
    public boolean isShowFacesMessages() {
        return showFacesMessages;
    }

    /**
     *
     * @param showFacesMessages
     */
    public void setShowFacesMessages(boolean showFacesMessages) {
        this.showFacesMessages = showFacesMessages;
    }
}
