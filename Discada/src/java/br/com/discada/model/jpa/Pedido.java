/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.discada.model.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findByIdpedido", query = "SELECT p FROM Pedido p WHERE p.idpedido = :idpedido")
    , @NamedQuery(name = "Pedido.findByValortotal", query = "SELECT p FROM Pedido p WHERE p.valortotal = :valortotal")
    , @NamedQuery(name = "Pedido.findByData", query = "SELECT p FROM Pedido p WHERE p.data = :data")
    , @NamedQuery(name = "Pedido.findByFormapag", query = "SELECT p FROM Pedido p WHERE p.formapag = :formapag")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpedido")
    private Integer idpedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valortotal")
    private double valortotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "formapag")
    private int formapag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idped")
    private Collection<Itempedido> itempedidoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpagpedido")
    private Collection<Pagcartao> pagcartaoCollection;
    @JoinColumn(name = "idcliente", referencedColumnName = "cliid")
    @ManyToOne(optional = false)
    private Clientes idcliente;
    @JoinColumn(name = "idendereco", referencedColumnName = "endid")
    @ManyToOne(optional = false)
    private Endereco idendereco;
    @JoinColumn(name = "idtipostatus", referencedColumnName = "idtipostatus")
    @ManyToOne(optional = false)
    private Tipostatus idtipostatus;

    public Pedido() {
    }

    public Pedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public Pedido(Integer idpedido, double valortotal, Date data, int formapag) {
        this.idpedido = idpedido;
        this.valortotal = valortotal;
        this.data = data;
        this.formapag = formapag;
    }

    public Integer getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getFormapag() {
        return formapag;
    }

    public void setFormapag(int formapag) {
        this.formapag = formapag;
    }

    @XmlTransient
    public Collection<Itempedido> getItempedidoCollection() {
        return itempedidoCollection;
    }

    public void setItempedidoCollection(Collection<Itempedido> itempedidoCollection) {
        this.itempedidoCollection = itempedidoCollection;
    }

    @XmlTransient
    public Collection<Pagcartao> getPagcartaoCollection() {
        return pagcartaoCollection;
    }

    public void setPagcartaoCollection(Collection<Pagcartao> pagcartaoCollection) {
        this.pagcartaoCollection = pagcartaoCollection;
    }

    public Clientes getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Clientes idcliente) {
        this.idcliente = idcliente;
    }

    public Endereco getIdendereco() {
        return idendereco;
    }

    public void setIdendereco(Endereco idendereco) {
        this.idendereco = idendereco;
    }

    public Tipostatus getIdtipostatus() {
        return idtipostatus;
    }

    public void setIdtipostatus(Tipostatus idtipostatus) {
        this.idtipostatus = idtipostatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpedido != null ? idpedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idpedido == null && other.idpedido != null) || (this.idpedido != null && !this.idpedido.equals(other.idpedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.discada.model.jpa.Pedido[ idpedido=" + idpedido + " ]";
    }
    
}
