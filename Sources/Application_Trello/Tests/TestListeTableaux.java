import com.example.application_trello.ListeTableaux;
import com.example.application_trello.Tableau;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * classe TestListeTableaux
 * test les differentes methodes de la classe ListeTableaux
 * fait par Logan
 */
public class TestListeTableaux {

    /**
     * test_01
     * test le constructeur de la classe ListeTableaux
     */
    @Test
    public void test_01_Construteur() {
        ListeTableaux listeTableaux = new ListeTableaux();
        assertEquals(0, listeTableaux.getListeTableaux().size());
    }

    /**
     * test_02
     * test la methode ajouterTableau de la classe ListeTableaux
     */
    @Test
    public void test_02_ajouterTableau() {
        ListeTableaux listeTableaux = new ListeTableaux();
        Tableau tableau = new Tableau("TableauTest");
        Tableau tableau2 = new Tableau("TableauTest2");
        listeTableaux.ajouterTableau(tableau);
        listeTableaux.ajouterTableau(tableau2);
        assertEquals(2, listeTableaux.getListeTableaux().size());
        assertEquals("TableauTest", listeTableaux.getListeTableaux().get(0).getNomTableau());
    }

    /**
     * test_03
     * test la methode supprimerTableau de la classe ListeTableaux
     */
    @Test
    public void test_03_supprimerTableau() {
        ListeTableaux listeTableaux = new ListeTableaux();
        Tableau tableau = new Tableau("TableauTest");
        Tableau tableau2 = new Tableau("TableauTest2");
        listeTableaux.ajouterTableau(tableau);
        listeTableaux.ajouterTableau(tableau2);
        listeTableaux.supprimerTableau(tableau);
        assertEquals(1, listeTableaux.getListeTableaux().size());
        assertEquals("TableauTest2", listeTableaux.getListeTableaux().get(0).getNomTableau());
    }

    /**
     * test_04
     * test la methode getTableau de la classe ListeTableaux
     */
    @Test
    public void test_04_getTableau() {
        ListeTableaux listeTableaux = new ListeTableaux();
        Tableau tableau = new Tableau("TableauTest");
        Tableau tableau2 = new Tableau("TableauTest2");
        listeTableaux.ajouterTableau(tableau);
        listeTableaux.ajouterTableau(tableau2);
        assertEquals("TableauTest", listeTableaux.getTableau("TableauTest").getNomTableau());
        assertEquals("TableauTest2", listeTableaux.getTableau("TableauTest2").getNomTableau());
    }
}
