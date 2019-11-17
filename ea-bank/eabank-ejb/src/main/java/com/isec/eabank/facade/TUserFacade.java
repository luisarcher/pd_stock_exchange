/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.eabank.facade;

import com.isec.bank.dto.DTOBankUser;
import com.isec.jpa.TUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ljordao
 */
@Stateless
public class TUserFacade extends AbstractFacade<TUser> {

    @PersistenceContext(unitName = "eabank-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TUserFacade() {
        super(TUser.class);
    }
    
    public DTOBankUser getUserById(Integer id){
        return mapEntityToDTO(this.find(id));
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
