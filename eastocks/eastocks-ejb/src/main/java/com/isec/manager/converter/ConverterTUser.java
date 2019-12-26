/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.manager.converter;

import com.isec.jpa.TUser;
import com.isec.stocks.dto.DTOStocksUser;

/**
 *
 * @author ljordao
 */
public class ConverterTUser {
    
    public static DTOStocksUser mapEntityToDTO(TUser e){
        
        DTOStocksUser dto = new DTOStocksUser();
        
        dto.setIdUser(e.getIdUser());
        dto.setUsername(e.getUsername());
        
        return dto;
    }
    
    public static TUser mapDTOToEntity(DTOStocksUser dto){
        
        TUser e = new TUser();
        
        e.setUsername(dto.getUsername());
        e.setPasswd(dto.getPasswd());
        
        return e;
    }
    
}
