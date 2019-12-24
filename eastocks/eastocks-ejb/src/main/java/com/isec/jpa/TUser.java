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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TUser.findAll", query = "SELECT t FROM TUser t")
    , @NamedQuery(name = "TUser.findByIdUser", query = "SELECT t FROM TUser t WHERE t.idUser = :idUser")
    , @NamedQuery(name = "TUser.findByUsername", query = "SELECT t FROM TUser t WHERE t.username = :username")
    , @NamedQuery(name = "TUser.findByPasswd", query = "SELECT t FROM TUser t WHERE t.passwd = :passwd")})
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user", nullable = false)
    private Integer idUser;
    @Size(max = 200)
    @Column(name = "username", length = 200)
    private String username;
    @Size(max = 200)
    @Column(name = "passwd", length = 200)
    private String passwd;
    @OneToMany(mappedBy = "idUser")
    private Collection<TPortfolio> tPortfolioCollection;
    @OneToMany(mappedBy = "idTo")
    private Collection<TMessage> tMessageCollection;
    @OneToMany(mappedBy = "idFrom")
    private Collection<TMessage> tMessageCollection1;
    @OneToMany(mappedBy = "idUser")
    private Collection<TOrder> tOrderCollection;

    public TUser() {
        
        this.passwd = "pwd";
        this.username = "username";
    }

    public TUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
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

    @XmlTransient
    public Collection<TPortfolio> getTPortfolioCollection() {
        return tPortfolioCollection;
    }

    public void setTPortfolioCollection(Collection<TPortfolio> tPortfolioCollection) {
        this.tPortfolioCollection = tPortfolioCollection;
    }

    @XmlTransient
    public Collection<TMessage> getTMessageCollection() {
        return tMessageCollection;
    }

    public void setTMessageCollection(Collection<TMessage> tMessageCollection) {
        this.tMessageCollection = tMessageCollection;
    }

    @XmlTransient
    public Collection<TMessage> getTMessageCollection1() {
        return tMessageCollection1;
    }

    public void setTMessageCollection1(Collection<TMessage> tMessageCollection1) {
        this.tMessageCollection1 = tMessageCollection1;
    }

    @XmlTransient
    public Collection<TOrder> getTOrderCollection() {
        return tOrderCollection;
    }

    public void setTOrderCollection(Collection<TOrder> tOrderCollection) {
        this.tOrderCollection = tOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TUser)) {
            return false;
        }
        TUser other = (TUser) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isec.jpa.TUser[ idUser=" + idUser + " ]";
    }
    
}
