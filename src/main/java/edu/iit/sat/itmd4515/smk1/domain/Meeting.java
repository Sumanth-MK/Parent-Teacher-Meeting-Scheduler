/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Future;

/**
 * A parent-teacher meeting can be set by a teacher for a particular student with
 *the student's parent
 *
 * @author Sumanth M K
 */
@Entity
@NamedQuery(name = "Meeting.findAll", query = "Select m from Meeting m")
@NamedQuery(name = "Meeting.findMeetingByStudent", query = "Select m from Meeting m where m.student.id = :ID")
public class Meeting extends AbstractEntity {

    @Future
    private LocalDate date;
    private LocalTime time;
    private String type;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "students_id")
    private Student student;

    //Bi-directional
    @ManyToOne
    private Parent parent;

    //Uni-directional
    //Bi-directional
    @ManyToOne
    private Teacher teacher;

    /**
     *Empty Constructor
     */
    public Meeting() {
    }

    /**
     *
     * @param date
     * @param time
     * @param type
     */
    public Meeting(LocalDate date, LocalTime time, String type) {
        this.date = date;
        this.time = time;
        this.type = type;
    }

    /**
     *Return the value of date
     * @return
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     *Set the value of Date
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     *Return the value of time
     * @return
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     *Set the value of time
     * @param time
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     *Return the value of Type
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *Set the value of type
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *Helper function to add meet with all parameters 
     * @param p
     * @param t
     * @param s
     */
    public void addMeet(Parent p, Teacher t, Student s) {

        this.parent = p;
        this.student = s;
        this.teacher = t;

        if (!p.getMeeting().contains(this)) {
            p.getMeeting().add(this);
        }
        if (!s.getMeetings().contains(this)) {
            s.getMeetings().add(this);
        }
        if (!t.getMeeting().contains(this)) {
            t.getMeeting().add(this);
        }

    }

    /**
     *Helper function to delete the meet with all parameters 
     */
    public void delMeet() {

        if (this.teacher.getMeeting().contains(this)) {
            this.teacher.getMeeting().remove(this);
        }
        
        if (this.parent.getMeeting().contains(this)) {
            this.parent.getMeeting().remove(this);
        }
        this.teacher = null;
        this.student = null;
        this.parent = null;
    }

    /**
     *To String function used for logging
     * @return
     */
    @Override
    public String toString() {
        return "Meeting{" + "id=" + id + ", date=" + date + ", time=" + time + ", type=" + type + '}';
    }

    /**
     *HashCode 
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Meeting other = (Meeting) obj;
        if ((this.id == null) || (other.id == null)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    /**
     *Getter for returning the value of parent
     * @return
     */
    public Parent getParent() {
        return parent;
    }

    /**
     *Setter for assigning the value of parent
     * @param parent
     */
    public void setParent(Parent parent) {
        this.parent = parent;
    }

    /**
     *Getter for returning the value of student
     * @return
     */
    public Student getStudent() {
        return student;
    }

    /**
     *Setter for assigning the value of parent
     * @param student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     *Getter for returning the value of teacher
     * @return
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     *Setter for assigning the value of teacher
     * @param teacher
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
