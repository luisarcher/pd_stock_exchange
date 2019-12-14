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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ljordao
 */
@Entity
@Table(name = "parcel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TParcel.findAll", query = "SELECT t FROM TParcel t")
    , @NamedQuery(name = "TParcel.findByIdParcel", query = "SELECT t FROM TParcel t WHERE t.idParcel = :idParcel")
    , @NamedQuery(name = "TParcel.findByShareQuant", query = "SELECT t FROM TParcel t WHERE t.shareQuant = :shareQuant")
    , @NamedQuery(name = "TParcel.findByPrice", query = "SELECT t FROM TParcel t WHERE t.price = :price")})
public class TParcel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_parcel", nullable = false)
    private Integer idParcel;
    @Column(name = "share_quant")
    private Integer shareQuant;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price", precision = 17, scale = 17)
    private Double price;
    @JoinColumn(name = "id_company", referencedColumnName = "id_company")
    @ManyToOne
    private TCompany idCompany;
    @JoinColumn(name = "id_order", referencedColumnName = "id_order")
    @ManyToOne
    private TOrder idOrder;

    public TParcel() {
    }

    public TParcel(Integer idParcel) {
        this.idParcel = idParcel;
    }

    public Integer getIdParcel() {
        return idParcel;
    }

    public void setIdParcel(Integer idParcel) {
        this.idParcel = idParcel;
    }

    public Integer getShareQuant() {
        return shareQuant;
    }

    public void setShareQuant(Integer shareQuant) {
        this.shareQuant = shareQuant;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TCompany getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(TCompany idCompany) {
        this.idCompany = idCompany;
    }

    public TOrder getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(TOrder idOrder) {
        this.idOrder = idOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParcel != null ? idParcel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TParcel)) {
            return false;
        }
        TParcel other = (TParcel) object;
        if ((this.idParcel == null && other.idParcel != null) || (this.idParcel != null && !this.idParcel.equals(other.idParcel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isec.jpa.TParcel[ idParcel=" + idParcel + " ]";
    }
    
}
