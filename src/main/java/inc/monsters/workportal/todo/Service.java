/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inc.monsters.workportal.todo;

import java.util.List;
import java.util.logging.Logger;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author tcurtis
 */
@Stateless
public class Service {
    private static final Logger LOG = Logger.getLogger(Service.class.getName());
    
    @PersistenceContext
    private EntityManager em;
    
    /**
     *
     * @param _todo
     */
    public void add(Todo _todo) {
        LOG.info("Service:getAll()");
        em.merge(_todo);
    }
    
    /**
     *
     * @return
     */
    public List<Todo> getAll() {
        LOG.info("Service:getAll()");
        return em.createQuery("SELECT t FROM Todo t", Todo.class).getResultList();
    }
    
    public Todo get(Long _id) {
        LOG.info("Service:get()");
        return em.find(Todo.class, _id);
    }
}
