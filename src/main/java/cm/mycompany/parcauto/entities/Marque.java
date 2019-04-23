/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.mycompany.parcauto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author vivien saa
 */
@Entity
public class Marque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom_marque", nullable = false)
    private String nomMarque;

    @Column(name = "pays_origine", nullable = false)
    private String paysOrigine;

    @OneToMany(mappedBy = "marque", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Vehicule> listVehicules;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    public String getPaysOrigine() {
        return paysOrigine;
    }

    public void setPaysOrigine(String paysOrigine) {
        this.paysOrigine = paysOrigine;
    }

    public List<Vehicule> getListVehicules() {
        return listVehicules;
    }

    public void setListVehicules(List<Vehicule> listVehicules) {
        this.listVehicules = listVehicules;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nomMarque);
        hash = 97 * hash + Objects.hashCode(this.paysOrigine);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Marque other = (Marque) obj;
        if (!Objects.equals(this.nomMarque, other.nomMarque)) {
            return false;
        }
        if (!Objects.equals(this.paysOrigine, other.paysOrigine)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Marque{" + "id=" + id + ", nomMarque=" + nomMarque + ", paysOrigine=" + paysOrigine + '}';
    }
}
