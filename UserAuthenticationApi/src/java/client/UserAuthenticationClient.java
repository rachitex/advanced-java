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
 * Jersey REST client generated for REST resource:UserAuthenticationServer
 * [userauth]<br>
 * USAGE:
 * <pre>
 *        UserAuthenticationClient client = new UserAuthenticationClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author moon
 */
public class UserAuthenticationClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/UserAuthenticationApi/webresources";

    public UserAuthenticationClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("userauth");
    }

    public void putHtml(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.TEXT_HTML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_HTML));
    }

    public <T> T checkLogin(Class<T> responseType, String pass, String user) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (pass != null) {
            resource = resource.queryParam("pass", pass);
        }
        if (user != null) {
            resource = resource.queryParam("user", user);
        }
        resource = resource.path("check");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
