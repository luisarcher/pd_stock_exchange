/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.facades;

import com.isec.jpa.TAccount;
import com.isec.jpa.TUser;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    public List<TAccount> getAllAccountsByUser(TUser id){
        
        List<TAccount> list = null;
                
        try {
            
            list = new ArrayList<>(em.createQuery("SELECT t FROM TAccount t WHERE t.idUser = :idUser")
                    .setParameter("idUser", id)
                    .getResultList());
            
        } catch (NoResultException e){
            System.err.println("TAccount list : ERROR : No accounts for (user: "+ id +") : " + e.getMessage());
        } catch (Exception e){
            System.err.println("TAccount list : ERROR : (user: "+ id +") : " + e.getMessage());
        }
        return list;
    }
    
}
