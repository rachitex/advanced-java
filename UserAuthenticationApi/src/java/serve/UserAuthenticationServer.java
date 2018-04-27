/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author moon
 */
@Path("userauth")
public class UserAuthenticationServer {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserAuthenticationServer
     */
    public UserAuthenticationServer() {
    }

    /**
     * Retrieves representation of an instance of serve.UserAuthenticationServer
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("check")
    public Response checkLogin(
    @QueryParam("user") String user,
    @QueryParam("pass") String password) {
        if(user.equals("rachit") && password.equals("mishra")){
            String yes = "Login Successful! Welcome "+user;
            return Response.status(200).entity(yes).build();
        }else{
            String no = "Invalid Username or Password";
            return Response.status(0).entity(no).build();
        }
    }

    /**
     * PUT method for updating or creating an instance of UserAuthenticationServer
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
