package TP.TP3.stamps;

import TP.utils.utils;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * The type Timbre test.
 */
class TimbreTest {

    /**
     * Test equals.
     */
    @Test
    void testEquals() {
        Timbre t1 = new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon");
        Timbre t2 = new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon");
        Timbre t3 = new Timbre(2.2f, "AUD", false, "13", "Australie", "Kangourou roux", "Timbre d'usage courant", "Pro Hart", "Stan Smith");
        Assertions.assertNotNull(t1);
        Assertions.assertNotNull(t2);
        Assertions.assertNotNull(t3);
        Assertions.assertNotEquals(t1, t2);
        Assertions.assertNotEquals(t1, t3);
        Assertions.assertNotEquals(t2, t3);
        Assertions.assertTrue(t1.equals(t2));
        Assertions.assertTrue(t1.equals(t1));
        Assertions.assertTrue(t2.equals(t2));
        Assertions.assertFalse(t1.equals(t3));
        Assertions.assertFalse(t2.equals(t3));
    }

    /**
     * New timbre.
     */
    @Test
    void newTimbre() {
        Timbre t1 = Timbre.newTimbre("test_stamp.json");
        Timbre t2 = new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon");
        Assertions.assertNotNull(t1);
        Assertions.assertNotNull(t2);
        Assertions.assertTrue(t1.equals(t2));
    }

    /**
     * Gets filet.
     */
    @Test
    void getFilet() {
        Timbre t1 = new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon");
        Assertions.assertNotNull(t1.getFilet());
        Assertions.assertEquals(true, t1.getFilet());
    }

    /**
     * Gets valeur.
     */
    @Test
    void getValeur() {
        Timbre t1 = new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon");
        Assertions.assertNotNull(t1.getValeur());
        Assertions.assertEquals(0.86f, t1.getValeur());
    }

    /**
     * Gets dentelure.
     */
    @Test
    void getDentelure() {
        Timbre t1 = new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon");
        Assertions.assertNotNull(t1.getDentelure());
        Assertions.assertEquals("14 ¼", t1.getDentelure());
    }

    /**
     * Gets designation.
     */
    @Test
    void getDesignation() {
        Timbre t1 = new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon");
        Assertions.assertNotNull(t1.getDesignation());
        Assertions.assertEquals("Timbre d'usage courant", t1.getDesignation());
    }

    /**
     * Gets devise valeur.
     */
    @Test
    void getDeviseValeur() {
        Timbre t1 = new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon");
        Assertions.assertNotNull(t1.getDeviseValeur());
        Assertions.assertEquals("EUR", t1.getDeviseValeur());
    }

    /**
     * Gets œuvre.
     */
    @Test
    void getOeuvre() {
        Timbre t1 = new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon");
        Assertions.assertNotNull(t1.getOeuvre());
        Assertions.assertEquals("Sembrador", t1.getOeuvre());
    }

    /**
     * Gets pays orig.
     */
    @Test
    void getPaysOrig() {
        Timbre t1 = new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon");
        Assertions.assertNotNull(t1.getPaysOrig());
        Assertions.assertEquals("France", t1.getPaysOrig());
    }

    /**
     * Gets signature dessinateur.
     */
    @Test
    void getSignatureDessinateur() {
        Timbre t1 = new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon");
        Assertions.assertNotNull(t1.getSignatureDessinateur());
        Assertions.assertEquals("Oscar Roty", t1.getSignatureDessinateur());
    }

    /**
     * Gets signature graveur.
     */
    @Test
    void getSignatureGraveur() {
        Timbre t1 = new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon");
        Assertions.assertNotNull(t1.getSignatureGraveur());
        Assertions.assertEquals("Louis-Eugène Mouchon", t1.getSignatureGraveur());
    }

    /**
     * To json.
     */
    @Test
    void toJson() {
        ObjectNode obj1 = utils.readJSONFile("test_stamp.json");
        Timbre t1 = new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon");
        Assertions.assertNotNull(t1.toJson());
        Assertions.assertNotNull(obj1);
        Assertions.assertEquals(obj1.size(), t1.toJson().size());
        for (int i = 0; i < obj1.size(); ++i) {
            Assertions.assertEquals(obj1.get(i), t1.toJson().get(i));
        }
    }

    /**
     * From json.
     */
    @Test
    void fromJson() {
        ObjectNode obj1 = utils.readJSONFile("test_stamp.json");
        Timbre t1 = new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon");
        Assertions.assertNotNull(obj1);
        Assertions.assertNotNull(t1);
        Assertions.assertTrue(t1.equals(Objects.requireNonNull(Timbre.fromJson(obj1))));
    }

    /**
     * Test to string.
     */
    @Test
    void testToString() {
        Timbre t1 = new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon");
        Assertions.assertNotNull(t1.toString());
        Assertions.assertEquals("""
                *****************************************************************
                valeur :					0.86
                devise :					EUR
                filet :						true
                dentelure :					14 ¼
                pays d'origine :			France
                oeuvre :					Sembrador
                designation :				Timbre d'usage courant
                signature du dessinateur :	Oscar Roty
                signature du graveur :		Louis-Eugène Mouchon
                *****************************************************************
                """, t1.toString());
    }

    /**
     * Assign.
     */
    @Test
    void assign() {
        Timbre t1 = new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon");
        Timbre t2 = new Timbre(2.2f, "AUD", false, "13", "Australie", "Kangourou roux", "Timbre d'usage courant", "Pro Hart", "Stan Smith");
        Assertions.assertNotNull(t1);
        Assertions.assertNotNull(t2);
        Assertions.assertFalse(t1.equals(t2));
        t2.assign(t1);
        Assertions.assertNotEquals(t1, t2);
        Assertions.assertTrue(t1.equals(t2));
    }

    /**
     * Test clone.
     */
    @Test
    void testClone() {
        Timbre t1 = new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon");
        Timbre t2 = t1.clone();
        Assertions.assertNotNull(t1);
        Assertions.assertNotNull(t2);
        Assertions.assertNotEquals(t1, t2);
        Assertions.assertTrue(t1.equals(t2));
    }
}