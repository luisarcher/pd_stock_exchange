/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.eabankv2.ws;

import com.isec.bank.dto.DTOBankAccount;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author ljordao
 */
@Path("BankAccountRS")
public class BankAccountRS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BankAccountRS
     */
    public BankAccountRS() {
    }

    /**
     * Retrieves representation of an instance of com.isec.eabankv2.ws.BankAccountRS
     * @return an instance of com.isec.bank.dto.DTOBankAccount
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DTOBankAccount getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of BankAccountRS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(DTOBankAccount content) {
    }
}
