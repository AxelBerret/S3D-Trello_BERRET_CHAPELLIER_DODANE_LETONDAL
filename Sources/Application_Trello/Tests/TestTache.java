import com.example.application_trello.Objects.TacheSimple;
import org.junit.jupiter.api.Test;
import com.example.application_trello.Objects.Tache;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import com.example.application_trello.*;

/**
 * classe TestTache
 * test les differentes methodes de la classe Tache
 * fait par Sacha
 */
public class TestTache {

    /**
     * test_01
     * test le constructeur de la classe Tache
     */
    @Test
    public void test_01_constructeurTache() {
        Tache tache = new TacheSimple("Tache1");
        assertEquals("Tache1", tache.getNomTache());
        assertTrue(tache.getListeDependances().isEmpty());
    }

    /**
     * test_02
     * test la methode setCommentaire de la classe Tache
     */
    @Test
    public void test_02_setCommentaire() {
        Tache tache = new TacheSimple("Tache1");
        tache.setCommentaire("Commentaire test");
        assertEquals("Commentaire test", tache.getCommentaire());
    }

    /**
     * test_03
     * test la methode setDateDebut de la classe Tache
     */
    @Test
    public void test_03_setDateDebut() {
        Tache tache = new TacheSimple("Tache1");
        LocalDate dateDebut = LocalDate.of(2023, 1,2);
        tache.setDateDebut(dateDebut);
        assertEquals(2023, tache.getDateDebut().getYear());
        assertEquals(1, tache.getDateDebut().getMonthValue());
        assertEquals(2, tache.getDateDebut().getDayOfMonth());
    }

    /**
     * test_04
     * test la methode setDateDependance de la classe Tache
     */
    @Test
    public void test_04_retirerDependance() {
        Tache tache1 = new TacheSimple("Tache1");
        Tache tache2 = new TacheSimple("Tache2");
        tache1.ajouterDependance(tache2);
        assertTrue(tache1.getListeDependances().contains(tache2));
        tache1.retirerDependance(tache2);
        assertFalse(tache1.getListeDependances().contains(tache2));
    }

    /**
     * test_05
     * test la methode ajouterDependance de la classe Tache
     */
    @Test
    public void test_05_ajouterDependance() {
        Tache tache1 = new TacheSimple("Tache1");
        Tache tache2 = new TacheSimple("Tache2");
        Tache tache3 = new TacheSimple("Tache3");

        tache1.ajouterDependance(tache2);
        tache1.ajouterDependance(tache3);
        //ajout d'une dépendance déjà existante
        tache1.ajouterDependance(tache2);

        assertEquals(2, tache1.getListeDependances().size());
        assertTrue(tache1.getListeDependances().contains(tache2));
        assertTrue(tache1.getListeDependances().contains(tache3));
    }

    /**
     * test_06
     * test la methode equals de la classe Tache
     */
    @Test
    public void test_06_equals() {
        Tache tache1 = new TacheSimple("Tache1");
        Tache tache2 = new TacheSimple("Tache1");
        assertTrue(tache1.equals(tache2));
    }
}