/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ljordao
 */
@Entity
@Table(name = "portfolio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TPortfolio.findAll", query = "SELECT t FROM TPortfolio t")
    , @NamedQuery(name = "TPortfolio.findByIdPortfolio", query = "SELECT t FROM TPortfolio t WHERE t.idPortfolio = :idPortfolio")
    , @NamedQuery(name = "TPortfolio.findByShareQuant", query = "SELECT t FROM TPortfolio t WHERE t.shareQuant = :shareQuant")})
public class TPortfolio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_portfolio", nullable = false)
    private Integer idPortfolio;
    @Column(name = "share_quant")
    private Integer shareQuant;
    @JoinColumn(name = "id_company", referencedColumnName = "id_company")
    @ManyToOne
    private TCompany idCompany;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne
    private TUser idUser;

    public TPortfolio() {
    }

    public TPortfolio(Integer idPortfolio) {
        this.idPortfolio = idPortfolio;
    }

    public Integer getIdPortfolio() {
        return idPortfolio;
    }

    public void setIdPortfolio(Integer idPortfolio) {
        this.idPortfolio = idPortfolio;
    }

    public Integer getShareQuant() {
        return shareQuant;
    }

    public void setShareQuant(Integer shareQuant) {
        this.shareQuant = shareQuant;
    }

    public TCompany getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(TCompany idCompany) {
        this.idCompany = idCompany;
    }

    public TUser getIdUser() {
        return idUser;
    }

    public void setIdUser(TUser idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPortfolio != null ? idPortfolio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TPortfolio)) {
            return false;
        }
        TPortfolio other = (TPortfolio) object;
        if ((this.idPortfolio == null && other.idPortfolio != null) || (this.idPortfolio != null && !this.idPortfolio.equals(other.idPortfolio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isec.jpa.TPortfolio[ idPortfolio=" + idPortfolio + " ]";
    }
    
}
