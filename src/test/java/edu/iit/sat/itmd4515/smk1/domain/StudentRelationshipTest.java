/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.AssertTrue;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Sumanth M K
 */
public class StudentRelationshipTest extends AbstractJPATest{
    
    @Test
    public void testMtoMBidirTeacherStudentRelationship(){
        
        Teacher t = new Teacher("TestTeacher", "physics", LocalDate.of(1996, 07, 05));
        Student s = new Student("TestStudentT", LocalDate.of(2000, 07, 05), StudentClass.Physics, 4);
        
        t.addStudent(s);
        tx.begin();
        em.persist(t);
        em.persist(s);
        tx.commit();
        
        //s.getTeachers().add(t);
        //t.getStudents().add(s);

        System.out.println("Navigating the relationship from the owning side" +t.getStudents().toString());
        System.out.println("Navigating the relationship from the inverse side" +s.getTeachers().toString());
        
        assertTrue(t.getStudents().size() == 1);
        assertTrue(s.getTeachers().size() == 1);
        
        
        //remove data using helper method
        tx.begin();
        t.removeStudent(s);
        em.remove(s);
        em.remove(t);
        tx.commit();
        
        System.out.println("Navigating the relationship from the owning side" +t.getStudents().toString());
        System.out.println("Navigating the relationship from the inverse side" +s.getTeachers().toString());
    }
    
   
    @Test
    public void OtoMBiDirRelationshipTestSM(){
        
        Student s = new Student("TestStudentM", LocalDate.of(2000, 07, 05), StudentClass.Physics, 4);
        Meeting m1 = new Meeting(LocalDate.of(2023, 10, 10), LocalTime.of(13,00), "test");
        Meeting m2 = new Meeting(LocalDate.of(2023, 10, 10), LocalTime.of(13,00), "test2");

        List<Meeting> meetings = new ArrayList<>();
        
        m1.setStudent(s);
        m2.setStudent(s);
        
        meetings.add(m1);
        meetings.add(m2);
        
        //s.getMeetings().add(m);
        tx.begin();
        em.persist(m1);
        em.persist(m2);
        em.persist(s);
        tx.commit();
             
       assertTrue(meetings.size() == 2);
            
        tx.begin();
        em.remove(m2);
        em.remove(m1);
        em.remove(s);
        tx.commit();
        
        
        
    }
    
     @Test
    public void OnetoOneUniDirRelationshipTestSP(){
        
        Parent p = new Parent("TestParent2");
        Student s = new Student("TestStudent", LocalDate.of(2000, 07, 05), StudentClass.Physics, 4);
        
        //s.getMeetings().add(m);
//        tx.begin();
//        em.persist(p);
//        s.setParents(p);
//        em.persist(s);
//        tx.commit();
//             
//        assertTrue(s.getParents().getId().equals(p.getId()));

        tx.begin();
        em.persist(s);
        p.setStudents(s);
        em.persist(p);
        tx.commit();
             
        assertTrue(p.getStudents().getId().equals(s.getId()));
            
        tx.begin();
        em.remove(s);
        em.remove(p);
        tx.commit();      
    }
    
}
