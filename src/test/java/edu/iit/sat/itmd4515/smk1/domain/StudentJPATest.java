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
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Sumanth M K
 */
public class StudentJPATest extends AbstractJPATest {
    
    
    @Test
    public void createTest(){
        Student test = new Student("TestStudent", LocalDate.of(1996, Month.JULY, 5), StudentClass.Physics,3.5);
        tx.begin();
        em.persist(test);
        tx.commit();
        
        Student createStudent = em.createQuery("select s from Student s where s.name = 'TestStudent' ",Student.class).getSingleResult();
        assertNotNull(createStudent);
        assertTrue(createStudent.getId()>0);
        tx.begin();
        em.remove(createStudent);
        tx.commit();
    }
    
    @Test
    public void readTest(){
    
        // read an entity from the database
        Student readStudent = em.createQuery("select s from Student s where s.name = 'Test' ",Student.class).getSingleResult();
        // assert if we read the right one
        assertEquals("Test",readStudent.getName());
    
    }
    
    @Test
    public void updateTest(){
        
        Student updateStudent = em.createQuery("select s from Student s where s.name = 'Test' ",Student.class).getSingleResult();
        tx.begin();
        updateStudent.setSclass(StudentClass.Chemistry);
        tx.commit();
        
        Student compare = em.find(Student.class, updateStudent.getId());
        assertEquals(StudentClass.Chemistry,compare.getSclass());
    }
    
    @Test
    public void deleteTest(){
        Student deletestudent = new Student("Test", LocalDate.of(1996, Month.JULY, 5), StudentClass.Physics,3.5);
        tx.begin();
        em.persist(deletestudent);
        tx.commit();
        
        assertNotNull(deletestudent.getId());
        
        tx.begin();
        em.remove(deletestudent);
        tx.commit();
    
        Student studentDeleted = em.find(Student.class, deletestudent.getId());
        assertNull(studentDeleted);
    
    }
    
}
