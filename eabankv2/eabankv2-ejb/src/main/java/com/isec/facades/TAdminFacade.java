/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.facades;

import com.isec.jpa.TAdmin;
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
public class TAdminFacade extends AbstractFacade<TAdmin> {

    @PersistenceContext(unitName = "eabankv2-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TAdminFacade() {
        super(TAdmin.class);
    }
    
    public TAdmin getUserByCredentials(String username, String passwd){
        
        TAdmin user = null;
        
        Query query = em.createQuery("SELECT t FROM TUser t WHERE t.username = :username AND t.passwd = :passwd");
        query.setParameter("username", username);
        query.setParameter("passwd", passwd);
        
        try {
            user = (TAdmin)query.getSingleResult();
            
        } catch (NoResultException e){
            System.err.println("TUser : ERROR : No result for (" +username + ","+ passwd +") : " + e.getMessage());
        } catch (NonUniqueResultException e){
            System.err.println("TUser : ERROR : Multiple results for (" +username + ","+ passwd +") : " + e.getMessage());
        } catch (Exception e){
            System.err.println("TUser : ERROR : (" +username + ","+ passwd +") : " + e.getMessage());
        }
        return user;
    }
    
    public boolean isAdmin(String username, String passwd){
        return (this.getUserByCredentials(username, passwd) != null);
    }
    
}
