/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:PhonebookApiServer
 * [phonebook]<br>
 * USAGE:
 * <pre>
 *        PhoneBookApiClient client = new PhoneBookApiClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Aman Singh
 */
public class PhoneBookApiClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/PhoneBookApi/webresources";

    public PhoneBookApiClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("phonebook");
    }

    public void insertData() throws ClientErrorException {
        webTarget.path("insertData").request(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED).post(null);
    }

    public void putHtml(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.TEXT_HTML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_HTML));
    }

    public void close() {
        client.close();
    }
    
}
