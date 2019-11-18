/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.bank.client;

import com.isec.bank.client.ws.ClientRS;
import com.isec.bank.dto.DTOBankUser;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ljordao
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ClientRS c = new ClientRS();
        
        Response r = c.getUserById(Response.class, "1");
        System.out.println("Status: " + r.getStatus());
        
        DTOBankUser obj = r.readEntity(new GenericType<DTOBankUser>(){});
        System.out.println(obj.getName());
        
        c.close();
        
    }
}
