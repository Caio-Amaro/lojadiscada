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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "itempedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itempedido.findAll", query = "SELECT i FROM Itempedido i")
    , @NamedQuery(name = "Itempedido.findByItempedidoid", query = "SELECT i FROM Itempedido i WHERE i.itempedidoid = :itempedidoid")
    , @NamedQuery(name = "Itempedido.findByValoritem", query = "SELECT i FROM Itempedido i WHERE i.valoritem = :valoritem")
    , @NamedQuery(name = "Itempedido.findByQuantidade", query = "SELECT i FROM Itempedido i WHERE i.quantidade = :quantidade")
    , @NamedQuery(name = "Itempedido.findByValortotalitem", query = "SELECT i FROM Itempedido i WHERE i.valortotalitem = :valortotalitem")
    , @NamedQuery(name = "Itempedido.findByObservatroca", query = "SELECT i FROM Itempedido i WHERE i.observatroca = :observatroca")})
public class Itempedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itempedidoid")
    private Integer itempedidoid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valoritem")
    private double valoritem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valortotalitem")
    private double valortotalitem;
    @Size(max = 450)
    @Column(name = "observatroca")
    private String observatroca;
    @JoinColumn(name = "idpro", referencedColumnName = "proid")
    @ManyToOne(optional = false)
    private Produto idpro;
    @JoinColumn(name = "idped", referencedColumnName = "idpedido")
    @ManyToOne(optional = false)
    private Pedido idped;
    @JoinColumn(name = "idstatusposta", referencedColumnName = "idpostagem")
    @ManyToOne(optional = false)
    private Statuspostagem idstatusposta;
    @JoinColumn(name = "idstatus", referencedColumnName = "idtipostatus")
    @ManyToOne(optional = false)
    private Tipostatus idstatus;

    public Itempedido() {
    }

    public Itempedido(Integer itempedidoid) {
        this.itempedidoid = itempedidoid;
    }

    public Itempedido(Integer itempedidoid, double valoritem, int quantidade, double valortotalitem) {
        this.itempedidoid = itempedidoid;
        this.valoritem = valoritem;
        this.quantidade = quantidade;
        this.valortotalitem = valortotalitem;
    }

    public Integer getItempedidoid() {
        return itempedidoid;
    }

    public void setItempedidoid(Integer itempedidoid) {
        this.itempedidoid = itempedidoid;
    }

    public double getValoritem() {
        return valoritem;
    }

    public void setValoritem(double valoritem) {
        this.valoritem = valoritem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValortotalitem() {
        return valortotalitem;
    }

    public void setValortotalitem(double valortotalitem) {
        this.valortotalitem = valortotalitem;
    }

    public String getObservatroca() {
        return observatroca;
    }

    public void setObservatroca(String observatroca) {
        this.observatroca = observatroca;
    }

    public Produto getIdpro() {
        return idpro;
    }

    public void setIdpro(Produto idpro) {
        this.idpro = idpro;
    }

    public Pedido getIdped() {
        return idped;
    }

    public void setIdped(Pedido idped) {
        this.idped = idped;
    }

    public Statuspostagem getIdstatusposta() {
        return idstatusposta;
    }

    public void setIdstatusposta(Statuspostagem idstatusposta) {
        this.idstatusposta = idstatusposta;
    }

    public Tipostatus getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(Tipostatus idstatus) {
        this.idstatus = idstatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itempedidoid != null ? itempedidoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itempedido)) {
            return false;
        }
        Itempedido other = (Itempedido) object;
        if ((this.itempedidoid == null && other.itempedidoid != null) || (this.itempedidoid != null && !this.itempedidoid.equals(other.itempedidoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.discada.model.jpa.Itempedido[ itempedidoid=" + itempedidoid + " ]";
    }
    
}
