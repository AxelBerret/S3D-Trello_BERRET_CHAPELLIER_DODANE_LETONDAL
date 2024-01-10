import org.junit.jupiter.api.Test;
import com.example.application_trello.Objects.*;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * classe TestTacheSimple
 * test les differentes methodes de la classe TacheSimple
 * fait par Axel et Sacha
 */
public class TestTacheSimple {

    /**
     * test_01
     * test le constructeur de la classe TacheSimple
     */
    @Test
    public void test_01_constructeurTacheSimple() {
        TacheSimple tacheSimple = new TacheSimple("Tache1");
        assertEquals("Tache1", tacheSimple.getNomTache());
        assertTrue(tacheSimple.getListeDependances().isEmpty());
    }

    /**
     * test_02
     * test la methode setDateFin de la classe TacheSimple
     */
    @Test
    public void test_02_setDateFin() {
        TacheSimple tacheSimple = new TacheSimple("Tache1");
        LocalDate dateFin = LocalDate.of(2023,2,4);
        tacheSimple.setDateFin(dateFin);
        assertEquals(2023, tacheSimple.getDateFin().getYear());
        assertEquals(2, tacheSimple.getDateFin().getMonthValue());
        assertEquals(4, tacheSimple.getDateFin().getDayOfMonth());
    }
}
