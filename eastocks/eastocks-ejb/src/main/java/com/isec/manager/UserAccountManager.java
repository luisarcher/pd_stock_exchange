/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.manager;

import com.isec.stocks.dto.DTOStocksUser;
import com.isec.facade.TUserFacade;
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
    
    public DTOStocksUser loginv2 (String user, String passwd){
        return mapEntityToDTO(tUserFacade.getUserByCredentials(user,passwd));
    }
    
    public void register(DTOStocksUser dto){
        this.tUserFacade.create(mapDTOToEntity(dto));
    }                                                                                                                                  
        
    // ---------- Business Methods ends ----

    public TUserFacade gettUserFacade() {
        return tUserFacade;
    }

    public void settUserFacade(TUserFacade tUserFacade) {
        this.tUserFacade = tUserFacade;
    }
    
    private DTOStocksUser mapEntityToDTO(TUser e){
        
        DTOStocksUser dto = new DTOStocksUser();
        
        dto.setIdUser(e.getIdUser());
        dto.setUsername(e.getUsername());
        
        return dto;
    }
    
    private TUser mapDTOToEntity(DTOStocksUser dto){
        
        TUser e = new TUser();
        
        e.setUsername(dto.getUsername());
        e.setPasswd(dto.getPasswd());
        
        return e;
    }
}
