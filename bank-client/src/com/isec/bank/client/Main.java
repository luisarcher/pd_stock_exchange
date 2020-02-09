/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.bank.client;

import com.isec.bank.client.ws.ClientRS;
import com.isec.bank.dto.DTOBankAccount;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ljordao
 */
public class Main {

    static ClientRS c;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        c = new ClientRS();
        c.setUser("luis");
        c.setPasswd("123");
        
        listAllAccounts();
        System.out.println("");
        getAccountDetails(1000);
        setAccountValue(1000,10);
        
        getAccountDetails(1000);
        
        c.close();
    }
    
    public static void listAllAccounts(){
        Response r = c.getAllAccounts(Response.class, null);
        System.out.println("Status: " + r.getStatus());
        List<DTOBankAccount> list = r.readEntity(new GenericType<List<DTOBankAccount>>(){});
        
        System.out.println("\nlista de contas: ");
        for (DTOBankAccount i: list){
            System.out.println("ID: " + i.getIdAccount() + " - Valor: " + i.getBalance());
        }
    }
    
    public static void getAccountDetails(int accNum){
        String n = Integer.toString(accNum);
        Response r = c.getAccountById(Response.class, n);
        System.out.println("Status: " + r.getStatus());
                
        if (r.getStatus() != 200) return;
        
        DTOBankAccount obj = r.readEntity(new GenericType<DTOBankAccount>(){});
        System.out.println("Detalhes da conta " + accNum);
        System.out.println(obj.getIdAccount());
        System.out.println(obj.getBalance());
    } 
    
    public static void setAccountValue(int accNum, int val){
        String n = Integer.toString(accNum);
        Response r = c.getAccountById(Response.class, n); 
        
        c.setAccountCredits(Response.class, accNum, val);
    }
}
