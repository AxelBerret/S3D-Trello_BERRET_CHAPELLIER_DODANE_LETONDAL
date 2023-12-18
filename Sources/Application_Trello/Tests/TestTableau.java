import com.example.application_trello.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTableau {

    @Test
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
    public void test_04_getListeTaches() {
        Tableau tableau = new Tableau("TableauTest");
        Colonne colonne1 = new Colonne("Colonne1");
        Tache tache1 = new TacheSimple("Tache1");
        Tache tache2 = new TacheSimple("Tache2");
        colonne1.ajouterTache(tache1);
        colonne1.ajouterTache(tache2);
        tableau.ajouterColonne(colonne1);
    }
}
