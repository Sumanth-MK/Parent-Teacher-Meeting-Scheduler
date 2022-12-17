/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smk1.security;

import edu.iit.sat.itmd4515.smk1.domain.Parent;
import edu.iit.sat.itmd4515.smk1.domain.Teacher;
import edu.iit.sat.itmd4515.smk1.resources.service.AbstractService;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Sumanth M K
 */
@Stateless
public class UserService extends AbstractService<User> {

    /**
     *
     */
    public UserService() {
        super(User.class);
    }

    /**
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        return em.createNamedQuery("User.findAll", User.class).getResultList();

    }

    /**
     *
     * @param p
     */
    public void addNewParentUser(Parent p) {
        //create non-owning entity at first

        Group parentGroup
                = em.createQuery("select g from Group g where g.groupName = 'PARENT_GROUP'", Group.class).getSingleResult();
        p.getUsers().addGroup(parentGroup);
        p.getUsers().setEnabled(true);
        em.persist(p.getUsers());

        // then we persist the owning entity
        em.persist(p);
    }
    
    /**
     *
     * @param t
     */
    public void addNewTeacherUser(Teacher t) {
        //create non-owning entity at first

        Group teacherGroup
                = em.createQuery("select g from Group g where g.groupName = 'TEACHER_GROUP'", Group.class).getSingleResult();
        t.getUsers().addGroup(teacherGroup);
        t.getUsers().setEnabled(true);
        em.persist(t.getUsers());

        // then we persist the owning entity
        em.persist(t);
    }
}
