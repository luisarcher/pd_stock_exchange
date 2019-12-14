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
@Table(name = "messages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TMessage.findAll", query = "SELECT t FROM TMessage t")
    , @NamedQuery(name = "TMessage.findByIdMessage", query = "SELECT t FROM TMessage t WHERE t.idMessage = :idMessage")
    , @NamedQuery(name = "TMessage.findByMsgText", query = "SELECT t FROM TMessage t WHERE t.msgText = :msgText")
    , @NamedQuery(name = "TMessage.findByCreatedAt", query = "SELECT t FROM TMessage t WHERE t.createdAt = :createdAt")
    , @NamedQuery(name = "TMessage.findByIsviewed", query = "SELECT t FROM TMessage t WHERE t.isviewed = :isviewed")})
public class TMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_message", nullable = false)
    private Integer idMessage;
    @Size(max = 1024)
    @Column(name = "msg_text", length = 1024)
    private String msgText;
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Column(name = "isviewed")
    private Boolean isviewed;
    @JoinColumn(name = "id_to", referencedColumnName = "id_user")
    @ManyToOne
    private TUser idTo;
    @JoinColumn(name = "id_from", referencedColumnName = "id_user")
    @ManyToOne
    private TUser idFrom;

    public TMessage() {
    }

    public TMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getIsviewed() {
        return isviewed;
    }

    public void setIsviewed(Boolean isviewed) {
        this.isviewed = isviewed;
    }

    public TUser getIdTo() {
        return idTo;
    }

    public void setIdTo(TUser idTo) {
        this.idTo = idTo;
    }

    public TUser getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(TUser idFrom) {
        this.idFrom = idFrom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMessage != null ? idMessage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TMessage)) {
            return false;
        }
        TMessage other = (TMessage) object;
        if ((this.idMessage == null && other.idMessage != null) || (this.idMessage != null && !this.idMessage.equals(other.idMessage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.isec.jpa.TMessage[ idMessage=" + idMessage + " ]";
    }
    
}
