package fr.epsi.server.entities;

import jakarta.persistence.*;

import javax.swing.*;
import java.io.File;
import java.util.Set;


@Entity
public class Annonce{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //TODO Enum
    private String etat;
    private String titre;
    private String description;
    // Maybe un set, stocker en file, ça sera une piste d'amelioration
    private String image;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(name = "ID_ANNONCE", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_PLANTE", referencedColumnName = "ID")
    )
    private Set<Plante> plantes;

    @ManyToOne(cascade = CascadeType.ALL)
    private Utilisateur proprietaire;

    @OneToMany(mappedBy = "annonce")
    private Set<Commentaire> commentaires;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_GARDIEN")
    private Utilisateur gardien;
    @Embedded
    private Adresse adresse;


    public Annonce() {
    }

    public Annonce(String etat, String titre, String description) {
        this.etat = etat;
        this.titre = titre;
        this.description = description;
    }

    public Annonce(String etat, String titre, String description, String image, Set<Plante> plantes, Utilisateur proprietaire, Set<Commentaire> commentaires, Utilisateur gardien, Adresse adresse) {
        this.etat = etat;
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.plantes = plantes;
        this.proprietaire = proprietaire;
        this.commentaires = commentaires;
        this.gardien = gardien;
        this.adresse = adresse;
    }

    public Annonce(String etat, String titre, String description, String image, Utilisateur proprietaire, Utilisateur gardien, Adresse adresse) {
        this.etat = etat;
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.proprietaire = proprietaire;
        this.gardien = gardien;
        this.adresse = adresse;
    }

    public Annonce(String titre, Set<Plante> plantes, Utilisateur proprietaire) {
        this.titre = titre;
        this.plantes = plantes;
        this.proprietaire = proprietaire;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Plante> getPlantes() {
        return plantes;
    }

    public void setPlantes(Set<Plante> plantes) {
        this.plantes = plantes;
    }

    public Utilisateur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Utilisateur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Set<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(Set<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public Utilisateur getGardien() {
        return gardien;
    }

    public void setGardien(Utilisateur gardien) {
        this.gardien = gardien;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Annonce{" +
                "id=" + id +
                ", etat='" + etat + '\'' +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", plantes=" + plantes +
                ", proprietaire=" + proprietaire +
                ", commentaires=" + commentaires +
                ", gardien=" + gardien +
                ", adresse=" + adresse +
                '}';
    }
}
