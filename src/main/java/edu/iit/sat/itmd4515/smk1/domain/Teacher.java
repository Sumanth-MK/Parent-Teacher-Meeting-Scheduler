/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.domain;

import edu.iit.sat.itmd4515.smk1.security.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.PastOrPresent;

/**
 *
 * @author Sumanth M K
 */
@Entity
@NamedQuery(name = "Teacher.findAll", query = "Select t from Teacher t")
@NamedQuery(name="Teacher.findByUsername", query="Select t from Teacher t where t.users.userName = :username")
public class Teacher extends AbstractNamedEntity {

    private String course;
    @PastOrPresent
    private LocalDate dob;
    @OneToOne
    @JoinColumn(name="USERNAME")
    private User users;

    @OneToMany(mappedBy = "teacher")
    private List<Meeting> meeting = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "Teacher_Students",
            joinColumns = @JoinColumn(name = "Teacher_ID"),
            inverseJoinColumns = @JoinColumn(name = "Student_ID"))
    private List<Student> students = new ArrayList<>();

    /**
     *
     */
    public Teacher() {
    }

    /**
     *
     * @param name
     * @param course
     * @param dob
     */
    public Teacher(String name, String course, LocalDate dob) {
        this.name = name;
        this.course = course;
        this.dob = dob;
    }

    //Helper methods for adding 

    /**
     *
     * @param s
     */
    public void addStudent(Student s) {
        if (!this.students.contains(s)) {
            this.students.add(s);
        }
        if (!s.getTeachers().contains(this)) {
            s.getTeachers().add(this);
        }

    }

    //Helper method for removing 

    /**
     *
     * @param s
     */
    public void removeStudent(Student s) {
        if (this.students.contains(s)) {
            this.students.remove(s);
        }
        if (s.getTeachers().contains(this)) {
            s.getTeachers().remove(this);
        }

    }

    /**
     *
     * @return
     */
    public String getCourse() {
        return course;
    }

    /**
     *
     * @param course
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     *
     * @return
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     *
     * @param dob
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

//    @Override
//    public String toString() {
//        return "Teacher{" + "id=" + id + ", name=" + name + ", course=" + course + ", dob=" + dob + '}';
//    }
    
    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Teacher other = (Teacher) obj;
        if ((this.id == null) || (other.id == null)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    /**
     *
     * @return
     */
    public List<Meeting> getMeeting() {
        return meeting;
    }

    /**
     *
     * @param meeting
     */
    public void setMeeting(List<Meeting> meeting) {
        this.meeting = meeting;
    }

    /**
     *
     * @return
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     *
     * @param students
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     *
     * @return
     */
    public User getUsers() {
        return users;
    }

    /**
     *
     * @param users
     */
    public void setUsers(User users) {
        this.users = users;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", name=" + name + ", course=" + course + ", dob=" + dob + ", users=" + users + '}';
    }

}
