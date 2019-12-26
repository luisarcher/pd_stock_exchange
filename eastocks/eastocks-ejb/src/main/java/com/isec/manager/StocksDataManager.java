/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.manager;

import com.isec.facade.TCompanyFacade;
import com.isec.jpa.TUser;
import com.isec.manager.converter.ConverterTCompany;
import com.isec.stocks.dto.DTOStocksCompany;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class StocksDataManager implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private TCompanyFacade tCompanyFacade;
    
    public StocksDataManager() {
    }
    
    // ---------- Business Methods ---------
    
    public List<DTOStocksCompany> getAllCompanies(){
        return ConverterTCompany.mapAllEntitiesToDTO(tCompanyFacade.findAll());
    }                                                                                                                    
        
    // ---------- Business Methods ends ----
    
}
