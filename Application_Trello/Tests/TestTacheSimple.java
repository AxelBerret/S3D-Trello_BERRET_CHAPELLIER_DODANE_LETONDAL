import org.junit.jupiter.api.Test;
import com.example.application_trello.*;

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
        Date dateFin = new Date();
        tacheSimple.setDateFin(dateFin);
        assertEquals(dateFin, tacheSimple.getDateFin());
    }
}
