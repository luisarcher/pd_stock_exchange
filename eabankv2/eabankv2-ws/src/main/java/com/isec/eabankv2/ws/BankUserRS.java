/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.eabankv2.ws;

import com.isec.bank.dto.DTOBankUser;
import com.isec.facades.TUserFacade;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
 * @author ljordao
 */
@Path("BankUserRS")
public class BankUserRS {

    @Context
    private UriInfo context;

    @EJB
    private TUserFacade facade;
    
    
    /**
     * Creates a new instance of BankUserRS
     */
    public BankUserRS() {
        this.facade = lookupTUserFacadeBean();
    }

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DTOBankUser getUserById(@PathParam("id") int id) {
        return facade.getUserById(id);
    }
    
    @GET
    @Path("/test/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DTOBankUser getUserByIdTest(@PathParam("id") int id) {
        return facade.testRemFacade(id);
    }

    /**
     * Retrieves representation of an instance of com.isec.eabankv2.ws.BankUserRS
     * @return an instance of com.isec.bank.dto.DTOBankUser
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DTOBankUser getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of BankUserRS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(DTOBankUser content) {
    }

    private TUserFacade lookupTUserFacadeBean() {
        try {
            javax.naming.Context c = new InitialContext();
            return (TUserFacade) c.lookup("java:global/eabankv2-ear-1.0/eabankv2-ejb-1.0/TUserFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
