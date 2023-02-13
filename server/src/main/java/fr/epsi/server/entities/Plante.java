package fr.epsi.server.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Plante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String photo;
    private String dimension;
    private String exposition;
    private String arrosage;
    private String famille;
    private String description;
    @ManyToMany(mappedBy = "plantes")
    private Set<Annonce> annonces;

    public Plante() {
    }

    public Plante(String nom, String photo) {
        this.nom = nom;
        this.photo = photo;
    }

    public Plante(String nom, String photo, String dimension, String exposition, String arrosage, String famille, String description, Set<Annonce> annonces) {
        this.nom = nom;
        this.photo = photo;
        this.dimension = dimension;
        this.exposition = exposition;
        this.arrosage = arrosage;
        this.famille = famille;
        this.description = description;
        this.annonces = annonces;
    }

    public Plante(String nom, String photo, String dimension, String exposition, String arrosage, String famille, String description) {
        this.nom = nom;
        this.photo = photo;
        this.dimension = dimension;
        this.exposition = exposition;
        this.arrosage = arrosage;
        this.famille = famille;
        this.description = description;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getExposition() {
        return exposition;
    }

    public void setExposition(String exposition) {
        this.exposition = exposition;
    }

    public String getArrosage() {
        return arrosage;
    }

    public void setArrosage(String arrosage) {
        this.arrosage = arrosage;
    }

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Annonce> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(Set<Annonce> annonces) {
        this.annonces = annonces;
    }

    @Override
    public String toString() {
        return "Plante{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", photo=" + photo +
                ", dimension='" + dimension + '\'' +
                ", exposition='" + exposition + '\'' +
                ", arrosage='" + arrosage + '\'' +
                ", famille='" + famille + '\'' +
                ", description='" + description + '\'' +
                ", annonces=" + annonces +
                '}';
    }
}
