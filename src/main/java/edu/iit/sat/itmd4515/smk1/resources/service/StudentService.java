/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.resources.service;

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
public class StudentService extends AbstractService<Student> {

    /**
     *
     */
    public StudentService() {
        super(Student.class);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Student> findAll() {
        return em.createNamedQuery("Student.findAll", Student.class).getResultList();
    }


}
