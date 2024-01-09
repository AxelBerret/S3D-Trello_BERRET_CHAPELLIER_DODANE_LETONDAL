import com.example.application_trello.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * classe TestTacheComplexe
 * test les differentes methodes de la classe TacheComplexe
 * fait par Axel
 */
public class TestTacheComplexe {

    /**
     * test_01
     * test le constructeur de la classe TacheComplexe
     */
    @Test
    public void test_01_constructeurTacheComplexe() {
        TacheComplexe tc = new TacheComplexe("tc");
        assertEquals(true, tc.getNomTache().equals("tc"));
        assertEquals(0, tc.getListeTaches().size());
    }

    /**
     * test_02
     * test la methode ajouterTache de la classe TacheComplexe
     */
    @Test
    public void test_02_ajouterTache() {
        TacheComplexe tc = new TacheComplexe("tc");
        TacheSimple ts1 = new TacheSimple("ts1");
        TacheSimple ts2 = new TacheSimple("ts2");
        TacheSimple ts3 = new TacheSimple("ts3");
        tc.ajouterTache(ts1);
        tc.ajouterTache(ts2);
        tc.ajouterTache(ts3);
        assertEquals(true, tc.getListeTaches().get(0).equals(ts1));
        assertEquals(true, tc.getListeTaches().get(1).equals(ts2));
        assertEquals(true, tc.getListeTaches().get(2).equals(ts3));
        assertEquals(3, tc.getListeTaches().size());
    }
    /**
     * test_03
     * test la methode supprimerTache de la classe TacheComplexe
     */
    @Test
    public void test_03_supprimerTache() {
        TacheComplexe tc = new TacheComplexe("tc");
        TacheSimple ts1 = new TacheSimple("ts1");
        TacheSimple ts2 = new TacheSimple("ts2");
        TacheSimple ts3 = new TacheSimple("ts3");
        tc.ajouterTache(ts1);
        tc.ajouterTache(ts2);
        tc.ajouterTache(ts3);
        tc.supprimerTache(ts2);
        assertEquals(true, tc.getListeTaches().get(0).equals(ts1));
        assertEquals(true, tc.getListeTaches().get(1).equals(ts3));
        assertEquals(2, tc.getListeTaches().size());
    }
    /**
     * test_04
     * test la methode getTache de la classe TacheComplexe
     */
    @Test
    public void test_04_getTache() {
        TacheComplexe tc = new TacheComplexe("tc");
        TacheSimple ts1 = new TacheSimple("ts1");
        TacheSimple ts2 = new TacheSimple("ts2");
        TacheSimple ts3 = new TacheSimple("ts3");
        tc.ajouterTache(ts1);
        tc.ajouterTache(ts2);
        tc.ajouterTache(ts3);
        assertEquals(true, tc.getTache("ts1").equals(ts1));
        assertEquals(true, tc.getTache("ts2").equals(ts2));
        assertEquals(true, tc.getTache("ts3").equals(ts3));
    }

    /**
     * test_05
     * test la methode setDateFinInferieure de la classe TacheComplexe
     */
    @Test
    public void test_05_setDateFinInferieure() {
        Tache tc = new TacheComplexe("tc");
        Tache ts1 = new TacheSimple("ts1");
        Tache ts2 = new TacheSimple("ts2");
        Tache ts3 = new TacheSimple("ts3");

        LocalDate dateFinTs1 = LocalDate.of(2023, 2, 8);
        LocalDate dateFinTs2 = LocalDate.of(2023, 2, 13);
        LocalDate dateFinTs3 = LocalDate.of(2023, 2, 11);
        LocalDate dateFinTc = LocalDate.of(2023, 2, 12);

        ts1.setDateFin(dateFinTs1);
        ts2.setDateFin(dateFinTs2);
        ts3.setDateFin(dateFinTs3);

        ((TacheComplexe) tc).ajouterTache(ts1);
        ((TacheComplexe) tc).ajouterTache(ts2);
        ((TacheComplexe) tc).ajouterTache(ts3);

        tc.setDateFin(dateFinTc);

        assertEquals(2023, tc.getDateFin().getYear());
        assertEquals(2, tc.getDateFin().getMonthValue());
        assertEquals(13, tc.getDateFin().getDayOfMonth());
    }
}
