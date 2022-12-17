/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.domain;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Sumanth M K
 */
@MappedSuperclass
public class AbstractNamedEntity extends AbstractEntity {

    /**
     *Declaring a variable name which will not be blank
     */
    @NotBlank
    protected String name;

    /**
     * Get the value of name
     *
     * @return
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

}
