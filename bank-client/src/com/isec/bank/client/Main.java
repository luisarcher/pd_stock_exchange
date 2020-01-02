/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.bank.client;

import com.isec.bank.client.ws.ClientRS;
import com.isec.bank.dto.DTOBankAccount;
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
        c.setUser("luis");
        c.setPasswd("123");
        
        
        Response r = c.getAccountById(Response.class, "1000");
        System.out.println("Status: " + r.getStatus());
                
        if (r.getStatus() != 200) return;
        
        DTOBankAccount obj = r.readEntity(new GenericType<DTOBankAccount>(){});
        System.out.println(obj.getIdAccount());
        System.out.println(obj.getBalance());
        
        c.close();
        
    }
}
