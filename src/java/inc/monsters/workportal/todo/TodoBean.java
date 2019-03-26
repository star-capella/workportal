/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inc.monsters.workportal.todo;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author tcurtis
 */
@Named
@RequestScoped
public class TodoBean implements Serializable {  
    @Inject
    Service service;
    
    private static final Logger LOG = Logger.getLogger(TodoBean.class.getName());
    
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TodoBean{" + "title=" + title + '}';
    }
    
    public void add() {
        LOG.info("TodoBean:add()");
        Todo todo = new Todo();
        todo.setTitle(this.title);
        todo.setDescription(description);
        service.add(todo);
    }
}
