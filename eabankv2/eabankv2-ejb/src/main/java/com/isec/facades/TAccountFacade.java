/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.facades;

import com.isec.jpa.TAccount;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ljordao
 */
@Stateless
public class TAccountFacade extends AbstractFacade<TAccount> {

    @PersistenceContext(unitName = "eabankv2-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TAccountFacade() {
        super(TAccount.class);
    }
    
    public TAccount getAccountById(int id){
        return this.find(id);
    }
    
}
