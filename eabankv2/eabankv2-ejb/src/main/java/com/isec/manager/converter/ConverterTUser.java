/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.manager.converter;

import com.isec.jpa.TUser;
import com.isec.bank.dto.DTOBankUser;

/**
 *
 * @author ljordao
 */
public class ConverterTUser {
    
    public static DTOBankUser mapEntityToDTO(TUser e){
        
        DTOBankUser dto = new DTOBankUser();
        
        dto.setIdUser(e.getIdUser());
        dto.setUsername(e.getUsername());
        dto.setName(e.getName());
        dto.setNif(e.getNif());
        dto.setCreated_at(e.getCreatedAt());
        
        return dto;
    }
    
    /*public static TUser mapDTOToEntity(DTOBankUser dto){
        
        TUser e = new TUser();
        
        
        return e;
    }*/
    
}
