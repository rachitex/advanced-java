/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author moon
 */
@Path("CurrencyConversion")
public class CurrencyConversion {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CurrencyConversion
     */
    public CurrencyConversion() {
    }

    
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("{inr}")
    public String getHtml(@PathParam("inr") String INR) {
        double inr = Double.parseDouble(INR);
        double dollar = inr / 65;
        double euro = inr / 80;
        double yen = inr / 0.60;
        String answer = ""
                + "Dollars: "+dollar
                + "<br>Euros: "+euro
                + "<br>Yen: "+yen;
        return answer;
    }
    
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
