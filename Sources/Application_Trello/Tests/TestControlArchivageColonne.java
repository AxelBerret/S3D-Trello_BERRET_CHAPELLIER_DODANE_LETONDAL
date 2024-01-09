import com.example.application_trello.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * classe TestControlArchivageColonne
 * test les differentes methodes de la classe ControlArchivageColonne
 * fait par Logan
 */
public class TestControlArchivageColonne {
    // Attributs
    public Tableau tableau;
    public ControlArchivageColonne controlArchivageColonne;

    @BeforeEach
    public void setUp(){
        // Initialisation des objets nécessaires pour les tests
        tableau = new Tableau("Test");
        controlArchivageColonne = new ControlArchivageColonne(tableau);
    }

    /**
     * test_01
     * test du constructeur de la classe ControlArchivageColonne
     */
    @Test
    public void test_01_constructeurControlArchivageColonne(){
        // Vérifie si le contructeur est correctement initialisé
        assertEquals(tableau, controlArchivageColonne.getTab());
    }
}
