package controller;

import com.opensymphony.xwork2.ActionSupport;
import model.User;

public class CheckLogin extends ActionSupport {
    private String user;
    private String password;
    
    public CheckLogin() {
    }
    
    
    @Override
    public String execute() throws Exception {
        User obj = new User();
        if (getUser().equals(obj.getUser()) && getPassword().equals(obj.getPassword()))
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
