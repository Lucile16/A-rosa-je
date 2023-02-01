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
    private File image;
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "ID_ANNONCE", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_PLANTE", referencedColumnName = "ID")
    )
    private Set<Plante> plantes;

    @ManyToOne
    private Utilisateur proprietaire;

    @OneToMany(mappedBy = "annonce")
    private Set<Commentaire> commentaires;
    @OneToOne
    @JoinColumn(name = "ID_GARDIEN")
    private Utilisateur gardien;

    //Pb one to one pour les gardiens alors que déjà One to Many sur le meme, maybe forcer un nom
    @Embedded
    private Adresse adresse;


    public Annonce() {
    }

    public Annonce(String etat, String titre, String description) {
        this.etat = etat;
        this.titre = titre;
        this.description = description;
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

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
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
