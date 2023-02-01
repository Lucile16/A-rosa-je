package fr.epsi.server.entities;

import jakarta.persistence.*;

import javax.swing.*;
import java.io.File;

@Entity
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String messgae;
    // Maybe un set d'image aussi
    private File photo;
    @ManyToOne
    private Annonce annonce;

    public Commentaire() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }

    @Override
    public String toString() {
        return "Commentaire{" +
                "id=" + id +
                ", messgae='" + messgae + '\'' +
                ", photo=" + photo +
                ", annonce=" + annonce +
                '}';
    }
}
