/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.manager.converter;

import com.isec.jpa.TAccount;
import com.isec.bank.dto.DTOBankAccount;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ljordao
 */
public class ConverterTAccount {
    
    public static DTOBankAccount mapEntityToDTO(TAccount e){
        
        DTOBankAccount dto = new DTOBankAccount();
                
        dto.setIdAccount(e.getIdAccount());
        dto.setStatus(e.getIdStatus());
        dto.setBalance(e.getBalance());
        dto.setCreated_at(e.getCreatedAt());
        dto.setIdUser(e.getIdUser().getIdUser());
        
        return dto;
    }
    
    /*public static TUser mapDTOToEntity(DTOStocksCompany dto){
        
        
        return e;
    }*/
    
    public static List<DTOBankAccount> mapAllEntitiesToDTO(List<TAccount> list){
        
        List<DTOBankAccount> entityDtoList = new ArrayList<>();
        Iterator<TAccount> it = list.iterator();
        
        while(it.hasNext()){
            TAccount e = it.next();
            entityDtoList.add(mapEntityToDTO(e));
        }
        
        return entityDtoList;
        
    }
    
}
