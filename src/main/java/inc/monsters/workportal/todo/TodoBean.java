/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inc.monsters.workportal.todo;

import java.io.Serializable;
import java.util.logging.Logger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author tcurtis
 */
@Named
@RequestScoped
public class TodoBean implements Serializable {  
    private static final long serialVersionUID = 1L;
    
    @Inject
    Service service;
    
    private static final Logger LOG = Logger.getLogger(TodoBean.class.getName());
    
    private Long id;
    private String title;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        
        if (id != null) {
            todo = service.get(Long.parseLong(id));
            this.id = todo.getId();
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
        todo.setId(this.id);
        todo.setTitle(this.title);
        todo.setDescription(this.description);
        service.add(todo);
    }
}
