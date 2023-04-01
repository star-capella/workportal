/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inc.monsters.workportal.todo;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 *
 * @author tcurtis
 */
@Named
@RequestScoped
public class ListBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Inject
    Service service;
    
    private static final Logger LOG = Logger.getLogger(ListBean.class.getName());
    
    private List<Todo> todoList;

    /**
     *
     * @return
     */
    public List<Todo> getTodoList() {
        LOG.info("ListBean:getTodoList()");
        return todoList;
    }

    /**
     *
     * @param todoList
     */
    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }

    /**
     *
     */
    @PostConstruct
    public void init() {
        LOG.info("ListBean:init()");
        
        todoList = service.getAll();
    }
}
