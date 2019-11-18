/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.eabank.wsbank;

import com.isec.bank.dto.DTOBankUser;
import com.isec.eabank.facade.TUserFacade;
import javax.ejb.EJB;
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
    }

    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DTOBankUser getUserById(@PathParam("id") int id) {
        return facade.getUserById(id);
    }
    /**
     * Retrieves representation of an instance of com.isec.eabank.wsbank.BankUserRS
     * @return an instance of com.isec.bank.dto.DTOBankUser
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public com.isec.bank.dto.DTOBankUser getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of BankUserRS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(com.isec.bank.dto.DTOBankUser content) {
    }
}
