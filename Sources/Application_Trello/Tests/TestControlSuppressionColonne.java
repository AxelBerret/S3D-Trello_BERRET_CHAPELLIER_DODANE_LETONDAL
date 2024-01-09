import com.example.application_trello.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * classe TestControlSuppressionColonne
 * test les differentes methodes de la classe ControlSuppressionColonne
 * fait par Logan
 */
public class TestControlSuppressionColonne {

    // Attributs
    public Tableau tableau;
    public ControlSuppressionColonne controlSuppressionColonne;

    @BeforeEach
    public void setUp(){
        // Initialisation des objets nécessaires pour les tests
        tableau = new Tableau("Test");
        controlSuppressionColonne = new ControlSuppressionColonne(tableau);
    }

    /**
     * test_01
     * test du constructeur de la classe ControlSuppressionColonne
     */
    @Test
    public void test_01_constructeurControlSuppressionColonne(){
        // Vérifie si le contructeur est correctement initialisé
        assertEquals(tableau, controlSuppressionColonne.getTab());
    }

    /**
     * test_02
     * test la methode ExtraireNomColonneDeID de la classe ControlSuppressionColonne
     */

    @Test
    public void test_02_extraireNomColonneDeID(){
        // Appeler la méthode extraireNomColonneDeID avec un ID de bouton
        String nomColonne = controlSuppressionColonne.extraireNomColonneDeID("btnSupprimerColonneTest");

        // Vérifier si le nom de la colonne extrait est correct
        assertEquals("Test", nomColonne);
    }

}
