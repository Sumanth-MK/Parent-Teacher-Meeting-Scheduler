/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.resources.service;

import edu.iit.sat.itmd4515.smk1.domain.Meeting;
import edu.iit.sat.itmd4515.smk1.domain.Parent;
import edu.iit.sat.itmd4515.smk1.domain.Student;
import edu.iit.sat.itmd4515.smk1.domain.StudentClass;
import edu.iit.sat.itmd4515.smk1.domain.Teacher;
import edu.iit.sat.itmd4515.smk1.security.Group;
import edu.iit.sat.itmd4515.smk1.security.GroupService;
import edu.iit.sat.itmd4515.smk1.security.User;
import edu.iit.sat.itmd4515.smk1.security.UserService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sumanth M K
 */
@Startup
@Singleton
public class StartupSampleDataService {

    private static final Logger LOG = Logger.getLogger(StartupSampleDataService.class.getName());

    @EJB
    private ParentService parentsvc;
    @EJB
    private TeacherService teachersvc;
    @EJB
    private StudentService studentsvc;
    @EJB
    private MeetingService meetingsvc;
    @EJB
    private UserService usersvc;
    @EJB
    private GroupService groupsvc;

//     @PersistenceContext(name = "itmd4515PU")
//    private EntityManager em;

    /**
     *
     */
    public StartupSampleDataService() {
    }

    @PostConstruct
    private void PostConstruct() {

        LOG.info("Inside StartupSampleDataService.postConstruct method");

        Group teacherGroup = new Group("TEACHER_GROUP", "This group represents teachers");
        Group parentGroup = new Group("PARENT_GROUP", "This group represents parents");
        Group adminGroup = new Group("ADMIN_GROUP", "This group represents admins");
        groupsvc.create(teacherGroup);
        groupsvc.create(parentGroup);
        groupsvc.create(adminGroup);

        User admin = new User("admin", "admin", true);
        admin.addGroup(adminGroup);
        usersvc.create(admin);

        User teacher1 = new User("teacher1", "teacher1", true);
        teacher1.addGroup(teacherGroup);
        teacher1.addGroup(adminGroup);
        usersvc.create(teacher1);

        User teacher2 = new User("teacher2", "teacher2", true);
        teacher2.addGroup(teacherGroup);
        teacher2.addGroup(adminGroup);
        usersvc.create(teacher2);

        User parent1 = new User("parent1", "parent1", true);
        parent1.addGroup(parentGroup);
        usersvc.create(parent1);

        User parent2 = new User("parent2", "parent2", true);
        parent2.addGroup(parentGroup);
        usersvc.create(parent2);
        
        User parent3 = new User("parent3", "parent3", true);
        parent3.addGroup(parentGroup);
        usersvc.create(parent3);
        
        User parent4 = new User("parent4", "parent4", true);
        parent4.addGroup(parentGroup);
        usersvc.create(parent4);
        
        User parent5 = new User("parent5", "parent5", true);
        parent5.addGroup(parentGroup);
        usersvc.create(parent5);

//        em.persist(p1);
//        em.persist(p2);
        Student s1 = new Student("Jack", LocalDate.of(1996, 06, 10), StudentClass.Physics, 4);
        Student s2 = new Student("Jill", LocalDate.of(1997, 07, 05), StudentClass.Chemistry, 4);
        Student s3 = new Student("Johnny", LocalDate.of(1997, 07, 9), StudentClass.Economics, 4);
        Student s4 = new Student("Raj", LocalDate.of(1996, 07, 10), StudentClass.Geography, 4);
        Student s5 = new Student("Devi", LocalDate.of(1996, 07, 20), StudentClass.Mathematics, 4);

        studentsvc.create(s1);
        studentsvc.create(s2);
        studentsvc.create(s3);
        studentsvc.create(s4);
        studentsvc.create(s5);
//        
        //owning entitites

        Teacher t1 = new Teacher("Scott", "Mathematics", LocalDate.of(1960, 05, 07));
        t1.setUsers(teacher1);
        Teacher t2 = new Teacher("Spyrison", "Physics", LocalDate.of(1961, 05, 07));
        t2.setUsers(teacher2);

        t1.addStudent(s1);
        t1.addStudent(s2);
        t2.addStudent(s3);
        t2.addStudent(s4);
        t2.addStudent(s5);
        t2.addStudent(s1);

        teachersvc.create(t1);
        teachersvc.create(t2);

        Parent p1 = new Parent("Parent 1");
        p1.setUsers(parent1);
        Parent p2 = new Parent("Parent 2");
        p2.setUsers(parent2);
        Parent p3 = new Parent("Parent 3");
        p3.setUsers(parent3);
        Parent p4 = new Parent("Parent 4");
        p4.setUsers(parent4);
        Parent p5 = new Parent("Parent 5");
        p5.setUsers(parent5);

        p1.setStudents(s1);
        p2.setStudents(s2);
        p3.setStudents(s3);
        p4.setStudents(s4);
        p5.setStudents(s5);
//        
        parentsvc.create(p1);
        parentsvc.create(p2);
        parentsvc.create(p3);
        parentsvc.create(p4);
        parentsvc.create(p5);

        Meeting m1 = new Meeting(LocalDate.of(2023, 1, 10), LocalTime.of(9, 0), "simply");
        m1.addMeet(p2, t2, s5);

        Meeting m2 = new Meeting(LocalDate.of(2023, 2, 10), LocalTime.of(10, 0), "grade");
        m2.addMeet(p1, t1, s1);

        Meeting m3 = new Meeting(LocalDate.of(2023, 2, 14), LocalTime.of(10, 0), "fees");
        m3.addMeet(p1, t1, s1);

        meetingsvc.create(m1);
        meetingsvc.create(m2);
        meetingsvc.create(m3);

        for (Parent p : parentsvc.findAll()) {
            LOG.info("Parent ============================= > " + p.toString());

            Student s = p.getStudents();
            LOG.info("\t ============================= > " + s.toString());

            for (Teacher t : s.getTeachers()) {
                LOG.info("\t ============================= > " + t.toString());
            }

            for (Meeting m : s.getMeetings()) {
                LOG.info("\t \t============================= > " + m.toString());
                LOG.info("\t\t \t============================= > " + m.getStudent().toString());
                LOG.info("\t\t \t============================= > " + m.getParent().toString());
                LOG.info("\t\t \t============================= > " + m.getTeacher().toString());

            }
        }
    }

}
