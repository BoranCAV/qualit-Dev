package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class StatistiqueTests {

    @Test
    void prixMoyenDeDeuxVoituresIdentiques() {
        StatistiqueImpl statistique = new StatistiqueImpl();
        statistique.ajouter(new Voiture("Ferrari", 3000));
        statistique.ajouter(new Voiture("Porsche", 3000));
        Echantillon echantillon = statistique.prixMoyen();
        assertEquals(3000, echantillon.getPrixMoyen());
        assertEquals(2, echantillon.getNombreDeVoitures());
    }

    @Test
    void prixMoyenDeDeuxVoituresDifferentes() {
        StatistiqueImpl statistique = new StatistiqueImpl();
        statistique.ajouter(new Voiture("Ferrari", 1000));
        statistique.ajouter(new Voiture("Porsche", 3000));
        Echantillon echantillon = statistique.prixMoyen();
        assertEquals(2000, echantillon.getPrixMoyen());
        assertEquals(2, echantillon.getNombreDeVoitures());
    }

    @Test
    void prixMoyenAvecUneSeuleVoiture() {
        StatistiqueImpl statistique = new StatistiqueImpl();
        statistique.ajouter(new Voiture("Toyota", 1500));
        Echantillon echantillon = statistique.prixMoyen();
        assertEquals(1500, echantillon.getPrixMoyen());
        assertEquals(1, echantillon.getNombreDeVoitures());
    }

    @Test
    void prixMoyenSansVoitureLeveUneException() {
        StatistiqueImpl statistique = new StatistiqueImpl();
        assertThrows(ArithmeticException.class, () -> statistique.prixMoyen());
    }
}
