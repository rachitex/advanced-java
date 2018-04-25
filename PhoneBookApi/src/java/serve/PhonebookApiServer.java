/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import data.PhoneBookBean;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Aman Singh
 */
@Path("phonebook")
public class PhonebookApiServer {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PhonebookApiServer
     */
    public PhonebookApiServer() {
    }

    /**
     * Retrieves representation of an instance of data.PhonebookApiServer
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    @Path("/insertData")
    public void insertData(
    @FormParam("txtName") String name,
    @FormParam("txtMobile") String mobile,
    @FormParam("txtEmail") String email) {
        PhoneBookBean obj = new PhoneBookBean();
        obj.insert(name, mobile, email);
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/viewAllData")
    public String viewAllData() {
        PhoneBookBean obj = new PhoneBookBean();
        List<PhoneBookBean> list = obj.viewAll();
        String header = "<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=100%>"
              +"<tr><th>Name</th><th>Mobile</th><th>Email</th></tr>";
        StringBuffer data = new StringBuffer();
        String footer = "</table>";
        for(PhoneBookBean b:list){
                data.append("<tr><td><center>"+b.getName()+"</center></td>"
               + "<td><center>"+b.getMobile()+"</center></td>"
                        + "<td><center>"+b.getEmail()+"</center></td></tr>");
        }  
        return header+data.toString()+footer;
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    @Path("/viewData")
    public String viewData(@FormParam("txtId") int id) {
        PhoneBookBean obj = new PhoneBookBean();
        List<PhoneBookBean> list = obj.view(id);
        String header = "<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=100%>"
              +"<tr><th>Name</th><th>Mobile</th><th>Email</th></tr>";
        StringBuffer data = new StringBuffer();
        String footer = "</table>";
        for(PhoneBookBean b:list){
                data.append("<tr><td><center>"+b.getName()+"</center></td>"
               + "<td><center>"+b.getMobile()+"</center></td>"
                        + "<td><center>"+b.getEmail()+"</center></td></tr>");
        }  
        return header+data.toString()+footer;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    @Path("/deleteData")
    public String deleteData(@FormParam("txtId") int id) {
        PhoneBookBean obj = new PhoneBookBean();
        obj.delete(id);
        List<PhoneBookBean> list = obj.viewAll();
        String header = "<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=100%>"
              +"<tr><th>Name</th><th>Mobile</th><th>Email</th></tr>";
        StringBuffer data = new StringBuffer();
        String footer = "</table>";
        for(PhoneBookBean b:list){
                data.append("<tr><td><center>"+b.getName()+"</center></td>"
               + "<td><center>"+b.getMobile()+"</center></td>"
                        + "<td><center>"+b.getEmail()+"</center></td></tr>");
        }  
        return header+data.toString()+footer;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    @Path("/updateData")
    public String updateData(
            @FormParam("txtId") int id,
            @FormParam("txtName") String name,
            @FormParam("txtMobile") String mobile,
            @FormParam("txtEmail") String email) {
        PhoneBookBean obj = new PhoneBookBean();
        obj.update(id, name, mobile, email);
        List<PhoneBookBean> list = obj.view(id);
        String header = "<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=100%>"
              +"<tr><th>Name</th><th>Mobile</th><th>Email</th></tr>";
        StringBuffer data = new StringBuffer();
        String footer = "</table>";
        for(PhoneBookBean b:list){
                data.append("<tr><td><center>"+b.getName()+"</center></td>"
               + "<td><center>"+b.getMobile()+"</center></td>"
                        + "<td><center>"+b.getEmail()+"</center></td></tr>");
        }  
        return header+data.toString()+footer;
    }

    /**
     * PUT method for updating or creating an instance of PhonebookApiServer
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
