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
@Table(name = "endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e")
    , @NamedQuery(name = "Endereco.findByEndid", query = "SELECT e FROM Endereco e WHERE e.endid = :endid")
    , @NamedQuery(name = "Endereco.findByEndnomedestino", query = "SELECT e FROM Endereco e WHERE e.endnomedestino = :endnomedestino")
    , @NamedQuery(name = "Endereco.findByEndlogradouro", query = "SELECT e FROM Endereco e WHERE e.endlogradouro = :endlogradouro")
    , @NamedQuery(name = "Endereco.findByEndnumero", query = "SELECT e FROM Endereco e WHERE e.endnumero = :endnumero")
    , @NamedQuery(name = "Endereco.findByEndcomplemento", query = "SELECT e FROM Endereco e WHERE e.endcomplemento = :endcomplemento")
    , @NamedQuery(name = "Endereco.findByEndbairro", query = "SELECT e FROM Endereco e WHERE e.endbairro = :endbairro")
    , @NamedQuery(name = "Endereco.findByEndcep", query = "SELECT e FROM Endereco e WHERE e.endcep = :endcep")
    , @NamedQuery(name = "Endereco.findByEndcidade", query = "SELECT e FROM Endereco e WHERE e.endcidade = :endcidade")
    , @NamedQuery(name = "Endereco.findByEndestado", query = "SELECT e FROM Endereco e WHERE e.endestado = :endestado")})
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "endid")
    private Integer endid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "endnomedestino")
    private String endnomedestino;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "endlogradouro")
    private String endlogradouro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "endnumero")
    private String endnumero;
    @Size(max = 120)
    @Column(name = "endcomplemento")
    private String endcomplemento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "endbairro")
    private String endbairro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "endcep")
    private String endcep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "endcidade")
    private String endcidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "endestado")
    private String endestado;
    @JoinColumn(name = "endidcliente", referencedColumnName = "cliid")
    @ManyToOne(optional = false)
    private Clientes endidcliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idendereco")
    private Collection<Pedido> pedidoCollection;

    public Endereco() {
    }

    public Endereco(Integer endid) {
        this.endid = endid;
    }

    public Endereco(Integer endid, String endnomedestino, String endlogradouro, String endnumero, String endbairro, String endcep, String endcidade, String endestado) {
        this.endid = endid;
        this.endnomedestino = endnomedestino;
        this.endlogradouro = endlogradouro;
        this.endnumero = endnumero;
        this.endbairro = endbairro;
        this.endcep = endcep;
        this.endcidade = endcidade;
        this.endestado = endestado;
    }

    public Integer getEndid() {
        return endid;
    }

    public void setEndid(Integer endid) {
        this.endid = endid;
    }

    public String getEndnomedestino() {
        return endnomedestino;
    }

    public void setEndnomedestino(String endnomedestino) {
        this.endnomedestino = endnomedestino;
    }

    public String getEndlogradouro() {
        return endlogradouro;
    }

    public void setEndlogradouro(String endlogradouro) {
        this.endlogradouro = endlogradouro;
    }

    public String getEndnumero() {
        return endnumero;
    }

    public void setEndnumero(String endnumero) {
        this.endnumero = endnumero;
    }

    public String getEndcomplemento() {
        return endcomplemento;
    }

    public void setEndcomplemento(String endcomplemento) {
        this.endcomplemento = endcomplemento;
    }

    public String getEndbairro() {
        return endbairro;
    }

    public void setEndbairro(String endbairro) {
        this.endbairro = endbairro;
    }

    public String getEndcep() {
        return endcep;
    }

    public void setEndcep(String endcep) {
        this.endcep = endcep;
    }

    public String getEndcidade() {
        return endcidade;
    }

    public void setEndcidade(String endcidade) {
        this.endcidade = endcidade;
    }

    public String getEndestado() {
        return endestado;
    }

    public void setEndestado(String endestado) {
        this.endestado = endestado;
    }

    public Clientes getEndidcliente() {
        return endidcliente;
    }

    public void setEndidcliente(Clientes endidcliente) {
        this.endidcliente = endidcliente;
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
        hash += (endid != null ? endid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.endid == null && other.endid != null) || (this.endid != null && !this.endid.equals(other.endid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.discada.model.jpa.Endereco[ endid=" + endid + " ]";
    }
    
}
