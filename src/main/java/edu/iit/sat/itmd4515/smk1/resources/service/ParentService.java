/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.resources.service;

import edu.iit.sat.itmd4515.smk1.domain.Parent;
import edu.iit.sat.itmd4515.smk1.domain.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sumanth M K
 */
@Named
@Stateless
public class ParentService {

    @PersistenceContext(name = "itmd4515PU")
    private EntityManager em;

    /**
     *
     */
    public ParentService() {
    }
    
    /**
     *
     * @param p
     */
    public void create(Parent p) {
        em.persist(p);
    }

    /**
     *
     * @param id
     * @return
     */
    public Parent read(Long id) {
        return em.find(Parent.class, id);
    }

    /**
     *
     * @param p
     */
    public void update(Parent p) {
        em.merge(p);
    }

    /**
     *
     * @param p
     */
    public void delete(Parent p) {
        em.remove(em.merge(p));
    }
    
    /**
     *
     * @return
     */
    public List<Parent> findAll(){
        List<Parent> parents = new ArrayList<>();
        parents = em.createNamedQuery("Parent.findAll", Parent.class).getResultList();
        return parents;
    }
   
    /**
     *
     * @param id
     * @return
     */
    public List<Parent> findbyStudentID(Long id){
       return em.createNamedQuery("Parent.findStudentById", Parent.class).setParameter("ID", id).getResultList();
   }
    
      public Parent findByUsername(String username) {
        return em.createNamedQuery("Parent.findByUsername", Parent.class)
                .setParameter("username", username)
                .getSingleResult();

    }

}
