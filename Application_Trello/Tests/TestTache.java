import org.junit.jupiter.api.Test;
import com.example.application_trello.Tache;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
import com.example.application_trello.*;
    public class TestTache {

        @Test
        public void test_01_constructeurTache() {
            Tache tache = new TacheSimple("Tache1");
            assertEquals("Tache1", tache.getNomTache());
            assertNull(tache.getCommentaire());
            assertNull(tache.getDateDebut());
            assertNull(tache.getDateFin());
            assertTrue(tache.getListeDependances().isEmpty());
        }

        @Test
        public void test_02_setCommentaire() {
            Tache tache = new TacheSimple("Tache1");
            tache.setCommentaire("Commentaire test");
            assertEquals("Commentaire test", tache.getCommentaire());
        }

        @Test
        public void test_03_setDateDebut() {
            Tache tache = new TacheSimple("Tache1");
            Date dateDebut = new Date();
            tache.setDateDebut(dateDebut);
            assertEquals(dateDebut, tache.getDateDebut());
        }

        @Test
        public void test_04_ajouterRetirerDependance() {
            Tache tache1 = new TacheSimple("Tache1");
            Tache tache2 = new TacheSimple("Tache2");

            tache1.ajouterDependance(tache2);
            assertTrue(tache1.getListeDependances().contains(tache2));

            tache1.retirerDependance(tache2);
            assertFalse(tache1.getListeDependances().contains(tache2));
        }

        @Test
        public void test_05_equals() {
            Tache tache1 = new TacheSimple("Tache1");
            Tache tache2 = new TacheSimple("Tache1");

            assertTrue(tache1.equals(tache2));
        }
    }

