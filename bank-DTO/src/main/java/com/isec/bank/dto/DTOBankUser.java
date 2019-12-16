/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.bank.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ljordao
 */
public class DTOBankUser implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private int idUser;
    private String username;
    private String name;
    //private String passwd;
    private String nif;
    private Date created_at;

    public DTOBankUser() {
    }

    public DTOBankUser(int idUser, String username, String name, /*String passwd,*/ String nif, Date created_at) {
        this.idUser = idUser;
        this.username = username;
        this.name = name;
        //this.passwd = passwd;
        this.nif = nif;
        this.created_at = created_at;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /*public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }*/

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    
    
}
