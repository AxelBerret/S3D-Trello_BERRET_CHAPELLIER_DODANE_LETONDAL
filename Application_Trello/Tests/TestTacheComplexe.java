import com.example.application_trello.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTacheComplexe {

    @Test
    public void test_01_constructeurTacheComplexe() {
        TacheComplexe tc = new TacheComplexe("tc");
        assertEquals(true, tc.getNomTache().equals("tc"));
        assertEquals(0, tc.getListeTaches());
    }

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

    @Test
    public void test_05_setDateFinInferieure() {
        TacheComplexe tc = new TacheComplexe("tc");
        TacheSimple ts1 = new TacheSimple("ts1");
        TacheSimple ts2 = new TacheSimple("ts2");
        TacheSimple ts3 = new TacheSimple("ts3");

        LocalDate dTs1 = LocalDate.of(2023, 1, 1);
        LocalDate fTs1 = LocalDate.of(2023, 1, 5);

        //ts1.setDateDebut();

        tc.ajouterTache(ts1);
        tc.ajouterTache(ts2);
        tc.ajouterTache(ts3);
        tc.setDateFin(new Date());
        //assertEquals();
    }
}
