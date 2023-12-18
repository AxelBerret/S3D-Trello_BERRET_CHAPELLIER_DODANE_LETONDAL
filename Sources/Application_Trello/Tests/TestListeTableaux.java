import com.example.application_trello.ListeTableaux;
import com.example.application_trello.Tableau;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestListeTableaux {

    @Test
    public void test_01_Construteur() {
        ListeTableaux listeTableaux = new ListeTableaux();
        assertEquals(0, listeTableaux.getListeTableaux().size());
    }

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
