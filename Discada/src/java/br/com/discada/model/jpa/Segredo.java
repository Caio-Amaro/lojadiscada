/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.discada.model.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "segredo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Segredo.findAll", query = "SELECT s FROM Segredo s")
    , @NamedQuery(name = "Segredo.findBySecid", query = "SELECT s FROM Segredo s WHERE s.secid = :secid")
    , @NamedQuery(name = "Segredo.findBySeclogin", query = "SELECT s FROM Segredo s WHERE s.seclogin = :seclogin")
    , @NamedQuery(name = "Segredo.findBySecsenha", query = "SELECT s FROM Segredo s WHERE s.secsenha = :secsenha")})
public class Segredo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "secid")
    private Integer secid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "seclogin")
    private String seclogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "secsenha")
    private String secsenha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsegredo")
    private Collection<Clientes> clientesCollection;

    public Segredo() {
    }

    public Segredo(Integer secid) {
        this.secid = secid;
    }

    public Segredo(Integer secid, String seclogin, String secsenha) {
        this.secid = secid;
        this.seclogin = seclogin;
        this.secsenha = secsenha;
    }

    public Integer getSecid() {
        return secid;
    }

    public void setSecid(Integer secid) {
        this.secid = secid;
    }

    public String getSeclogin() {
        return seclogin;
    }

    public void setSeclogin(String seclogin) {
        this.seclogin = seclogin;
    }

    public String getSecsenha() {
        return secsenha;
    }

    public void setSecsenha(String secsenha) {
        this.secsenha = secsenha;
    }

    @XmlTransient
    public Collection<Clientes> getClientesCollection() {
        return clientesCollection;
    }

    public void setClientesCollection(Collection<Clientes> clientesCollection) {
        this.clientesCollection = clientesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secid != null ? secid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Segredo)) {
            return false;
        }
        Segredo other = (Segredo) object;
        if ((this.secid == null && other.secid != null) || (this.secid != null && !this.secid.equals(other.secid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.discada.model.jpa.Segredo[ secid=" + secid + " ]";
    }
    
}
