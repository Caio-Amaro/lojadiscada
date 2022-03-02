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
@Table(name = "statuspostagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statuspostagem.findAll", query = "SELECT s FROM Statuspostagem s")
    , @NamedQuery(name = "Statuspostagem.findByIdpostagem", query = "SELECT s FROM Statuspostagem s WHERE s.idpostagem = :idpostagem")
    , @NamedQuery(name = "Statuspostagem.findByEstadopostagem", query = "SELECT s FROM Statuspostagem s WHERE s.estadopostagem = :estadopostagem")})
public class Statuspostagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpostagem")
    private Integer idpostagem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "estadopostagem")
    private String estadopostagem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idstatusposta")
    private Collection<Itempedido> itempedidoCollection;

    public Statuspostagem() {
    }

    public Statuspostagem(Integer idpostagem) {
        this.idpostagem = idpostagem;
    }

    public Statuspostagem(Integer idpostagem, String estadopostagem) {
        this.idpostagem = idpostagem;
        this.estadopostagem = estadopostagem;
    }

    public Integer getIdpostagem() {
        return idpostagem;
    }

    public void setIdpostagem(Integer idpostagem) {
        this.idpostagem = idpostagem;
    }

    public String getEstadopostagem() {
        return estadopostagem;
    }

    public void setEstadopostagem(String estadopostagem) {
        this.estadopostagem = estadopostagem;
    }

    @XmlTransient
    public Collection<Itempedido> getItempedidoCollection() {
        return itempedidoCollection;
    }

    public void setItempedidoCollection(Collection<Itempedido> itempedidoCollection) {
        this.itempedidoCollection = itempedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpostagem != null ? idpostagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statuspostagem)) {
            return false;
        }
        Statuspostagem other = (Statuspostagem) object;
        if ((this.idpostagem == null && other.idpostagem != null) || (this.idpostagem != null && !this.idpostagem.equals(other.idpostagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.discada.model.jpa.Statuspostagem[ idpostagem=" + idpostagem + " ]";
    }
    
}
