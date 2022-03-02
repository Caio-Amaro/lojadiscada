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
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByCliid", query = "SELECT c FROM Clientes c WHERE c.cliid = :cliid")
    , @NamedQuery(name = "Clientes.findByClinome", query = "SELECT c FROM Clientes c WHERE c.clinome = :clinome")
    , @NamedQuery(name = "Clientes.findByClisobrenome", query = "SELECT c FROM Clientes c WHERE c.clisobrenome = :clisobrenome")
    , @NamedQuery(name = "Clientes.findByClicpf", query = "SELECT c FROM Clientes c WHERE c.clicpf = :clicpf")
    , @NamedQuery(name = "Clientes.findByCliemail", query = "SELECT c FROM Clientes c WHERE c.cliemail = :cliemail")
    , @NamedQuery(name = "Clientes.findByCligenero", query = "SELECT c FROM Clientes c WHERE c.cligenero = :cligenero")
    , @NamedQuery(name = "Clientes.findByCliddd", query = "SELECT c FROM Clientes c WHERE c.cliddd = :cliddd")
    , @NamedQuery(name = "Clientes.findByClitelefone", query = "SELECT c FROM Clientes c WHERE c.clitelefone = :clitelefone")
    , @NamedQuery(name = "Clientes.findByCliativo", query = "SELECT c FROM Clientes c WHERE c.cliativo = :cliativo")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cliid")
    private Integer cliid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "clinome")
    private String clinome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 160)
    @Column(name = "clisobrenome")
    private String clisobrenome;
    @Size(max = 15)
    @Column(name = "clicpf")
    private String clicpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "cliemail")
    private String cliemail;
    @Size(max = 45)
    @Column(name = "cligenero")
    private String cligenero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cliddd")
    private String cliddd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "clitelefone")
    private String clitelefone;
    @Column(name = "cliativo")
    private Integer cliativo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "endidcliente")
    private Collection<Endereco> enderecoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclientecup")
    private Collection<Cupom> cupomCollection;
    @OneToMany(mappedBy = "creidcliente")
    private Collection<Cartaocredi> cartaocrediCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente")
    private Collection<Pedido> pedidoCollection;
    @JoinColumn(name = "idsegredo", referencedColumnName = "secid")
    @ManyToOne(optional = false)
    private Segredo idsegredo;

    public Clientes() {
    }

    public Clientes(Integer cliid) {
        this.cliid = cliid;
    }

    public Clientes(Integer cliid, String clinome, String clisobrenome, String cliemail, String cliddd, String clitelefone) {
        this.cliid = cliid;
        this.clinome = clinome;
        this.clisobrenome = clisobrenome;
        this.cliemail = cliemail;
        this.cliddd = cliddd;
        this.clitelefone = clitelefone;
    }

    public Integer getCliid() {
        return cliid;
    }

    public void setCliid(Integer cliid) {
        this.cliid = cliid;
    }

    public String getClinome() {
        return clinome;
    }

    public void setClinome(String clinome) {
        this.clinome = clinome;
    }

    public String getClisobrenome() {
        return clisobrenome;
    }

    public void setClisobrenome(String clisobrenome) {
        this.clisobrenome = clisobrenome;
    }

    public String getClicpf() {
        return clicpf;
    }

    public void setClicpf(String clicpf) {
        this.clicpf = clicpf;
    }

    public String getCliemail() {
        return cliemail;
    }

    public void setCliemail(String cliemail) {
        this.cliemail = cliemail;
    }

    public String getCligenero() {
        return cligenero;
    }

    public void setCligenero(String cligenero) {
        this.cligenero = cligenero;
    }

    public String getCliddd() {
        return cliddd;
    }

    public void setCliddd(String cliddd) {
        this.cliddd = cliddd;
    }

    public String getClitelefone() {
        return clitelefone;
    }

    public void setClitelefone(String clitelefone) {
        this.clitelefone = clitelefone;
    }

    public Integer getCliativo() {
        return cliativo;
    }

    public void setCliativo(Integer cliativo) {
        this.cliativo = cliativo;
    }

    @XmlTransient
    public Collection<Endereco> getEnderecoCollection() {
        return enderecoCollection;
    }

    public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
        this.enderecoCollection = enderecoCollection;
    }

    @XmlTransient
    public Collection<Cupom> getCupomCollection() {
        return cupomCollection;
    }

    public void setCupomCollection(Collection<Cupom> cupomCollection) {
        this.cupomCollection = cupomCollection;
    }

    @XmlTransient
    public Collection<Cartaocredi> getCartaocrediCollection() {
        return cartaocrediCollection;
    }

    public void setCartaocrediCollection(Collection<Cartaocredi> cartaocrediCollection) {
        this.cartaocrediCollection = cartaocrediCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    public Segredo getIdsegredo() {
        return idsegredo;
    }

    public void setIdsegredo(Segredo idsegredo) {
        this.idsegredo = idsegredo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliid != null ? cliid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.cliid == null && other.cliid != null) || (this.cliid != null && !this.cliid.equals(other.cliid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.discada.model.jpa.Clientes[ cliid=" + cliid + " ]";
    }
    
}
