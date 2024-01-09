import com.example.application_trello.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * classe TestControlCreationTableau
 * test les differentes methodes de la classe ControlCreationTableau
 * fait par Logan
 */

public class TestControlCreationTableau {
    //Attributs
    ListeTableaux listeTableaux;
    ControlCreationTableau controlCreationTableau;

    @BeforeEach
    public void setUp(){
        // Initialisation des objets nécessaires pour les tests
        listeTableaux = new ListeTableaux();
        controlCreationTableau = new ControlCreationTableau(listeTableaux);
    }

    /**
     * test_01
     * test du constructeur de la classe ControlCreationTableau
     */
    @Test
    public void test_01_constructeurControlCreationTableau(){
        // Vérifie si le contructeur est correctement initialisé
        assertEquals(listeTableaux, controlCreationTableau.getListeTab());
    }
}
