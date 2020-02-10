/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.bank.client.ws;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import static javax.ws.rs.client.Entity.entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:BankUserRS [BankUserRS]<br>
 * USAGE:
 * <pre>
 *        ClientRS client = new ClientRS();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author ljordao
 */
public class ClientRS {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://172.1.0.97:8080/eabankv2-ws/webresources";
    
    private String user;
    private String passwd;

    public ClientRS() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("BankRS");
    }
    
    public void putJson(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getAccountById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("account/{0}", new Object[]{id}));
                
        return resource.queryParam("user", user)
                .queryParam("passwd", passwd)
                .request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    
     public <T> T setAccountCredits(Class<T> responseType, int id, int val) {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("balance/{0}", new Object[]{id}));
                
        resource = resource.queryParam("user", user)
                .queryParam("passwd", passwd)
                .queryParam("val", val);
                
         System.out.println(resource.getUri());
        
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);

    }
    
    public <T> T getAllAccounts(Class<T> responseType, String dest) throws ClientErrorException {
        WebTarget resource = webTarget;
        
        resource = resource.queryParam("user", user)
                .queryParam("passwd", passwd);
        
        resource = resource.path("accounts");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getJson(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
