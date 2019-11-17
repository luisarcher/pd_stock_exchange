/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.bank.dto;

import java.util.Date;

/**
 *
 * @author ljordao
 */
public class DTOBankAccount {
    
    private static final long serialVersionUID = 1L;

    private int idAccount;
    private Double balance;
    private Date created_at;
    private int status;

    public DTOBankAccount() {
    }

    public DTOBankAccount(int idAccount, Double balance, Date created_at, int status) {
        this.idAccount = idAccount;
        this.balance = balance;
        this.created_at = created_at;
        this.status = status;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
