/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isec.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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
    , @NamedQuery(name = "TUser.findByPasswd", query = "SELECT t FROM TUser t WHERE t.passwd = :passwd")
    , @NamedQuery(name = "TUser.findByName", query = "SELECT t FROM TUser t WHERE t.name = :name")
    , @NamedQuery(name = "TUser.findByNif", query = "SELECT t FROM TUser t WHERE t.nif = :nif")
    , @NamedQuery(name = "TUser.findByCreatedAt", query = "SELECT t FROM TUser t WHERE t.createdAt = :createdAt")})
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user", nullable = false)
    private Integer idUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "username", nullable = false, length = 128)
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "passwd", nullable = false, length = 128)
    private String passwd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Size(max = 9)
    @Column(name = "nif", length = 9)
    private String nif;
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @OneToMany(mappedBy = "idUser")
    private Collection<TAccount> tAccountCollection;

    public TUser() {
        this.idUser = 0;
        this.username = "Unknown username";
        this.createdAt = new Date();
        this.name = "Unknown user";
        this.nif = "";
    }

    public TUser(Integer idUser) {
        this.idUser = idUser;
    }

    public TUser(Integer idUser, String username, String passwd, String name) {
        this.idUser = idUser;
        this.username = username;
        this.passwd = passwd;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @XmlTransient
    public Collection<TAccount> getTAccountCollection() {
        return tAccountCollection;
    }

    public void setTAccountCollection(Collection<TAccount> tAccountCollection) {
        this.tAccountCollection = tAccountCollection;
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
