package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class VoitureTest {

    @Test
    void constructeurAvecParametres() {
        Voiture v = new Voiture("Ferrari", 2000);
        assertEquals("Ferrari", v.getMarque());
        assertEquals(2000, v.getPrix());
    }

    @Test
    void setEtGetPrix() {
        Voiture v = new Voiture("Ferrari", 2000);
        v.setPrix(3000);
        assertEquals(3000, v.getPrix());
    }

    @Test
    void setEtGetMarque() {
        Voiture v = new Voiture();
        v.setMarque("Toyota");
        assertEquals("Toyota", v.getMarque());
    }

    @Test
    void setEtGetId() {
        Voiture v = new Voiture();
        v.setId(42);
        assertEquals(42, v.getId());
    }

    @Test
    void toStringContientLesChamps() {
        Voiture v = new Voiture("Renault", 1500);
        v.setId(7);
        String texte = v.toString();
        assertTrue(texte.contains("Renault"));
        assertTrue(texte.contains("1500"));
        assertTrue(texte.contains("7"));
    }
}
