/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.jpa;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ljordao
 */
@Entity
@Table(name = "movements")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TMovement.findAll", query = "SELECT t FROM TMovement t")
    , @NamedQuery(name = "TMovement.findByIdMovement", query = "SELECT t FROM TMovement t WHERE t.idMovement = :idMovement")
    , @NamedQuery(name = "TMovement.findByDescription", query = "SELECT t FROM TMovement t WHERE t.description = :description")
    , @NamedQuery(name = "TMovement.findByVal", query = "SELECT t FROM TMovement t WHERE t.val = :val")
    , @NamedQuery(name = "TMovement.findByFinalBalance", query = "SELECT t FROM TMovement t WHERE t.finalBalance = :finalBalance")
    , @NamedQuery(name = "TMovement.findByCreatedAt", query = "SELECT t FROM TMovement t WHERE t.createdAt = :createdAt")})
public class TMovement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_movement", nullable = false)
    private Integer idMovement;
    @Size(max = 255)
    @Column(name = "description", length = 255)
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "val", precision = 17, scale = 17)
    private Double val;
    @Column(name = "final_balance", precision = 17, scale = 17)
    private Double finalBalance;
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @JoinColumn(name = "id_account", referencedColumnName = "id_account")
    @ManyToOne
    private TAccount idAccount;

    public TMovement() {
    }

    public TMovement(Integer idMovement) {
        this.idMovement = idMovement;
    }

    public Integer getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(Integer idMovement) {
        this.idMovement = idMovement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getVal() {
        return val;
    }

    public void setVal(Double val) {
        this.val = val;
    }

    public Double getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(Double finalBalance) {
        this.finalBalance = finalBalance;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public TAccount getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(TAccount idAccount) {
        this.idAccount = idAccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovement != null ? idMovement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TMovement)) {
            return false;
        }
        TMovement other = (TMovement) object;
        if ((this.idMovement == null && other.idMovement != null) || (this.idMovement != null && !this.idMovement.equals(other.idMovement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isec.jpa.TMovement[ idMovement=" + idMovement + " ]";
    }
    
}
