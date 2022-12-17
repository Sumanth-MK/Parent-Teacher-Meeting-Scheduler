/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.*;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

/**
 *
 * @author Sumanth M K
 */
@Entity
@NamedQuery(name="Student.findAll",query="Select s from Student s")
@NamedQuery(name="Student.findByName",query="Select s from Student s where s.name = :NAME")
public class Student extends AbstractEntity{

    @NotBlank
    @Size(min = 3, max = 255)
    @Column(name = "StudentName")
    private String name;
    @NotNull
    @PastOrPresent
    private LocalDate dateofbirth;
    @Enumerated(EnumType.STRING)
    private StudentClass sclass;
    private double gpa;

    //Bi-directional many to many on the inverse side
    @ManyToMany(mappedBy = "students")
    private List<Teacher> teachers = new ArrayList<>();

    //Bi-directional One to Many between Student and meeting
    //This is the inverse side
    @OneToMany(mappedBy = "student")
    private List<Meeting> meetings = new ArrayList<>();
    
    
        
    @OneToMany(mappedBy = "students")
    private List<Parent> parents = new ArrayList<>();
    
    /**
     *Empty Constructor
     */
    public Student() {
    }

    /**
     *Parameterized constructor with all the variables
     * @param name
     * @param dateofbirth
     * @param sclass
     * @param gpa
     */
    public Student(String name, LocalDate dateofbirth, StudentClass sclass, double gpa) {
        this.name = name;
        this.dateofbirth = dateofbirth;
        this.sclass = sclass;
        this.gpa = gpa;
    }

    /**
     *Getter for returning the value of name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *Setter for assigning the value to name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *Getter for returning the value of DOB
     * @return
     */
    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    /**
     *Setter for assigning the value to DOB
     * @param dateofbirth
     */
    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    /**
     *HashCode
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     *Equals
     * @param that
     * @return
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        final Student other = (Student) that;
        if ((this.id == null) || (other.id == null)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    /**
     *Getter for returning the value of Student Class
     * @return
     */
    public StudentClass getSclass() {
        return sclass;
    }

    /**
     *Setter for assigning the value to Student CLass
     * @param sclass
     */
    public void setSclass(StudentClass sclass) {
        this.sclass = sclass;
    }

    /**
     *Getter for returning the value of GPA
     * @return
     */
    public double getGpa() {
        return gpa;
    }

    /**
     *Setter for assigning the value to GPA
     * @param gpa
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    /**
     *To string used for LOGGING
     * @return
     */
    @Override
    public String toString() {
        return "Student{" + "usn=" + id + ", name=" + name + ", dateofbirth=" + dateofbirth + ", sclass=" + sclass + ", gpa=" + gpa + '}';
    }

    /**
     *Getter for returning the set of values of teachers
     * @return
     */
    public List<Teacher> getTeachers() {
        return teachers;
    }

    /**
     *Setter for assigning the set of values to teachers
     * @param teachers
     */
    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    /**
     *Getter for returning the list of meetings
     * @return
     */
    public List<Meeting> getMeetings() {
        return meetings;
    }

    /**
     *Setter for assigning the set of values to meetings
     * @param meetings
     */
    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }


    /**
     *Getter for returning the value of parents
     * @return
     */
    public List<Parent> getParents() {
        return parents;
    }

    /**
     *Setter for assigning the set of values to parents
     * @param parents
     */
    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

}
