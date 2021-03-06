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
@Table(name = "tipocupom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipocupom.findAll", query = "SELECT t FROM Tipocupom t")
    , @NamedQuery(name = "Tipocupom.findByIdtipo", query = "SELECT t FROM Tipocupom t WHERE t.idtipo = :idtipo")
    , @NamedQuery(name = "Tipocupom.findByNometipo", query = "SELECT t FROM Tipocupom t WHERE t.nometipo = :nometipo")})
public class Tipocupom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo")
    private Integer idtipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "nometipo")
    private String nometipo;

    public Tipocupom() {
    }

    public Tipocupom(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public Tipocupom(Integer idtipo, String nometipo) {
        this.idtipo = idtipo;
        this.nometipo = nometipo;
    }

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public String getNometipo() {
        return nometipo;
    }

    public void setNometipo(String nometipo) {
        this.nometipo = nometipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipo != null ? idtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipocupom)) {
            return false;
        }
        Tipocupom other = (Tipocupom) object;
        if ((this.idtipo == null && other.idtipo != null) || (this.idtipo != null && !this.idtipo.equals(other.idtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.discada.model.jpa.Tipocupom[ idtipo=" + idtipo + " ]";
    }
    
}
