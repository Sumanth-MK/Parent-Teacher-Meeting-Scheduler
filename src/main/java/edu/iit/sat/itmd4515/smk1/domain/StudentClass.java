/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.domain;

/**
 *
 * @author Sumanth M K
 */
public enum StudentClass {

    /**
     *ENUM
     */
    Physics("Physics"),

    /**
     *ENUM
     */
    Chemistry("Chemistry"),

    /**
     *ENUM
     */
    Mathematics("Mathematics"),

    /**
     *ENUM
     */
    Biology("Biology"),

    /**
     *ENUM
     */
    History("History"),

    /**
     *ENUM
     */
    Economics("Economics"),

    /**
     *ENUM
     */
    Geography("Geography");

    private String description;

    private StudentClass(String description) {
        this.description = description;
    }
    
    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

}
