/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.eabankv2.ws;

import com.isec.bank.dto.DTOBankAccount;
import com.isec.bank.dto.DTOBankUser;
import com.isec.facades.TUserFacade;
import com.isec.manager.UserAccountManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author ljordao
 */
@Path("BankRS")
//@SessionScoped
public class BankRS {

    @Context
    private UriInfo context;
    
    @EJB
    private UserAccountManager manager;
    
    //private DTOBankUser user;
    
    
    /**
     * Creates a new instance of BankUserRS
     */
    public BankRS() {
        //this.facade = lookupTUserFacadeBean();
        this.manager = lookupUserAccountManagerBean();
    }

    @GET
    @Path("/account/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DTOBankAccount getAccountById(
            @PathParam("id") int id, 
            @QueryParam("user") String user,
            @QueryParam("passwd") String passwd) {
        
        DTOBankAccount account = manager.getUserAccount(id, user, passwd);
        
        if (account == null){
            throw new ForbiddenException();
        }
        return account;
    }
    
    /*@GET
    @Path("/accounts")
    @Produces(MediaType.APPLICATION_JSON)
    public DTOBankUser getUserAccounts(@PathParam("id") int id) {
        return facade.getUserById(id);
    }*/
        
    /**
     *
     * @param user
     * @param passwd
     * @return 
     */
        
    ///accounts?user=user1&pass=123
            
    ///accounts?token=67427343v2u342bhjurw
    
    //POST
    ///account/1?val=50?user=___&pass=____
    // @PathParam("id")

    /**
     * Retrieves representation of an instance of com.isec.eabankv2.ws.BankRS
     * @return an instance of com.isec.bank.dto.DTOBankUser
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DTOBankUser getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of BankRS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(DTOBankUser content) {
    }
    
    private UserAccountManager lookupUserAccountManagerBean() {
        try {
            javax.naming.Context c = new InitialContext();
            return (UserAccountManager) c.lookup("java:global/eabankv2-ear-1.0/eabankv2-ejb-1.0/UserAccountManager");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
