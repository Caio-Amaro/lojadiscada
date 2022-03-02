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
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")
    , @NamedQuery(name = "Produto.findByProid", query = "SELECT p FROM Produto p WHERE p.proid = :proid")
    , @NamedQuery(name = "Produto.findByPronome", query = "SELECT p FROM Produto p WHERE p.pronome = :pronome")
    , @NamedQuery(name = "Produto.findByProdescr", query = "SELECT p FROM Produto p WHERE p.prodescr = :prodescr")
    , @NamedQuery(name = "Produto.findByFabricante", query = "SELECT p FROM Produto p WHERE p.fabricante = :fabricante")
    , @NamedQuery(name = "Produto.findByArtista", query = "SELECT p FROM Produto p WHERE p.artista = :artista")
    , @NamedQuery(name = "Produto.findByAno", query = "SELECT p FROM Produto p WHERE p.ano = :ano")
    , @NamedQuery(name = "Produto.findByPropreco", query = "SELECT p FROM Produto p WHERE p.propreco = :propreco")
    , @NamedQuery(name = "Produto.findByProaltura", query = "SELECT p FROM Produto p WHERE p.proaltura = :proaltura")
    , @NamedQuery(name = "Produto.findByProlargura", query = "SELECT p FROM Produto p WHERE p.prolargura = :prolargura")
    , @NamedQuery(name = "Produto.findByProcompri", query = "SELECT p FROM Produto p WHERE p.procompri = :procompri")
    , @NamedQuery(name = "Produto.findByPropeso", query = "SELECT p FROM Produto p WHERE p.propeso = :propeso")
    , @NamedQuery(name = "Produto.findByProqtda", query = "SELECT p FROM Produto p WHERE p.proqtda = :proqtda")
    , @NamedQuery(name = "Produto.findByProativo", query = "SELECT p FROM Produto p WHERE p.proativo = :proativo")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proid")
    private Integer proid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pronome")
    private String pronome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "prodescr")
    private String prodescr;
    @Size(max = 35)
    @Column(name = "fabricante")
    private String fabricante;
    @Size(max = 70)
    @Column(name = "artista")
    private String artista;
    @Size(max = 4)
    @Column(name = "ano")
    private String ano;
    @Basic(optional = false)
    @NotNull
    @Column(name = "propreco")
    private double propreco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proaltura")
    private double proaltura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prolargura")
    private double prolargura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "procompri")
    private double procompri;
    @Basic(optional = false)
    @NotNull
    @Column(name = "propeso")
    private double propeso;
    @Column(name = "proqtda")
    private Integer proqtda;
    @Column(name = "proativo")
    private Integer proativo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpro")
    private Collection<Itempedido> itempedidoCollection;
    @JoinColumn(name = "proidcategoria", referencedColumnName = "catid")
    @ManyToOne(optional = false)
    private Categoria proidcategoria;

    public Produto() {
    }

    public Produto(Integer proid) {
        this.proid = proid;
    }

    public Produto(Integer proid, String pronome, String prodescr, double propreco, double proaltura, double prolargura, double procompri, double propeso) {
        this.proid = proid;
        this.pronome = pronome;
        this.prodescr = prodescr;
        this.propreco = propreco;
        this.proaltura = proaltura;
        this.prolargura = prolargura;
        this.procompri = procompri;
        this.propeso = propeso;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public String getPronome() {
        return pronome;
    }

    public void setPronome(String pronome) {
        this.pronome = pronome;
    }

    public String getProdescr() {
        return prodescr;
    }

    public void setProdescr(String prodescr) {
        this.prodescr = prodescr;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public double getPropreco() {
        return propreco;
    }

    public void setPropreco(double propreco) {
        this.propreco = propreco;
    }

    public double getProaltura() {
        return proaltura;
    }

    public void setProaltura(double proaltura) {
        this.proaltura = proaltura;
    }

    public double getProlargura() {
        return prolargura;
    }

    public void setProlargura(double prolargura) {
        this.prolargura = prolargura;
    }

    public double getProcompri() {
        return procompri;
    }

    public void setProcompri(double procompri) {
        this.procompri = procompri;
    }

    public double getPropeso() {
        return propeso;
    }

    public void setPropeso(double propeso) {
        this.propeso = propeso;
    }

    public Integer getProqtda() {
        return proqtda;
    }

    public void setProqtda(Integer proqtda) {
        this.proqtda = proqtda;
    }

    public Integer getProativo() {
        return proativo;
    }

    public void setProativo(Integer proativo) {
        this.proativo = proativo;
    }

    @XmlTransient
    public Collection<Itempedido> getItempedidoCollection() {
        return itempedidoCollection;
    }

    public void setItempedidoCollection(Collection<Itempedido> itempedidoCollection) {
        this.itempedidoCollection = itempedidoCollection;
    }

    public Categoria getProidcategoria() {
        return proidcategoria;
    }

    public void setProidcategoria(Categoria proidcategoria) {
        this.proidcategoria = proidcategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proid != null ? proid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.proid == null && other.proid != null) || (this.proid != null && !this.proid.equals(other.proid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.discada.model.jpa.Produto[ proid=" + proid + " ]";
    }
    
}
