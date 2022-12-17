/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.demo;

import edu.iit.sat.itmd4515.smk1.domain.Student;
import edu.iit.sat.itmd4515.smk1.domain.StudentClass;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Sumanth M K
 */
public class Demo {
    
    /**
     *
     * @param args
     */
    public static void main(String...args){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("itmd4515testPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Student student = new Student();
        student.setName("Test");
        student.setSclass(StudentClass.Physics);
        System.out.println(student.toString());
        em.persist(student);
        
        tx.commit();
    }
    
}
