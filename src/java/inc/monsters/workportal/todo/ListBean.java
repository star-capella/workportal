/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inc.monsters.workportal.todo;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author tcurtis
 */
@Named
@RequestScoped
public class ListBean implements Serializable {
    @Inject
    Service service;
    
    private static final Logger LOG = Logger.getLogger(ListBean.class.getName());
    
    private List<Todo> todoList;

    public List<Todo> getTodoList() {
        LOG.info("ListBean:getTodoList()");
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }

    @PostConstruct
    public void init() {
        LOG.info("ListBean:init()");
        
        todoList = service.get();
    }
}
