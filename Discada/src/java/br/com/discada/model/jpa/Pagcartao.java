/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.discada.model.jpa;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "pagcartao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagcartao.findAll", query = "SELECT p FROM Pagcartao p")
    , @NamedQuery(name = "Pagcartao.findByIdpag", query = "SELECT p FROM Pagcartao p WHERE p.idpag = :idpag")
    , @NamedQuery(name = "Pagcartao.findByValorpag", query = "SELECT p FROM Pagcartao p WHERE p.valorpag = :valorpag")})
public class Pagcartao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpag")
    private Integer idpag;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorpag")
    private double valorpag;
    @JoinColumn(name = "idpagcartao", referencedColumnName = "creid")
    @ManyToOne(optional = false)
    private Cartaocredi idpagcartao;
    @JoinColumn(name = "idpagpedido", referencedColumnName = "idpedido")
    @ManyToOne(optional = false)
    private Pedido idpagpedido;

    public Pagcartao() {
    }

    public Pagcartao(Integer idpag) {
        this.idpag = idpag;
    }

    public Pagcartao(Integer idpag, double valorpag) {
        this.idpag = idpag;
        this.valorpag = valorpag;
    }

    public Integer getIdpag() {
        return idpag;
    }

    public void setIdpag(Integer idpag) {
        this.idpag = idpag;
    }

    public double getValorpag() {
        return valorpag;
    }

    public void setValorpag(double valorpag) {
        this.valorpag = valorpag;
    }

    public Cartaocredi getIdpagcartao() {
        return idpagcartao;
    }

    public void setIdpagcartao(Cartaocredi idpagcartao) {
        this.idpagcartao = idpagcartao;
    }

    public Pedido getIdpagpedido() {
        return idpagpedido;
    }

    public void setIdpagpedido(Pedido idpagpedido) {
        this.idpagpedido = idpagpedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpag != null ? idpag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagcartao)) {
            return false;
        }
        Pagcartao other = (Pagcartao) object;
        if ((this.idpag == null && other.idpag != null) || (this.idpag != null && !this.idpag.equals(other.idpag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.discada.model.jpa.Pagcartao[ idpag=" + idpag + " ]";
    }
    
}
