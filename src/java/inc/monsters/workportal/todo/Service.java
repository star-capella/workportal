/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inc.monsters.workportal.todo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tcurtis
 */
@Stateless
public class Service {
    @PersistenceContext
    private EntityManager em;
    
    public void add(Todo _todo) {
        em.persist(_todo);
    }
}
