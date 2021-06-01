package com.example.discover;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;


@Named
@SessionScoped
public class HelloBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    RedisBean redisBean;


    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {

        this.name = name;
        redisBean.putValue("name",name);
    }


    public  String getRedisValue(){
       return redisBean.getValue("name");
    }

    public String getHostName(){
        FacesContext facesContext = FacesContext.getCurrentInstance();

        HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();

        return req.getLocalName();
    }
    public String getSessionId() {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

        HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse res = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();


        String jsessionid = session.getId();
        return jsessionid;
    }



}
