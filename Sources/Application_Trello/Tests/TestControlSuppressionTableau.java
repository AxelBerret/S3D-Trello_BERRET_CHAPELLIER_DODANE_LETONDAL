import com.example.application_trello.*;
import com.example.application_trello.Controls.ControlSuppressionTableau;
import com.example.application_trello.Objects.ListeTableaux;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * classe TestControlSuppressionTableau
 * test les differentes methodes de la classe ControlSuppressionTableau
 * fait par Logan
 */

public class TestControlSuppressionTableau {
    // Attributs
    public ListeTableaux listeTableaux;
    public ControlSuppressionTableau controlSuppressionTableau;

    @BeforeEach
    public void setUp(){
        // Initialisation des objets nécessaires pour les tests
        listeTableaux = new ListeTableaux();
        controlSuppressionTableau = new ControlSuppressionTableau(listeTableaux);
    }

    /**
     * test_01
     * test du constructeur de la classe ControlSuppressionColonne
     */
    @Test
    public void test_01_constructeurControlSuppressionTableau(){
        // Vérifie si le constructeur est correctement initialisé
        assertEquals(listeTableaux, controlSuppressionTableau.getListeTab());
    }

    /**
     * test_02
     * test la methode ExtraireNomColonneDeID de la classe ControlSuppressionColonne
     */

    @Test
    public void test_02_extraireNomColonneDeID(){
        // Appeler la méthode extraireNomColonneDeID avec un ID de bouton
        String nomTab = controlSuppressionTableau.extraireNomTableauDeID("boutonSupprimerTableauTest");

        // Vérifier si le nom de la colonne extrait est correct
        assertEquals("Test", nomTab);
    }

}

