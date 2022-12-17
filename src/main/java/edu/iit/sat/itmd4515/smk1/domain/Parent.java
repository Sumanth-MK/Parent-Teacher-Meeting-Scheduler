/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.domain;

import edu.iit.sat.itmd4515.smk1.security.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Sumanth M K
 */
@Entity
@NamedQuery(name = "Parent.findAll", query = "Select p from Parent p")
@NamedQuery(name = "Parent.findStudentById", query = "Select p from Parent p where p.students.id = :ID")
@NamedQuery(name="Parent.findByUsername", query="Select p from Parent p where p.users.userName = :username")
public class Parent extends AbstractNamedEntity {

    @OneToMany(mappedBy = "parent")
    private List<Meeting> meeting = new ArrayList<>();

//    @OneToOne
//    //@JoinColumn(name = "student_parentID")
//    private Student students;
    @ManyToOne
    private Student students;

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User users;

    /**
     *Empty Constructor
     */
    public Parent() {
    }

    /**
     *Constructor for the variable name
     * @param name
     */
    public Parent(String name) {
        this.name = name;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    
    @Override
    public String toString() {
        return "Parent{" + "id=" + id + ", name=" + name 
                + "user=" + users + '}';
    }

    /**
     *Hashcode
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     *Equals
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
        final Parent other = (Parent) obj;
        if ((this.id == null) || (other.id == null)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    /**
     *Getter for returning the List of meetings
     * @return
     */
    public List<Meeting> getMeeting() {
        return meeting;
    }

    /**
     *Setter for assigning the value to Meeting
     * @param meeting
     */
    public void setMeeting(List<Meeting> meeting) {
        this.meeting = meeting;
    }


    /**
     *Getter for returning the value of users
     * @return
     */
    public User getUsers() {
        return users;
    }

    /**
     *Setter for assigning the value to the users
     * @param users
     */
    public void setUsers(User users) {
        this.users = users;
    }

    /**
     *Getter for returning the value of students
     * @return
     */
    public Student getStudents() {
        return students;
    }

    /**
     *Setter for assigning the value to students
     * @param students
     */
    public void setStudents(Student students) {
        this.students = students;
    }

}
