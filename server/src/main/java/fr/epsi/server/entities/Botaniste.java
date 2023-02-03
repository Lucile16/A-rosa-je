package fr.epsi.server.entities;

import jakarta.persistence.Entity;

@Entity
public class Botaniste extends Utilisateur{
    private String specialite;
    private Integer experience;
    private String entreprise;

    public Botaniste() {
    }

    public Botaniste(String specialite, Integer experience, String entreprise) {
        this.specialite = specialite;
        this.experience = experience;
        this.entreprise = entreprise;
    }
}
