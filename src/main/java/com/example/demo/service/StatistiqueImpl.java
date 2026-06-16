package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class StatistiqueImplTest {

    StatistiqueImpl statistique;

    @BeforeEach
    void init() {
        statistique = new StatistiqueImpl();
    }

    @Test
    void ajouterUneVoiture() {
        statistique.ajouter(new Voiture("Renault", 10000));
        Echantillon resultat = statistique.prixMoyen();
        assertEquals(1, resultat.getNombreDeVoitures());
        assertEquals(10000, resultat.getPrixMoyen());
    }

    @Test
    void prixMoyenPlusieursVoitures() {
        statistique.ajouter(new Voiture("Renault", 10000));
        statistique.ajouter(new Voiture("Peugeot", 20000));
        statistique.ajouter(new Voiture("Ferrari", 30000));

        Echantillon resultat = statistique.prixMoyen();
        assertEquals(3, resultat.getNombreDeVoitures());
        assertEquals(20000, resultat.getPrixMoyen());
    }

    @Test
    void prixMoyenAvecListeVide() {
        assertThrows(ArithmeticException.class, () -> statistique.prixMoyen());
    }
}