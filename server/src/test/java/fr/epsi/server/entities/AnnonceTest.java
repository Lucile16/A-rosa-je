package fr.epsi.server.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("AnnonceTest(...)")
class AnnonceTest {
    Utilisateur utilisateur1 = new Utilisateur(
            "Smith",
            "John",
            "email@example.com",
            "P@ssw0rd",
            null,
            null);

    Utilisateur utilisateur2 = new Utilisateur(
            "Smith",
            "Luc",
            "autreemail@example.com",
            "P@ssw0rd2",
            null,
            null);

    Adresse adresse = new Adresse(
            1,
            "rue de la paix",
            "Paris",
            75000);
    Plante plante = new Plante(
            "fougère",
            "photo",
            "40cm x 40cm x 80cm",
            "fréquente",
            "3 fois par semaine",
            "Ptéridophytes",
            "La grande majorité des fougères et leurs cousines se plaisent dans les milieux humides et ombragées.");

    @Test
    @DisplayName("L'utilisateur est créé")
    void creationUtilisateur() {
        assertNotNull(utilisateur1);
        assertEquals("Smith", utilisateur1.getNom());
        assertEquals("John", utilisateur1.getPrenom());
        assertEquals("email@example.com", utilisateur1.getEmail());
        assertEquals("P@ssw0rd", utilisateur1.getMotDePasse());
        assertNull(utilisateur1.getAnnonces());
        assertNull(utilisateur1.getAnnonce());

        assertNotNull(utilisateur2);
        assertEquals("Smith", utilisateur2.getNom());
        assertEquals("Luc", utilisateur2.getPrenom());
        assertEquals("autreemail@example.com", utilisateur2.getEmail());
        assertEquals("P@ssw0rd2", utilisateur2.getMotDePasse());
        assertNull(utilisateur2.getAnnonces());
        assertNull(utilisateur2.getAnnonce());
    }

    @Test
    @DisplayName("La plante est créée")
    void creationPlante() {
        assertNotNull(plante);
        assertEquals("fougère", plante.getNom());
        assertEquals("photo", plante.getPhoto());
        assertEquals("40cm x 40cm x 80cm", plante.getDimension());
        assertEquals("fréquente", plante.getExposition());
        assertEquals("3 fois par semaine", plante.getArrosage());
        assertEquals("Ptéridophytes", plante.getFamille());
        assertEquals("La grande majorité des fougères et leurs cousines se plaisent dans les milieux humides et ombragées.", plante.getDescription());
    }

    @Test
    @DisplayName("L'annonce est créée")
    void creationAnnonce() {
        Annonce annonce = new Annonce(
                "à garder",
                "Nouvelle annonce pour garder ma fougère",
                "description",
                "photo",
                utilisateur1,
                utilisateur2,
                adresse);
        assertNotNull(annonce);
        assertEquals("à garder", annonce.getEtat());
        assertEquals("Nouvelle annonce pour garder ma fougère", annonce.getTitre());
        assertEquals("description", annonce.getDescription());
        assertEquals("photo", annonce.getImage());
        assertEquals(utilisateur1, annonce.getProprietaire());
        assertEquals(utilisateur2, annonce.getGardien());
        assertEquals(adresse, annonce.getAdresse());
    }
}