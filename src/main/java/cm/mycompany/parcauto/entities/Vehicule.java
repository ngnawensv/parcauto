/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.mycompany.parcauto.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author vivien saa
 */
@Entity
public class Vehicule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String immatriculation;

    @Column(nullable = false)
    private String nom_du_modele;

    @Column(nullable = false)
    private String couleur;

    @Column(nullable = false)
    private String annee_fabrication;

    private String image;

    @ManyToOne
    private Personne proprietaire;

    @ManyToOne
    private Marque marque;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getNom_du_modele() {
        return nom_du_modele;
    }

    public void setNom_du_modele(String nom_du_modele) {
        this.nom_du_modele = nom_du_modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getAnnee_fabrication() {
        return annee_fabrication;
    }

    public void setAnnee_fabrication(String annee_fabrication) {
        this.annee_fabrication = annee_fabrication;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Personne getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Personne personne) {
        this.proprietaire = personne;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.immatriculation);
        hash = 37 * hash + Objects.hashCode(this.nom_du_modele);
        hash = 37 * hash + Objects.hashCode(this.couleur);
        hash = 37 * hash + Objects.hashCode(this.annee_fabrication);
        hash = 37 * hash + Objects.hashCode(this.image);
        hash = 37 * hash + Objects.hashCode(this.proprietaire);
        hash = 37 * hash + Objects.hashCode(this.marque);
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
        final Vehicule other = (Vehicule) obj;
        if (!Objects.equals(this.immatriculation, other.immatriculation)) {
            return false;
        }
        if (!Objects.equals(this.nom_du_modele, other.nom_du_modele)) {
            return false;
        }
        if (!Objects.equals(this.couleur, other.couleur)) {
            return false;
        }
        if (!Objects.equals(this.annee_fabrication, other.annee_fabrication)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.proprietaire, other.proprietaire)) {
            return false;
        }
        return Objects.equals(this.marque, other.marque);
    }

    @Override
    public String toString() {
        return "Voiture{" + "id=" + id + ", immatriculation=" + immatriculation
                + ", nom_du_modele=" + nom_du_modele + ", couleur="
                + couleur + ", annee_fabrication=" + annee_fabrication
                + ", image=" + image + ", personne=" + proprietaire
                + ", marque=" + marque + '}';
    }

}
