import com.example.application_trello.*;
import com.example.application_trello.Controls.ControlDesarchivageColonne;
import com.example.application_trello.Objects.Tableau;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * classe TestControlDesarchivageColonne
 * test les differentes methodes de la classe ControlDesarchivageColonne
 * fait par Logan
 */
public class TestControlDesarchivageColonne {
    // Attributs
    private Tableau tableau;
    private ControlDesarchivageColonne controlDesarchivageColonne;

    @BeforeEach
    public void setUp(){
        // Initialisation des objets nécessaires pour les tests
        tableau = new Tableau("Test");
        controlDesarchivageColonne = new ControlDesarchivageColonne(tableau);
    }

    /**
     * test_01
     * test le constructeur de la classe ControlDesarchivageColonne
     */
    @Test
    public void test_01_constructeurControlDesarchivageColonne(){
        // Vérifier si le tableau est correctement initialisé
        assertEquals(tableau, controlDesarchivageColonne.getTab());
    }
}
