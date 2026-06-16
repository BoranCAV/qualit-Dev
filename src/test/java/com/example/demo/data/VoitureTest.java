package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture() {
        Voiture v = new Voiture("Ferrari", 2000);
        v.setPrix(3000);
        assertEquals(3000, v.getPrix());
    }

    @Test
    void constructeurVide() {
        Voiture v = new Voiture();
        assertNotNull(v);
    }

    @Test
    void constructeurAvecParametres() {
        Voiture v = new Voiture("Renault", 15000);
        assertEquals("Renault", v.getMarque());
        assertEquals(15000, v.getPrix());
    }

    @Test
    void testGetSetMarque() {
        Voiture v = new Voiture();
        v.setMarque("Peugeot");
        assertEquals("Peugeot", v.getMarque());
    }

    @Test
    void testGetSetPrix() {
        Voiture v = new Voiture();
        v.setPrix(12000);
        assertEquals(12000, v.getPrix());
    }

    @Test
    void testGetSetId() {
        Voiture v = new Voiture();
        v.setId(5);
        assertEquals(5, v.getId());
    }

    @Test
    void testToString() {
        Voiture v = new Voiture("Ferrari", 2000);
        v.setId(1);
        String resultat = v.toString();
        assertEquals("Car{marque='Ferrari', prix=2000, id=1}", resultat);
    }
}