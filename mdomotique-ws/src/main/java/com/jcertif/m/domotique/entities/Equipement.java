/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.m.domotique.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author bashizip
 */
@Entity
@Table(name = "EQUIPEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipement.findAll", query = "SELECT e FROM Equipement e"),
    @NamedQuery(name = "Equipement.findById", query = "SELECT e FROM Equipement e WHERE e.id = :id"),
    @NamedQuery(name = "Equipement.findByNom", query = "SELECT e FROM Equipement e WHERE e.nom = :nom"),
    @NamedQuery(name = "Equipement.findByDescription", query = "SELECT e FROM Equipement e WHERE e.description = :description"),
    @NamedQuery(name = "Equipement.findByEtat", query = "SELECT e FROM Equipement e WHERE e.etat = :etat"),
    @NamedQuery(name = "Equipement.findByPiece", query = "SELECT e FROM Equipement e WHERE e.pieceId.id = :piece_id"),
    @NamedQuery(name = "Equipement.findByRelay", query = "SELECT e FROM Equipement e WHERE e.relay = :relay")})
public class Equipement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Size(max = 30)
    @Column(name = "NOM", length = 30)
    private String nom;
    @Size(max = 50)
    @Column(name = "DESCRIPTION", length = 50)
    private String description;
    @Column(name = "ETAT")
    private Boolean etat;
    @Size(max = 30)
    @Column(name = "RELAY", length = 30)
    private String relay;
    @JoinColumn(name = "PIECE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Piece pieceId;

    public Equipement() {
    }

    public Equipement(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public String getRelay() {
        return relay;
    }

    public void setRelay(String relay) {
        this.relay = relay;
    }

    public Piece getPieceId() {
        return pieceId;
    }

    public void setPieceId(Piece pieceId) {
        this.pieceId = pieceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipement)) {
            return false;
        }
        Equipement other = (Equipement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jcertif.m.domotique.entities.Equipement[ id=" + id + " ]";
    }
    
}
