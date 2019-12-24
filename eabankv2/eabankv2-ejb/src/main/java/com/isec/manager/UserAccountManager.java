/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.manager;

import com.isec.bank.dto.DTOBankUser;
import com.isec.facades.TUserFacade;
import com.isec.jpa.TUser;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ljordao
 */
@Stateless
public class UserAccountManager {
    
    @EJB
    private TUserFacade tUserFacade;
    
    public UserAccountManager() {
    }
    
    // ---------- Business Methods ---------
    
    public boolean login (String user, String passwd){
        return(tUserFacade.getUserByCredentials(user,passwd) != null);
    }
    
    public DTOBankUser loginv2 (String user, String passwd){
        return mapEntityToDTO(tUserFacade.getUserByCredentials(user,passwd));
    }
    
    // ---------- Business Methods ends ----

    public TUserFacade gettUserFacade() {
        return tUserFacade;
    }

    public void settUserFacade(TUserFacade tUserFacade) {
        this.tUserFacade = tUserFacade;
    }
    
    private DTOBankUser mapEntityToDTO(TUser e){
        
        DTOBankUser dto = new DTOBankUser();
        
        dto.setIdUser(e.getIdUser());
        dto.setUsername(e.getUsername());
        dto.setName(e.getName());
        dto.setNif(e.getNif());
        dto.setCreated_at(e.getCreatedAt());
        
        return dto;
    }
}
