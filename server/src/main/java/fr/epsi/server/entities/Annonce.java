package fr.epsi.server.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import javax.swing.*;


@Entity
public class Annonce{
    @Id
    private Integer id;
    private String titre;
    private String description;
    //A vérifier le type d'une image
    private ImageIcon image;

    @Embedded
    private Adresse adresse;


}
