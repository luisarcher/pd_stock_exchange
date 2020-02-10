/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.manager;

import com.isec.bank.dto.DTOBankAccount;
import com.isec.bank.dto.DTOBankUser;
import com.isec.facades.TAccountFacade;
import com.isec.facades.TAdminFacade;
import com.isec.facades.TUserFacade;
import com.isec.jpa.TAccount;
import com.isec.jpa.TUser;
import com.isec.manager.converter.ConverterTAccount;
import com.isec.manager.converter.ConverterTUser;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ljordao
 */
@Stateless
public class UserAccountManager {
    
    @EJB
    private TUserFacade tUserFacade;
    
    @EJB
    private TAccountFacade tAccountFacade;
    
    @EJB
    private TAdminFacade tAdminFacade;
    
    public UserAccountManager() {
    }
    
    // ---------- Business Methods ---------
    
    public boolean login (String user, String passwd){
        return(tUserFacade.getUserByCredentials(user,passwd) != null);
    }
    
    public DTOBankUser loginv2 (String user, String passwd){
        return ConverterTUser.mapEntityToDTO(tUserFacade.getUserByCredentials(user,passwd));
    }
    
    public DTOBankAccount getUserAccount(int id, String user, String passwd){

        if (this.tAdminFacade.isAdmin(user, passwd)){
            return ConverterTAccount.mapEntityToDTO(this.tAccountFacade.getAccountById(id));
        } else {
            TUser auth = tUserFacade.getUserByCredentials(user,passwd);
            if (auth == null){
                return null;
            } else {
                // Gets account by id
                DTOBankAccount acc = ConverterTAccount.mapEntityToDTO(this.tAccountFacade.getAccountById(id));
                if (acc != null){
                    // If this account belongs to the user, he is able to read it.
                    if (auth.getIdUser().equals(acc.getIdUser())){
                        return acc;
                    }
                }
            }
        }
        return null;
    }
    
    public DTOBankAccount setAccountValue(int id, String user, String passwd, int val){

        TUser auth = tUserFacade.getUserByCredentials(user,passwd);

        DTOBankAccount acc = ConverterTAccount.mapEntityToDTO(this.tAccountFacade.getAccountById(id));
        if (acc != null){
            // If this account belongs to the user, he is able to read it.
            if (auth.getIdUser().equals(acc.getIdUser())){
                acc.setBalance(acc.getBalance()+val);
                return acc;
            }
        }
        return acc;
    }
   
    
    /*public DTOBankAccount getUserAccount(int id, String auth){
        // Not supported yet!
    }*/
    
    public List<DTOBankAccount> getAllAccounts(String user, String passwd){
        
        TUser auth = tUserFacade.getUserByCredentials(user,passwd);
        if (auth == null){
            return null;
        } else {
            return ConverterTAccount.mapAllEntitiesToDTO(this.tAccountFacade.getAllAccountsByUser(auth));
        }
    }
    
    // ---------- Business Methods ends ----

    public TUserFacade gettUserFacade() {
        return tUserFacade;
    }

    public void settUserFacade(TUserFacade tUserFacade) {
        this.tUserFacade = tUserFacade;
    }
}
