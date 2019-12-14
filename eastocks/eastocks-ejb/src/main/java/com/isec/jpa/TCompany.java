/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ljordao
 */
@Entity
@Table(name = "company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCompany.findAll", query = "SELECT t FROM TCompany t")
    , @NamedQuery(name = "TCompany.findByIdCompany", query = "SELECT t FROM TCompany t WHERE t.idCompany = :idCompany")
    , @NamedQuery(name = "TCompany.findByDescription", query = "SELECT t FROM TCompany t WHERE t.description = :description")
    , @NamedQuery(name = "TCompany.findByArea", query = "SELECT t FROM TCompany t WHERE t.area = :area")
    , @NamedQuery(name = "TCompany.findByShareQuant", query = "SELECT t FROM TCompany t WHERE t.shareQuant = :shareQuant")
    , @NamedQuery(name = "TCompany.findBySharePrice", query = "SELECT t FROM TCompany t WHERE t.sharePrice = :sharePrice")})
public class TCompany implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_company", nullable = false)
    private Integer idCompany;
    @Size(max = 200)
    @Column(name = "description", length = 200)
    private String description;
    @Size(max = 200)
    @Column(name = "area", length = 200)
    private String area;
    @Column(name = "share_quant")
    private Integer shareQuant;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "share_price", precision = 17, scale = 17)
    private Double sharePrice;
    @OneToMany(mappedBy = "idCompany")
    private Collection<TParcel> tParcelCollection;
    @OneToMany(mappedBy = "idCompany")
    private Collection<TPortfolio> tPortfolioCollection;

    public TCompany() {
    }

    public TCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getShareQuant() {
        return shareQuant;
    }

    public void setShareQuant(Integer shareQuant) {
        this.shareQuant = shareQuant;
    }

    public Double getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(Double sharePrice) {
        this.sharePrice = sharePrice;
    }

    @XmlTransient
    public Collection<TParcel> getTParcelCollection() {
        return tParcelCollection;
    }

    public void setTParcelCollection(Collection<TParcel> tParcelCollection) {
        this.tParcelCollection = tParcelCollection;
    }

    @XmlTransient
    public Collection<TPortfolio> getTPortfolioCollection() {
        return tPortfolioCollection;
    }

    public void setTPortfolioCollection(Collection<TPortfolio> tPortfolioCollection) {
        this.tPortfolioCollection = tPortfolioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompany != null ? idCompany.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TCompany)) {
            return false;
        }
        TCompany other = (TCompany) object;
        if ((this.idCompany == null && other.idCompany != null) || (this.idCompany != null && !this.idCompany.equals(other.idCompany))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isec.jpa.TCompany[ idCompany=" + idCompany + " ]";
    }
    
}
