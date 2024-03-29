import com.example.application_trello.*;
import com.example.application_trello.Controls.ControlCreationColonne;
import com.example.application_trello.Objects.Tableau;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * classe TestControlCreationColonne
 * test les differentes methodes de la classe ControlCreationColonne
 * fait par Logan
 */
public class TestControlCreationColonne {

    // Attributs
    public Tableau tableau;
    public ControlCreationColonne controlCreationColonne;

    @BeforeEach
    public void setUp(){
        // Initialisation des objets nécessaires pour les tests
        tableau = new Tableau("Test");
        controlCreationColonne = new ControlCreationColonne(tableau);
    }

    /**
     * test_01
     * test du constructeur de la classe ControlCreationColonne
     */
    @Test
    public void test_01_constructeurControlCreationColonne(){
        // Vérifie si le contructeur est correctement initialisé
        assertEquals(tableau, controlCreationColonne.getTab());
    }
}
