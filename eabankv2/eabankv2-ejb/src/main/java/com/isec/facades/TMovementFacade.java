/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.facades;

import com.isec.jpa.TMovement;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ljordao
 */
@Stateless
public class TMovementFacade extends AbstractFacade<TMovement> {

    @PersistenceContext(unitName = "eabankv2-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TMovementFacade() {
        super(TMovement.class);
    }
    
}
