/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.beans.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moon
 */
public class PhoneBookBean implements Serializable {
    
    private int id;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }

    public PhoneBookBean() {
    }
    
    private String name;

    private String mobile;

    /**
     * Get the value of mobile
     *
     * @return the value of mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Set the value of mobile
     *
     * @param mobile new value of mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    private String email;

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    DBConfiguration obj = new DBConfiguration();
    Connection con = obj.gettingConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    public void insert(String name, String mobile, String email){
        setName(name);
        setMobile(mobile);
        setEmail(email);
        
        String insertQuery = "INSERT INTO contact(name, mobile, email) values(?, ?, ?)";
        try{
            stmt = con.prepareStatement(insertQuery);
            stmt.setString(1, name);
            stmt.setString(2, mobile);
            stmt.setString(3, email);
            stmt.executeUpdate();
            stmt.close();
        }catch(Exception e){
        }
    }
    
    public List<PhoneBookBean> view(int id){
        setId(id);
        String selectQuery = "SELECT * FROM CONTACT WHERE id = ?";
        List<PhoneBookBean> phonebookbeans = new ArrayList<PhoneBookBean>();
        try{
            stmt = con.prepareStatement(selectQuery);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while(rs.next()){
                PhoneBookBean phonebookbean = new PhoneBookBean();
                phonebookbean.setId(rs.getInt("id"));
                phonebookbean.setName(rs.getString("name"));
                phonebookbean.setMobile(rs.getString("mobile"));
                phonebookbean.setEmail(rs.getString("email"));
                phonebookbeans.add(phonebookbean);
            }
            rs.close();
            stmt.close();
        }catch(Exception e){
        }
        return phonebookbeans;
    }
    
    public List<PhoneBookBean> viewAll(){
        String selectQuery = "SELECT * FROM CONTACT";
        List<PhoneBookBean> phonebookbeans = new ArrayList<PhoneBookBean>();
        try{
            stmt = con.prepareStatement(selectQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                PhoneBookBean phonebookbean = new PhoneBookBean();
                phonebookbean.setId(rs.getInt("id"));
                phonebookbean.setName(rs.getString("name"));
                phonebookbean.setMobile(rs.getString("mobile"));
                phonebookbean.setEmail(rs.getString("email"));
                phonebookbeans.add(phonebookbean);
        }
        }catch(Exception e){
        }finally{
            try{
                rs.close();
                stmt.close();
            }catch(Exception e){
            }   
        }
        return phonebookbeans;
    }

    public void update(int id, String name, String mobile, String email){
        setId(id);
        setName(name);
        setMobile(mobile);
        setEmail(email);
        String updateQuery = "UPDATE CONTACT SET name = ?, mobile = ?, email = ?"
                + " WHERE id = ?";
        try{
            stmt = con.prepareStatement(updateQuery);
            stmt.setString(1, name);
            stmt.setString(2, mobile);
            stmt.setString(3, email);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            stmt.close();
        }catch(Exception e){
        }
    }
    
    public void delete(int id){
        setId(id);
        String deleteQuery = "DELETE FROM CONTACT WHERE id = ?";
        try{
            stmt = con.prepareStatement(deleteQuery);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        }catch(Exception e){
        }
    }
}
