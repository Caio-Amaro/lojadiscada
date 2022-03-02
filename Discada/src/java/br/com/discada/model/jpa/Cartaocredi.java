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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cartaocredi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartaocredi.findAll", query = "SELECT c FROM Cartaocredi c")
    , @NamedQuery(name = "Cartaocredi.findByCreid", query = "SELECT c FROM Cartaocredi c WHERE c.creid = :creid")
    , @NamedQuery(name = "Cartaocredi.findByCrenome", query = "SELECT c FROM Cartaocredi c WHERE c.crenome = :crenome")
    , @NamedQuery(name = "Cartaocredi.findByCrenumero", query = "SELECT c FROM Cartaocredi c WHERE c.crenumero = :crenumero")
    , @NamedQuery(name = "Cartaocredi.findByCrecvv", query = "SELECT c FROM Cartaocredi c WHERE c.crecvv = :crecvv")
    , @NamedQuery(name = "Cartaocredi.findByCrevalidade", query = "SELECT c FROM Cartaocredi c WHERE c.crevalidade = :crevalidade")
    , @NamedQuery(name = "Cartaocredi.findByBandeira", query = "SELECT c FROM Cartaocredi c WHERE c.bandeira = :bandeira")})
public class Cartaocredi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "creid")
    private Integer creid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "crenome")
    private String crenome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "crenumero")
    private String crenumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "crecvv")
    private int crecvv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "crevalidade")
    private String crevalidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "bandeira")
    private String bandeira;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpagcartao")
    private Collection<Pagcartao> pagcartaoCollection;
    @JoinColumn(name = "creidcliente", referencedColumnName = "cliid")
    @ManyToOne
    private Clientes creidcliente;

    public Cartaocredi() {
    }

    public Cartaocredi(Integer creid) {
        this.creid = creid;
    }

    public Cartaocredi(Integer creid, String crenome, String crenumero, int crecvv, String crevalidade, String bandeira) {
        this.creid = creid;
        this.crenome = crenome;
        this.crenumero = crenumero;
        this.crecvv = crecvv;
        this.crevalidade = crevalidade;
        this.bandeira = bandeira;
    }

    public Integer getCreid() {
        return creid;
    }

    public void setCreid(Integer creid) {
        this.creid = creid;
    }

    public String getCrenome() {
        return crenome;
    }

    public void setCrenome(String crenome) {
        this.crenome = crenome;
    }

    public String getCrenumero() {
        return crenumero;
    }

    public void setCrenumero(String crenumero) {
        this.crenumero = crenumero;
    }

    public int getCrecvv() {
        return crecvv;
    }

    public void setCrecvv(int crecvv) {
        this.crecvv = crecvv;
    }

    public String getCrevalidade() {
        return crevalidade;
    }

    public void setCrevalidade(String crevalidade) {
        this.crevalidade = crevalidade;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    @XmlTransient
    public Collection<Pagcartao> getPagcartaoCollection() {
        return pagcartaoCollection;
    }

    public void setPagcartaoCollection(Collection<Pagcartao> pagcartaoCollection) {
        this.pagcartaoCollection = pagcartaoCollection;
    }

    public Clientes getCreidcliente() {
        return creidcliente;
    }

    public void setCreidcliente(Clientes creidcliente) {
        this.creidcliente = creidcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (creid != null ? creid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartaocredi)) {
            return false;
        }
        Cartaocredi other = (Cartaocredi) object;
        if ((this.creid == null && other.creid != null) || (this.creid != null && !this.creid.equals(other.creid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.discada.model.jpa.Cartaocredi[ creid=" + creid + " ]";
    }
    
}
