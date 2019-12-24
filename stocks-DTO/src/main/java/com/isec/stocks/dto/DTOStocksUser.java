/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.stocks.dto;

import java.io.Serializable;

/**
 *
 * @author ljordao
 */
public class DTOStocksUser implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private int idUser;
    private String username;
    private String passwd;

    public DTOStocksUser() {
        this.passwd = "";
    }

    public DTOStocksUser(int idUser, String username) {
        this.idUser = idUser;
        this.username = username;
        this.passwd = "";
    }
    
    public DTOStocksUser(int idUser, String username, String passwd) {
        this.idUser = idUser;
        this.username = username;
        this.passwd = passwd;
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

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
}
