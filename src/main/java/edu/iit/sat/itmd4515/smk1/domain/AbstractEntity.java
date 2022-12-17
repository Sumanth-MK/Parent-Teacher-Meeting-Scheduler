/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.domain;

import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

/**
 *
 * @author Sumanth M K
 */
@MappedSuperclass
public class AbstractEntity {
    
    /**
     *Generate ID using annotations and the type is identity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Version
    private Long version;

    private LocalDateTime createdTimestamp;
    private LocalDateTime updatedTimestamp;

    /**
     *Constructor method
     */
    public AbstractEntity() {
    }

    // lifecycle methods

    /**
     * This is a PrePersist JPA lifecycle method which sets the 
     * createdTimestamp to the current instant
     */
    @PrePersist
    public void createdTimestamp(){
        createdTimestamp = LocalDateTime.now();
    }
    
    /**
     *This is a PrePersist JPA lifecycle method which sets the 
     * updatedTimestamp to the current instant
     */
    @PreUpdate
    public void updatedTimestamp(){
        updatedTimestamp = LocalDateTime.now();
    }
    
    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *Get the value of version
     * @return
     */
    public Long getVersion() {
        return version;
    }

    /**
     *set the value of version
     * @param version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     *get the value of createdTimestamp
     * @return
     */
    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    /**
     *set the value of createdTimestamp
     * @param createdTimestamp
     */
    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    /**
     *get the value of updatedTimestamp
     * @return
     */
    public LocalDateTime getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    /**
     *Set the value of updatedTimestamp
     * @param updatedTimestamp
     */
    public void setUpdatedTimestamp(LocalDateTime updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }
}
