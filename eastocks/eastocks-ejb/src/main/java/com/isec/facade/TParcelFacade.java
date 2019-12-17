/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.facade;

import com.isec.jpa.TParcel;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ljordao
 */
@Stateless
public class TParcelFacade extends AbstractFacade<TParcel> {

    @PersistenceContext(unitName = "eastocks-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TParcelFacade() {
        super(TParcel.class);
    }
    
}
