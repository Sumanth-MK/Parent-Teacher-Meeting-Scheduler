/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.domain;

import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Sumanth M K
 */
public class AbstractJPATest {
    protected static EntityManagerFactory emf;
    protected static final Logger LOG = Logger.getLogger(StudentJPATest.class.getName());
    protected EntityManager em;
    protected EntityTransaction tx;
    
    @BeforeAll
    public static void beforeAll(){
    
        emf=Persistence.createEntityManagerFactory("itmd4515testPU");
    }
    
    @BeforeEach
    public void beforeEach(){
        
        em=emf.createEntityManager();
        tx=em.getTransaction();
        
        //create Test data
        Student test = new Student("Test", LocalDate.of(1996, Month.JULY, 5), StudentClass.Physics,3.5);
        tx.begin();
        em.persist(test);
        tx.commit();
    }
    
    @AfterEach
    public void afterEach(){
        //cleanup Test data
        //em.createQuery("select s from Student s where s.name = 'Test' ",Student.class).getSingleResult();
        Student deleteStudent = em.createNamedQuery("Student.findByName", Student.class).setParameter("NAME", "Test").getSingleResult();
        
        tx.begin();
        em.remove(deleteStudent);
        tx.commit();
        em.close();
    }
    
    @AfterAll
    public static void afterAll(){
    
        emf.close();
    }
    
}
