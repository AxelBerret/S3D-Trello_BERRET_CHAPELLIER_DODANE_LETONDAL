import com.example.application_trello.Tableau;
import com.example.application_trello.Colonne;
import com.example.application_trello.Tache;
import com.example.application_trello.TacheSimple;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTableau {

    @Test
    public void test_01_constructeurTableau() {
        Tableau tableau = new Tableau("TableauTest");
        assertEquals("TableauTest", tableau.getNomTableau());
        assertEquals(0, tableau.getListeColonnes().size());
        assertEquals(0, tableau.getListeTaches().size());
    }

    @Test
    public void test_02_ajouterColonne() {
        Tableau tableau = new Tableau("TableauTest");
        Colonne colonne = new Colonne("ColonneTest");
        tableau.ajouterColonne(colonne);
        assertEquals(1, tableau.getListeColonnes().size());
        assertEquals("ColonneTest", tableau.getListeColonnes().get(0).getNomColonne());
    }
    @Test
    public void test_03_supprimerColonne() {
        Tableau tableau = new Tableau("TableauTest");
        Colonne colonne1 = new Colonne("Colonne1");
        Colonne colonne2 = new Colonne("Colonne2");
        tableau.ajouterColonne(colonne1);
        tableau.ajouterColonne(colonne2);
        assertEquals(2, tableau.getListeColonnes().size());
        tableau.supprimerColonne(colonne1);
        assertEquals(1, tableau.getListeColonnes().size());
        assertEquals("Colonne2", tableau.getListeColonnes().get(0).getNomColonne());
    }

    @Test
    public void test_04_getListeColonnes() {
        Tableau tableau = new Tableau("TableauTest");
        Colonne colonne1 = new Colonne("Colonne1");
        Colonne colonne2 = new Colonne("Colonne2");
        Colonne colonne3 = new Colonne("Colonne3");
        tableau.ajouterColonne(colonne1);
        tableau.ajouterColonne(colonne2);
        tableau.ajouterColonne(colonne3);
        assertEquals(true, tableau.getListeColonnes().get(0).equals(colonne1));
        assertEquals(true, tableau.getListeColonnes().get(1).equals(colonne2));
        assertEquals(true, tableau.getListeColonnes().get(2).equals(colonne3));
    }

    @Test
    public void test_05_getColonne() {
        Tableau tableau = new Tableau("TableauTes");
        Colonne colonne1 = new Colonne("Colonne1");
        Colonne colonne2 = new Colonne("Colonne2");
        Colonne colonne3 = new Colonne("Colonne3");
        tableau.ajouterColonne(colonne1);
        tableau.ajouterColonne(colonne2);
        tableau.ajouterColonne(colonne3);
        assertEquals(true, tableau.getColonne("Colonne1").equals(colonne1));
        assertEquals(true, tableau.getColonne("Colonne2").equals(colonne2));
        assertEquals(true, tableau.getColonne("Colonne3").equals(colonne3));
    }

    @Test
    public void test_06_getListeTaches() {
        Tableau tableau = new Tableau("TableauTest");
        Colonne colonne1 = new Colonne("Colonne1");
        Tache tache1 = new TacheSimple("Tache1");
        Tache tache2 = new TacheSimple("Tache2");
        colonne1.ajouterTache(tache1);
        colonne1.ajouterTache(tache2);
        tableau.ajouterColonne(colonne1);
        assertEquals(true, tableau.getColonne("Colonne1").getListeTaches().get(0).equals(tache1));
        assertEquals(true, tableau.getColonne("Colonne1").getListeTaches().get(1).equals(tache2));
    }

    @Test
    public void test_07_getTache() {
        Tableau tableau = new Tableau("TableauTest");
        Colonne colonne1 = new Colonne("Colonne1");
        Tache tache1 = new TacheSimple("Tache1");
        Tache tache2 = new TacheSimple("Tache2");
        Tache tache3 = new TacheSimple("Tache3");
        colonne1.ajouterTache(tache1);
        colonne1.ajouterTache(tache2);
        colonne1.ajouterTache(tache3);
        tableau.ajouterColonne(colonne1);
        assertEquals(true, tableau.getTache("Tache1").equals(tache1));
        assertEquals(true, tableau.getTache("Tache2").equals(tache2));
        assertEquals(true, tableau.getTache("Tache3").equals(tache3));
    }

    @Test
    public void test_08_ajouterTache() {
        Tableau tableau = new Tableau("TableauTest");
        Colonne colonne1 = new Colonne("Colonne1");
        Tache tache1 = new TacheSimple("Tache1");
        Tache tache2 = new TacheSimple("Tache2");
        Tache tache3 = new TacheSimple("Tache3");
        tableau.ajouterColonne(colonne1);
        assertEquals(true, tableau.getListeTaches().isEmpty());
        tableau.ajouterTache("Tache1", "Colonne1");
        tableau.ajouterTache("Tache2", "Colonne1");
        tableau.ajouterTache("Tache3", "Colonne1");
        assertEquals(true, tableau.getTache("Tache1").equals(tache1));
        assertEquals(true, tableau.getTache("Tache2").equals(tache2));
        assertEquals(true, tableau.getTache("Tache3").equals(tache3));
    }

    @Test
    public void test_09_supprimerTache() {
        Tableau tableau = new Tableau("TableauTest");
        Colonne colonne1 = new Colonne("Colonne1");
        Tache tache1 = new TacheSimple("Tache1");
        Tache tache2 = new TacheSimple("Tache2");
        Tache tache3 = new TacheSimple("Tache3");
        tableau.ajouterColonne(colonne1);
        tableau.ajouterTache("Tache1", "Colonne1");
        tableau.ajouterTache("Tache2", "Colonne1");
        tableau.ajouterTache("Tache3", "Colonne1");
        assertEquals(true, tableau.getTache("Tache1").equals(tache1));
        assertEquals(true, tableau.getTache("Tache2").equals(tache2));
        assertEquals(true, tableau.getTache("Tache3").equals(tache3));
        tableau.supprimerTache("Tache1", "Colonne1");
        tableau.supprimerTache("Tache2", "Colonne1");
        tableau.supprimerTache("Tache3", "Colonne1");
        assertEquals(true, tableau.getListeTaches().isEmpty());
    }

    @Test
    public void test_10_archiverTache() {
        Tableau tableau = new Tableau("TableauTest");
        Colonne colonne1 = new Colonne("Colonne1");
        Tache tache1 = new TacheSimple("Tache1");
        Tache tache2 = new TacheSimple("Tache2");
        Tache tache3 = new TacheSimple("Tache3");
        tableau.ajouterColonne(colonne1);
        tableau.ajouterTache("Tache1", "Colonne1");
        tableau.ajouterTache("Tache2", "Colonne1");
        tableau.ajouterTache("Tache3", "Colonne1");
        assertEquals(true, tableau.getTache("Tache1").equals(tache1));
        assertEquals(true, tableau.getTache("Tache2").equals(tache2));
        assertEquals(true, tableau.getTache("Tache3").equals(tache3));
        assertEquals(true, tableau.getArchive().getListeTachesArchivees().isEmpty());
        tableau.archiverTache("Tache3", "Colonne1");
        assertEquals(true, tableau.getTache("Tache1").equals(tache1));
        assertEquals(true, tableau.getTache("Tache2").equals(tache2));
        assertEquals(true, tableau.getArchive().getListeTachesArchivees().get(0).equals(tache3));
    }

    @Test
    public void test_11_desarchiverTache() {

    }

    @Test
    public void test_12_archiverColonne() {

    }

    @Test
    public void test_13_desarchiverColonne() {

    }
}
