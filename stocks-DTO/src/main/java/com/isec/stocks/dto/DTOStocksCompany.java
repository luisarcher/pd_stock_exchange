/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.stocks.dto;

import java.io.Serializable;

public class DTOStocksCompany implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Integer idCompany;
    private String area;
    private String description;
    private Double sharePrice;
    private Integer shareQuant;

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(Double sharePrice) {
        this.sharePrice = sharePrice;
    }

    public Integer getShareQuant() {
        return shareQuant;
    }

    public void setShareQuant(Integer shareQuant) {
        this.shareQuant = shareQuant;
    }
    
    
    
    
}
