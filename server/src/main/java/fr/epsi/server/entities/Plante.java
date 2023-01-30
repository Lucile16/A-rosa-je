package fr.epsi.server.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import javax.swing.*;

@Entity
public class Plante {
    @Id
    private Integer id;
    private String nom;
    private ImageIcon image;
    private String dimension;
    private String exposition;
    private String arrosage;
    private String famille;

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
}
