import com.example.application_trello.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * classe TestControlSuppressionTache
 * test les differentes methodes de la classe ControlSuppressionTache
 * fait par Logan
 */
public class TestControlSuppressionTache {

    private Tableau tableau;
    private String colonne;
    private String tache;

    private ControlSuppressionTache controlSuppressionTache;

    @BeforeEach
    public void setUp(){
        // Initialisation des objets nécessaires pour les tests
        tableau = new Tableau("Test");
        controlSuppressionTache = new ControlSuppressionTache(tableau, colonne, tache);
    }

    /**
     * test_01
     * test le constructeur de la classe ControlSuppressionTache
     */
    @Test
    public void test_01_constructeurControlSuppressionTache(){
        // Vérifie si le contructeur est correctement initialisé
        assertEquals(tableau, controlSuppressionTache.getTab());
        assertEquals(colonne, controlSuppressionTache.getNomCol());
        assertEquals(tache, controlSuppressionTache.getNomTache());

    }
}
