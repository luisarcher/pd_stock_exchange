/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.manager.converter;

import com.isec.jpa.TCompany;
import com.isec.stocks.dto.DTOStocksCompany;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ljordao
 */
public class ConverterTCompany {
    
    public static DTOStocksCompany mapEntityToDTO(TCompany e){
        
        DTOStocksCompany dto = new DTOStocksCompany();
        
        dto.setIdCompany(e.getIdCompany());
        dto.setArea(e.getArea());
        dto.setDescription(e.getDescription());
        dto.setSharePrice(e.getSharePrice());
        dto.setShareQuant(e.getShareQuant());
        
        return dto;
    }
    
    /*public static TUser mapDTOToEntity(DTOStocksCompany dto){
        
        
        
        return e;
    }*/
    
    public static List<DTOStocksCompany> mapAllEntitiesToDTO(List<TCompany> list){
        
        List<DTOStocksCompany> entityDtoList = new ArrayList<>();
        Iterator<TCompany> it = list.iterator();
        
        while(it.hasNext()){
            TCompany e = it.next();
            entityDtoList.add(mapEntityToDTO(e));
        }
        
        return entityDtoList;
        
    }
    
}
