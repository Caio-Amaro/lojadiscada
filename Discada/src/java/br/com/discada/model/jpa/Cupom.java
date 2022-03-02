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
@Table(name = "cupom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cupom.findAll", query = "SELECT c FROM Cupom c")
    , @NamedQuery(name = "Cupom.findByIdcupom", query = "SELECT c FROM Cupom c WHERE c.idcupom = :idcupom")
    , @NamedQuery(name = "Cupom.findByNomecupom", query = "SELECT c FROM Cupom c WHERE c.nomecupom = :nomecupom")
    , @NamedQuery(name = "Cupom.findByValorcupom", query = "SELECT c FROM Cupom c WHERE c.valorcupom = :valorcupom")
    , @NamedQuery(name = "Cupom.findByIdtipo", query = "SELECT c FROM Cupom c WHERE c.idtipo = :idtipo")})
public class Cupom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcupom")
    private Integer idcupom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomecupom")
    private String nomecupom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorcupom")
    private double valorcupom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipo")
    private int idtipo;
    @JoinColumn(name = "idclientecup", referencedColumnName = "cliid")
    @ManyToOne(optional = false)
    private Clientes idclientecup;

    public Cupom() {
    }

    public Cupom(Integer idcupom) {
        this.idcupom = idcupom;
    }

    public Cupom(Integer idcupom, String nomecupom, double valorcupom, int idtipo) {
        this.idcupom = idcupom;
        this.nomecupom = nomecupom;
        this.valorcupom = valorcupom;
        this.idtipo = idtipo;
    }

    public Integer getIdcupom() {
        return idcupom;
    }

    public void setIdcupom(Integer idcupom) {
        this.idcupom = idcupom;
    }

    public String getNomecupom() {
        return nomecupom;
    }

    public void setNomecupom(String nomecupom) {
        this.nomecupom = nomecupom;
    }

    public double getValorcupom() {
        return valorcupom;
    }

    public void setValorcupom(double valorcupom) {
        this.valorcupom = valorcupom;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    public Clientes getIdclientecup() {
        return idclientecup;
    }

    public void setIdclientecup(Clientes idclientecup) {
        this.idclientecup = idclientecup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcupom != null ? idcupom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cupom)) {
            return false;
        }
        Cupom other = (Cupom) object;
        if ((this.idcupom == null && other.idcupom != null) || (this.idcupom != null && !this.idcupom.equals(other.idcupom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.discada.model.jpa.Cupom[ idcupom=" + idcupom + " ]";
    }
    
}
