package fr.epsi.server.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import javax.swing.*;
import java.io.File;
import java.util.Set;

@Entity
public class Plante {
    @Id
    private Integer id;
    private String nom;
    private File photo;
    private String dimension;
    private String exposition;
    private String arrosage;
    private String famille;
    private String description;
    @ManyToMany(mappedBy = "plantes") //cascade = CascadeType.ALL
    private Set<Annonce> annonces;

    public Plante() {
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

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
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
