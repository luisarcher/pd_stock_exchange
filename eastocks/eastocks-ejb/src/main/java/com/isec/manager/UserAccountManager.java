/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.manager;

import com.isec.stocks.dto.DTOStocksUser;
import com.isec.facade.TUserFacade;
import com.isec.manager.converter.ConverterTUser;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserAccountManager implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private TUserFacade tUserFacade;
    
    public UserAccountManager() {
    }
    
    // ---------- Business Methods ---------
    
    public boolean login (String user, String passwd){
        return(tUserFacade.getUserByCredentials(user,passwd) != null);
    }
    
    public DTOStocksUser loginv2 (String user, String passwd){
        return ConverterTUser.mapEntityToDTO(tUserFacade.getUserByCredentials(user,passwd));
    }
    
    public void register(DTOStocksUser dto){
        this.tUserFacade.create(ConverterTUser.mapDTOToEntity(dto));
    }                                                                                                                                  
        
    // ---------- Business Methods ends ----
    
    // ---------- Getters and Setters ---------
    
    public DTOStocksUser getUserById(int id){
        return ConverterTUser.mapEntityToDTO(tUserFacade.find(id));
    }

    public TUserFacade gettUserFacade() {
        return tUserFacade;
    }

    public void settUserFacade(TUserFacade tUserFacade) {
        this.tUserFacade = tUserFacade;
    }
    
}
