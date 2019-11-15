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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ljordao
 */
@Entity
@Table(name = "administration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TAdmin.findAll", query = "SELECT t FROM TAdmin t")
    , @NamedQuery(name = "TAdmin.findByIdAdmin", query = "SELECT t FROM TAdmin t WHERE t.idAdmin = :idAdmin")
    , @NamedQuery(name = "TAdmin.findByUsername", query = "SELECT t FROM TAdmin t WHERE t.username = :username")
    , @NamedQuery(name = "TAdmin.findByPasswd", query = "SELECT t FROM TAdmin t WHERE t.passwd = :passwd")})
public class TAdmin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_admin", nullable = false)
    private Integer idAdmin;
    @Size(max = 255)
    @Column(name = "username", length = 255)
    private String username;
    @Size(max = 255)
    @Column(name = "passwd", length = 255)
    private String passwd;

    public TAdmin() {
    }

    public TAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdmin != null ? idAdmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TAdmin)) {
            return false;
        }
        TAdmin other = (TAdmin) object;
        if ((this.idAdmin == null && other.idAdmin != null) || (this.idAdmin != null && !this.idAdmin.equals(other.idAdmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isec.jpa.TAdmin[ idAdmin=" + idAdmin + " ]";
    }
    
}
