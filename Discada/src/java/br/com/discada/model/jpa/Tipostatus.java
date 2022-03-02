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
@Table(name = "tipostatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipostatus.findAll", query = "SELECT t FROM Tipostatus t")
    , @NamedQuery(name = "Tipostatus.findByIdtipostatus", query = "SELECT t FROM Tipostatus t WHERE t.idtipostatus = :idtipostatus")
    , @NamedQuery(name = "Tipostatus.findByNomestatus", query = "SELECT t FROM Tipostatus t WHERE t.nomestatus = :nomestatus")})
public class Tipostatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipostatus")
    private Integer idtipostatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nomestatus")
    private String nomestatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idstatus")
    private Collection<Itempedido> itempedidoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipostatus")
    private Collection<Pedido> pedidoCollection;

    public Tipostatus() {
    }

    public Tipostatus(Integer idtipostatus) {
        this.idtipostatus = idtipostatus;
    }

    public Tipostatus(Integer idtipostatus, String nomestatus) {
        this.idtipostatus = idtipostatus;
        this.nomestatus = nomestatus;
    }

    public Integer getIdtipostatus() {
        return idtipostatus;
    }

    public void setIdtipostatus(Integer idtipostatus) {
        this.idtipostatus = idtipostatus;
    }

    public String getNomestatus() {
        return nomestatus;
    }

    public void setNomestatus(String nomestatus) {
        this.nomestatus = nomestatus;
    }

    @XmlTransient
    public Collection<Itempedido> getItempedidoCollection() {
        return itempedidoCollection;
    }

    public void setItempedidoCollection(Collection<Itempedido> itempedidoCollection) {
        this.itempedidoCollection = itempedidoCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipostatus != null ? idtipostatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipostatus)) {
            return false;
        }
        Tipostatus other = (Tipostatus) object;
        if ((this.idtipostatus == null && other.idtipostatus != null) || (this.idtipostatus != null && !this.idtipostatus.equals(other.idtipostatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.discada.model.jpa.Tipostatus[ idtipostatus=" + idtipostatus + " ]";
    }
    
}
