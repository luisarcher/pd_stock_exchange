/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.facades;

import com.isec.bank.dto.DTOBankUser;
import com.isec.jpa.TUser;
import java.util.Date;
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
public class TUserFacade extends AbstractFacade<TUser> {

    @PersistenceContext(unitName = "eabankv2-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TUserFacade() {
        super(TUser.class);
    }
        
    public DTOBankUser getUserById(Integer id){
        return mapEntityToDTO(this.find(id));
    }
    
    public DTOBankUser testRemFacade(Integer id){
        return new DTOBankUser(id,"username_test","name_test","12345678",new Date());
    }
    
    private DTOBankUser mapEntityToDTO(TUser e){
        
        DTOBankUser dto = new DTOBankUser();
        
        dto.setIdUser(e.getIdUser());
        dto.setUsername(e.getUsername());
        dto.setName(e.getName());
        dto.setNif(e.getNif());
        dto.setCreated_at(e.getCreatedAt());
        
        return dto;
    }
    
    public TUser getUserByCredentials(String username, String passwd){
        
        TUser user = new TUser();
        
        Query query = em.createQuery("SELECT t FROM TUser t WHERE t.username = :username AND t.passwd = :passwd");
        query.setParameter("username", username);
        query.setParameter("passwd", passwd);
        
        try {
            user = (TUser)query.getSingleResult();
            
        } catch (NoResultException e){
            System.err.println("TUser : ERROR : No result for (" +username + ","+ passwd +") : " + e.getMessage());
        } catch (NonUniqueResultException e){
            System.err.println("TUser : ERROR : Multiple results for (" +username + ","+ passwd +") : " + e.getMessage());
        } catch (Exception e){
            System.err.println("TUser : ERROR : (" +username + ","+ passwd +") : " + e.getMessage());
        }
        return user;
    }
}
