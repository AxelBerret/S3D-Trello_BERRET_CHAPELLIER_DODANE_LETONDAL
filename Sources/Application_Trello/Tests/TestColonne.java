import com.example.application_trello.*;
import com.example.application_trello.Objects.Colonne;
import com.example.application_trello.Objects.Tache;
import com.example.application_trello.Objects.TacheSimple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * classe TestColonne
 * test les differentes methodes de la classe Colonne
 * fait par Axel
 */
public class TestColonne {

    /**
     * test_01
     * test le constructeur de la classe Colonne
     */
    @Test
    public void test_01_constructeurColonne() {
        Colonne col = new Colonne("col1");
        assertEquals(true, col.getNomColonne().equals("col1"));
        assertEquals(0, col.getListeTaches().size());
    }

    /**
     * test_02
     * test la methode ajouterTache de la classe Colonne
     */
    @Test
    public void test_02_ajouterTache() {
        Colonne col = new Colonne("col");
        Tache t1 = new TacheSimple("tache1");
        col.ajouterTache(t1);
        assertEquals(true, col.getListeTaches().get(0).equals(t1));
        assertEquals(1, col.getListeTaches().size());
    }

    /**
     * test_03
     * test la methode supprimerTache de la classe Colonne
     */
    @Test
    public void test_03_supprimerTache() {
        Colonne col = new Colonne("col");
        Tache t1 = new TacheSimple("tache1");
        Tache t2 = new TacheSimple("tache2");
        col.ajouterTache(t1);
        col.ajouterTache(t2);
        assertEquals(2, col.getListeTaches().size());
        col.supprimerTache(t1);
        assertEquals("tache2", col.getListeTaches().get(0).getNomTache());
        assertEquals(1, col.getListeTaches().size());
    }
    /**
     * test_04
     * test la methode getTache de la classe Colonne
     */
    @Test
    public void test_04_getTache() {
        Colonne col = new Colonne("col");
        Tache t1 = new TacheSimple("tache1");
        Tache t2 = new TacheSimple("tache2");
        Tache t3 = new TacheSimple("tache3");
        col.ajouterTache(t1);
        col.ajouterTache(t2);
        col.ajouterTache(t3);
        assertEquals(true, col.getTache("tache1").equals(t1));
        assertEquals(true, col.getTache("tache2").equals(t2));
        assertEquals(true, col.getTache("tache3").equals(t3));
    }
}
