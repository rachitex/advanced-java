/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author moon
 */
public class CheckLogin extends ActionSupport {
    private String user;
    private String password;
    
    public CheckLogin() {
    }
    
    @Override
    public String execute() throws Exception {
        if (getUser().equals("rachit") && getPassword().equals("mishra"))
        return SUCCESS;
    else
        return ERROR;
    }
    
    public String getUser() {
        return user;
    }
    
    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
