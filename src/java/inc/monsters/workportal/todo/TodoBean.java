/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inc.monsters.workportal.todo;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

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

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "TodoBean{" + "title=" + title + '}';
    }
    
    @PostConstruct
    public void init() {
        Todo todo;
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String id = request.getParameter("id");
        System.out.println(id);
        
        if (id != null) {
            System.out.println("long: " + Long.parseLong(id));
            todo = service.get(Long.parseLong(id));
            
            // add id here!!!
            this.title = todo.getTitle();
            this.description = todo.getDescription();
        }
    }
    
    /**
     *
     */
    public void add() {
        LOG.info("TodoBean:add()");
        Todo todo = new Todo();
        todo.setTitle(this.title);
        todo.setDescription(description);
        service.add(todo);
    }
}
