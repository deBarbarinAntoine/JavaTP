package TP.TP3.stamps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * The type Collection timbre test.
 */
class CollectionTimbreTest {

    /**
     * Creates a stamp list for testing purposes.
     *
     * @return the stamp list
     */
    private ArrayList<Timbre> createStampList() {
        ArrayList<Timbre> myStamps = new ArrayList<>();
        myStamps.add(new Timbre(0.25f, "USD", true, "14", "USA", "Liberty Bell", "Forever Stamp", "C. Saxon", "Thomas Hiatt"));
        myStamps.add(new Timbre(1.15f, "EUR", false, "13 ¼", "France", "Marianne", "Marianne Definitif", "Olivier Ciappa", "Elsa Michelet"));
        myStamps.add(new Timbre(8.0f, "JPY", true, "11", "Japon", "Mont Fuji", "Série paysages", "Katsushiro Kobayashi", "Ryoichi Mori"));
        myStamps.add(new Timbre(0.7f, "GBP", false, "14 ½", "Royaume-Uni", "Elizabeth II", "Second Class", "Arnold Machin", "Timothy Bradbury"));
        myStamps.add(new Timbre(3.0f, "AUD", true, "12 ¾", "Australie", "Koala", "Commemoratif 2023", "Stuart Devlin", "Horst Friedrich"));
        myStamps.add(new Timbre(0.49f, "CAD", false, "13", "Canada", "Feuille d'érable", "Série Nature", "Dennis W. Gies", "Leonard Enright"));
        myStamps.add(new Timbre(0.55f, "CHF", true, "14 ¼", "Suisse", "Le Cervin", "Paysages de montagne", "Urs Wehrli", "Robert Bretscher"));
        myStamps.add(new Timbre(1.2f, "NZD", false, "12 ½", "Nouvelle-Zélande", "Fougère argentée", "Flore indigène", "Colin Heldige", "Simon Hollis"));
        myStamps.add(new Timbre(0.6f, "SEK", true, "13 ¾", "Suède", "Le Vasa", "Navires historiques", "Lars Sjöberg", "Britta Nordin"));
        myStamps.add(new Timbre(2.5f, "BRL", false, "14", "Brésil", "Christ Rédempteur", "Monuments célèbres", "Oscar Oiwa", "Manoel de Barros"));
        myStamps.add(new Timbre(0.49f, "USD", false, "13", "USA", "Statue de la Liberté", "Timbre commémoratif du centenaire", "Edwin Blashfield", "Charles R. Chickering"));
        myStamps.add(new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon"));
        myStamps.add(new Timbre(150.0f, "JPY", false, "10", "Japon", "Grues japonaises en vol", "Timbre commémoratif du Nouvel An", "Shinzo Nakaba", "Takashi Imai"));
        myStamps.add(new Timbre(1.5f, "GBP", true, "15", "Royaume-Uni", "Le Lion et la Couronne", "Timbre commémoratif du Jubilé de platine", "J.E. Blakey", "Robert Austin"));
        myStamps.add(new Timbre(2.2f, "AUD", false, "13", "Australie", "Kangourou roux", "Timbre d'usage courant", "Pro Hart", "Stan Smith"));
        return myStamps;
    }

    /**
     * New collection timbre.
     */
    @Test
    void newCollectionTimbre() {
        CollectionTimbre stampCol1 = new CollectionTimbre(createStampList());
        CollectionTimbre stampCol2 = CollectionTimbre.newCollectionTimbre("test_stamp_collection.json");
        Assertions.assertNotNull(stampCol1);
        Assertions.assertNotNull(stampCol2);
        Assertions.assertNotEquals(stampCol1, stampCol2);
        Assertions.assertEquals(stampCol1.getTimbres().size(), stampCol2.getTimbres().size());
        for (int i = 0; i < stampCol2.getTimbres().size(); ++i) {
            Assertions.assertTrue(stampCol1.getTimbres().get(i).equals(stampCol2.getTimbres().get(i)));
        }
    }

    /**
     * Gets timbres.
     */
    @Test
    void getTimbres() {
        CollectionTimbre stampCol1 = CollectionTimbre.newCollectionTimbre("test_stamp_collection.json");
        ArrayList<Timbre> myStamps = createStampList();
        Assertions.assertNotNull(stampCol1);
        Assertions.assertNotNull(myStamps);
        Assertions.assertNotEquals(stampCol1.getTimbres(), myStamps);
        Assertions.assertEquals(stampCol1.getTimbres().size(), myStamps.size());
        for (int i = 0; i < myStamps.size(); ++i) {
            Assertions.assertTrue(stampCol1.getTimbres().get(i).equals(myStamps.get(i)));
        }
    }

    /**
     * Size.
     */
    @Test
    void size() {
        CollectionTimbre stampCol = CollectionTimbre.newCollectionTimbre("test_stamp_collection.json");
        Assertions.assertNotNull(stampCol);
        Assertions.assertEquals(15, stampCol.size());
    }

    /**
     * Get.
     */
    @Test
    void get() {
        CollectionTimbre stampCol = CollectionTimbre.newCollectionTimbre("test_stamp_collection.json");
        Assertions.assertNotNull(stampCol);

        Timbre stamp0 = new Timbre(0.25f, "USD", true, "14", "USA", "Liberty Bell", "Forever Stamp", "C. Saxon", "Thomas Hiatt");
        Timbre stamp7 = new Timbre(1.2f, "NZD", false, "12 ½", "Nouvelle-Zélande", "Fougère argentée", "Flore indigène", "Colin Heldige", "Simon Hollis");
        Timbre stamp14 = new Timbre(2.2f, "AUD", false, "13", "Australie", "Kangourou roux", "Timbre d'usage courant", "Pro Hart", "Stan Smith");

        Assertions.assertTrue(stamp0.equals(stampCol.get(0)));
        Assertions.assertTrue(stamp7.equals(stampCol.get(7)));
        Assertions.assertTrue(stamp14.equals(stampCol.get(14)));

        Assertions.assertNull(stampCol.get(-1));
        Assertions.assertNull(stampCol.get(16));
    }

    /**
     * Add.
     */
    @Test
    void add() {
        CollectionTimbre stampCol1 = CollectionTimbre.newCollectionTimbre("test_stamp_collection.json");
        int sizeOrig = stampCol1.getTimbres().size();
        Timbre stamp = new Timbre(1.20f, "EUR", true, "14", "France", "Mont St Michel", "Lieux et Monuments", "F. Bivel", "A. Mignon");

        Timbre newStamp = stampCol1.add(stamp).get(sizeOrig);
        Assertions.assertNotNull(stampCol1);
        Assertions.assertEquals(sizeOrig+1, stampCol1.getTimbres().size());
        Assertions.assertTrue(stamp.equals(stampCol1.get(sizeOrig)));
        Assertions.assertTrue(newStamp.equals(stampCol1.get(sizeOrig)));
        Assertions.assertTrue(stamp.equals(newStamp));
    }

    /**
     * Remove.
     */
    @Test
    void remove() {
        CollectionTimbre stampCol = CollectionTimbre.newCollectionTimbre("test_stamp_collection.json");
        Assertions.assertNotNull(stampCol);

        Timbre stamp0 = new Timbre(0.25f, "USD", true, "14", "USA", "Liberty Bell", "Forever Stamp", "C. Saxon", "Thomas Hiatt");
        Timbre stamp7 = new Timbre(1.2f, "NZD", false, "12 ½", "Nouvelle-Zélande", "Fougère argentée", "Flore indigène", "Colin Heldige", "Simon Hollis");
        Timbre stamp14 = new Timbre(2.2f, "AUD", false, "13", "Australie", "Kangourou roux", "Timbre d'usage courant", "Pro Hart", "Stan Smith");

        Assertions.assertEquals(14, stampCol.remove(0).size());
        Assertions.assertFalse(stampCol.get(0).equals(stamp0));
        Assertions.assertTrue(stamp7.equals(stampCol.get(6)));
        Assertions.assertTrue(stamp14.equals(stampCol.get(13)));
    }

    /**
     * Test clone.
     */
    @Test
    void testClone() {
        CollectionTimbre stampCol = CollectionTimbre.newCollectionTimbre("test_stamp_collection.json");
        CollectionTimbre clone = stampCol.clone();
        Assertions.assertNotEquals(stampCol, clone);
        Assertions.assertNotNull(clone);
        for (int i = 0; i < stampCol.size(); ++i) {
            Assertions.assertTrue(stampCol.get(i).equals(clone.get(i)));
        }
    }

    /**
     * Sort by.
     */
    @Test
    void sortBy() {
        ArrayList<Timbre> stamps = new ArrayList<>();
        stamps.add(new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon"));
        stamps.add(new Timbre(1.15f, "EUR", false, "13 ¼", "France", "Marianne", "Marianne Definitif", "Olivier Ciappa", "Elsa Michelet"));
        stamps.add(new Timbre(1.0f, "AUD", false, "13", "Australie", "Kangourou roux", "Timbre d'usage courant", "Pro Hart", "Stan Smith"));

        CollectionTimbre stampCol = new CollectionTimbre(stamps);
        Assertions.assertNotNull(stampCol);

        ArrayList<Timbre> sortedStamps1 = new ArrayList<>();
        sortedStamps1.add(new Timbre(1.15f, "EUR", false, "13 ¼", "France", "Marianne", "Marianne Definitif", "Olivier Ciappa", "Elsa Michelet"));
        sortedStamps1.add(new Timbre(1.0f, "AUD", false, "13", "Australie", "Kangourou roux", "Timbre d'usage courant", "Pro Hart", "Stan Smith"));
        sortedStamps1.add(new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon"));

        stampCol.sortBy("valeur", false);
        for (int i = 0; i < stampCol.size(); ++i) {
            Assertions.assertEquals(sortedStamps1.get(i).toString(), stampCol.get(i).toString());
            Assertions.assertTrue(sortedStamps1.get(i).equals(stampCol.get(i)));
        }

        CollectionTimbre stampCol2 = new CollectionTimbre(stamps);

        ArrayList<Timbre> sortedStamps2 = new ArrayList<>();
        sortedStamps2.add(new Timbre(1.15f, "EUR", false, "13 ¼", "France", "Marianne", "Marianne Definitif", "Olivier Ciappa", "Elsa Michelet"));
        sortedStamps2.add(new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon"));
        sortedStamps2.add(new Timbre(1.0f, "AUD", false, "13", "Australie", "Kangourou roux", "Timbre d'usage courant", "Pro Hart", "Stan Smith"));

        stampCol2.sortBy("dessinateur");
        for (int i = 0; i < stampCol2.size(); ++i) {
            Assertions.assertEquals(sortedStamps2.get(i).toString(), stampCol2.get(i).toString());
            Assertions.assertTrue(sortedStamps2.get(i).equals(stampCol2.get(i)));
        }

        CollectionTimbre stampCol3 = new CollectionTimbre(stamps);

        ArrayList<Timbre> sortedStamps3 = new ArrayList<>();
        sortedStamps3.add(new Timbre(1.0f, "AUD", false, "13", "Australie", "Kangourou roux", "Timbre d'usage courant", "Pro Hart", "Stan Smith"));
        sortedStamps3.add(new Timbre(1.15f, "EUR", false, "13 ¼", "France", "Marianne", "Marianne Definitif", "Olivier Ciappa", "Elsa Michelet"));
        sortedStamps3.add(new Timbre(0.86f, "EUR", true, "14 ¼", "France", "Sembrador", "Timbre d'usage courant", "Oscar Roty", "Louis-Eugène Mouchon"));

        stampCol3.sortBy(CollectionTimbre.Sort.newSort("pays"), CollectionTimbre.Sort.newSort("valeur", false));
        for (int i = 0; i < stampCol3.size(); ++i) {
            Assertions.assertEquals(sortedStamps3.get(i).toString(), stampCol3.get(i).toString());
            Assertions.assertTrue(sortedStamps3.get(i).equals(stampCol3.get(i)));
        }
    }

    /**
     * Test to string.
     */
    @Test
    void testToString() {

        CollectionTimbre stampCol = new CollectionTimbre(createStampList());

        String expected = """
                *****************************************************************
                valeur :					0.25
                devise :					USD
                filet :						true
                dentelure :					14
                pays d'origine :			USA
                oeuvre :					Liberty Bell
                designation :				Forever Stamp
                signature du dessinateur :	C. Saxon
                signature du graveur :		Thomas Hiatt
                *****************************************************************
                *****************************************************************
                valeur :					1.15
                devise :					EUR
                filet :						false
                dentelure :					13 ¼
                pays d'origine :			France
                oeuvre :					Marianne
                designation :				Marianne Definitif
                signature du dessinateur :	Olivier Ciappa
                signature du graveur :		Elsa Michelet
                *****************************************************************
                *****************************************************************
                valeur :					8.0
                devise :					JPY
                filet :						true
                dentelure :					11
                pays d'origine :			Japon
                oeuvre :					Mont Fuji
                designation :				Série paysages
                signature du dessinateur :	Katsushiro Kobayashi
                signature du graveur :		Ryoichi Mori
                *****************************************************************
                *****************************************************************
                valeur :					0.7
                devise :					GBP
                filet :						false
                dentelure :					14 ½
                pays d'origine :			Royaume-Uni
                oeuvre :					Elizabeth II
                designation :				Second Class
                signature du dessinateur :	Arnold Machin
                signature du graveur :		Timothy Bradbury
                *****************************************************************
                *****************************************************************
                valeur :					3.0
                devise :					AUD
                filet :						true
                dentelure :					12 ¾
                pays d'origine :			Australie
                oeuvre :					Koala
                designation :				Commemoratif 2023
                signature du dessinateur :	Stuart Devlin
                signature du graveur :		Horst Friedrich
                *****************************************************************
                *****************************************************************
                valeur :					0.49
                devise :					CAD
                filet :						false
                dentelure :					13
                pays d'origine :			Canada
                oeuvre :					Feuille d'érable
                designation :				Série Nature
                signature du dessinateur :	Dennis W. Gies
                signature du graveur :		Leonard Enright
                *****************************************************************
                *****************************************************************
                valeur :					0.55
                devise :					CHF
                filet :						true
                dentelure :					14 ¼
                pays d'origine :			Suisse
                oeuvre :					Le Cervin
                designation :				Paysages de montagne
                signature du dessinateur :	Urs Wehrli
                signature du graveur :		Robert Bretscher
                *****************************************************************
                *****************************************************************
                valeur :					1.2
                devise :					NZD
                filet :						false
                dentelure :					12 ½
                pays d'origine :			Nouvelle-Zélande
                oeuvre :					Fougère argentée
                designation :				Flore indigène
                signature du dessinateur :	Colin Heldige
                signature du graveur :		Simon Hollis
                *****************************************************************
                *****************************************************************
                valeur :					0.6
                devise :					SEK
                filet :						true
                dentelure :					13 ¾
                pays d'origine :			Suède
                oeuvre :					Le Vasa
                designation :				Navires historiques
                signature du dessinateur :	Lars Sjöberg
                signature du graveur :		Britta Nordin
                *****************************************************************
                *****************************************************************
                valeur :					2.5
                devise :					BRL
                filet :						false
                dentelure :					14
                pays d'origine :			Brésil
                oeuvre :					Christ Rédempteur
                designation :				Monuments célèbres
                signature du dessinateur :	Oscar Oiwa
                signature du graveur :		Manoel de Barros
                *****************************************************************
                *****************************************************************
                valeur :					0.49
                devise :					USD
                filet :						false
                dentelure :					13
                pays d'origine :			USA
                oeuvre :					Statue de la Liberté
                designation :				Timbre commémoratif du centenaire
                signature du dessinateur :	Edwin Blashfield
                signature du graveur :		Charles R. Chickering
                *****************************************************************
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
                *****************************************************************
                valeur :					150.0
                devise :					JPY
                filet :						false
                dentelure :					10
                pays d'origine :			Japon
                oeuvre :					Grues japonaises en vol
                designation :				Timbre commémoratif du Nouvel An
                signature du dessinateur :	Shinzo Nakaba
                signature du graveur :		Takashi Imai
                *****************************************************************
                *****************************************************************
                valeur :					1.5
                devise :					GBP
                filet :						true
                dentelure :					15
                pays d'origine :			Royaume-Uni
                oeuvre :					Le Lion et la Couronne
                designation :				Timbre commémoratif du Jubilé de platine
                signature du dessinateur :	J.E. Blakey
                signature du graveur :		Robert Austin
                *****************************************************************
                *****************************************************************
                valeur :					2.2
                devise :					AUD
                filet :						false
                dentelure :					13
                pays d'origine :			Australie
                oeuvre :					Kangourou roux
                designation :				Timbre d'usage courant
                signature du dessinateur :	Pro Hart
                signature du graveur :		Stan Smith
                *****************************************************************
                """;

        Assertions.assertEquals(expected, stampCol.toString());
    }

    /**
     * Gets sorting.
     */
    @Test
    void getSorting() {
        CollectionTimbre stampCol = new CollectionTimbre(createStampList());

        CollectionTimbre.Sort sort = stampCol.getSorting();
        CollectionTimbre.Sort expected = CollectionTimbre.Sort.newSort("valeur", false);

        Assertions.assertNotNull(expected);
        Assertions.assertNotNull(sort);
        Assertions.assertEquals(expected.getIsAscendentOrder(), sort.getIsAscendentOrder());
        Assertions.assertEquals(expected.getFieldStr(), sort.getFieldStr());
    }

    /**
     * Iterator.
     */
    @Test
    void iterator() {
        ArrayList<Timbre> stampList = createStampList();
        CollectionTimbre stampCol = new CollectionTimbre(stampList);

        int i = 0;
        for (Timbre stamp : stampCol) {
            Assertions.assertTrue(stampList.get(i).equals(stamp));
            ++i;
        }

        Assertions.assertEquals(i, stampList.size());
    }
}