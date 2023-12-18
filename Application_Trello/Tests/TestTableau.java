import com.example.application_trello.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTableau {

    @Test
<<<<<<< HEAD
    public void test_01_intituleTest() {
        
=======
    public void test_01_constructeurTableau() {
        Tableau tableau = new Tableau("TableauTest");
        assertEquals("TableauTest", tableau.getNomTableau());
        assertEquals(0, tableau.getColonnes().size());
        assertEquals(0, tableau.getListeTaches().size());
    }

    @Test
    public void test_02_ajouterColonne() {
        Tableau tableau = new Tableau("TableauTest");
        Colonne colonne = new Colonne("ColonneTest");
        tableau.ajouterColonne(colonne);

        assertEquals(1, tableau.getColonnes().size());
        assertEquals("ColonneTest", tableau.getColonnes().get(0).getNomColonne());
    }

    @Test
    public void test_03_supprimerColonne() {
        Tableau tableau = new Tableau("TableauTest");
        Colonne colonne1 = new Colonne("Colonne1");
        Colonne colonne2 = new Colonne("Colonne2");
        tableau.ajouterColonne(colonne1);
        tableau.ajouterColonne(colonne2);

        assertEquals(2, tableau.getColonnes().size());
        tableau.supprimerColonne(colonne1);

        assertEquals(1, tableau.getColonnes().size());
        assertEquals("Colonne2", tableau.getColonnes().get(0).getNomColonne());
    }

    @Test
    public void test_04_archiverTache() {
        Tableau tableau = new Tableau("TableauTest");
        Colonne colonne = new Colonne("ColonneTest");
        Tache tache = new TacheSimple("TacheTest");
        colonne.ajouterTache(tache);
        tableau.ajouterColonne(colonne);

        assertEquals(1, tableau.getListeTaches().size());
        assertEquals(0, tableau.getArchive().getListeTachesArchivees().size());

        tableau.getArchive().archiverTache(tache);

        assertEquals(0, tableau.getListeTaches().size());
        assertEquals(1, tableau.getArchive().getListeTachesArchivees().size());
        assertEquals("TacheTest", tableau.getArchive().getListeTachesArchivees().get(0).getNomTache());
>>>>>>> f9afb19686f5abaa1abe632d7675d729089c1f08
    }
}
