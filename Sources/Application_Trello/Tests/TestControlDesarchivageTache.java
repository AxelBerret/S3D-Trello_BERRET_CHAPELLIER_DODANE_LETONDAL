import com.example.application_trello.*;
import com.example.application_trello.Controls.ControlDesarchivageTache;
import com.example.application_trello.Objects.Tableau;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * classe TestControlDesarchivageTache
 * test les differentes methodes de la classe ControlDesarchivageTache
 * fait par Logan
*/
public class TestControlDesarchivageTache {
    // Attributs
    private Tableau tableau;
    private String nomTache;
    private String nomCol;
    private ControlDesarchivageTache controlDesarchivageTache;

    @BeforeEach
    public void setUp(){
        // Initialisation des objets nécessaires pour les tests
        tableau = new Tableau("Test");
        controlDesarchivageTache = new ControlDesarchivageTache(tableau, nomTache, nomCol);
    }

    /**
     * test_01
     * test le constructeur de la classe ControlDesarchivageTache
     */
    @Test
    public void test_01_constructeurControlDesarchivageTache(){
        // Vérifier si le tableau est correctement initialisé
        assertEquals(tableau, controlDesarchivageTache.getTab());
    }
}
