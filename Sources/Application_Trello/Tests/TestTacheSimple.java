import org.junit.jupiter.api.Test;
import com.example.application_trello.*;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TestTacheSimple {

    @Test
    public void test_01_constructeurTacheSimple() {
        TacheSimple tacheSimple = new TacheSimple("Tache1");
        assertEquals("Tache1", tacheSimple.getNomTache());
        assertNull(tacheSimple.getCommentaire());
        assertNull(tacheSimple.getDateDebut());
        assertNull(tacheSimple.getDateFin());
        assertTrue(tacheSimple.getListeDependances().isEmpty());
    }

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
