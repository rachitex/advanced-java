/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author moon
 */
@Path("StudentRESTApi")
public class StudentRESTApi {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StudentRESTApi
     */
    public StudentRESTApi() {
    }

    /**
     * Retrieves representation of an instance of serve.StudentRESTApi
     * @param name
     * @param father
     * @param education
     * @param course
     * @return an instance of java.lang.String
     */
    @POST
    @Path("/studentDetail")
    @Produces(MediaType.TEXT_HTML)
    public String getHtml(
    @FormParam("txtName") String name,
    @FormParam("txtFather") String father,
    @FormParam("txtEducation") String education,
    @FormParam("course") String course) {
        String result = "Your Info has been Added<br>"
                +"<br>Your Name: "+name
                +"<br>Your Father's Name: "+father
                +"<br>Your Highest Education: "+education
                +"<br>Selected Course: "+course;
        return result;
    }

    /**
     * PUT method for updating or creating an instance of StudentRESTApi
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
