import com.example.application_trello.*;
import com.example.application_trello.Controls.ControlArchivageTache;
import com.example.application_trello.Objects.Tableau;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * classe TestControlArchivageTache
 * test les differentes methodes de la classe ControlArchivageTache
 * fait par Logan
 */
public class TestControlArchivageTache{
    // Attributs
    private Tableau tableau;
    private String nomTache;
    private String nomCol;
    private ControlArchivageTache controlArchivageTache;

    @BeforeEach
    public void setUp(){
        // Initialisation des objets nécessaires pour les tests
        tableau = new Tableau("Test");
        controlArchivageTache = new ControlArchivageTache(tableau, nomTache, nomCol);
    }

    /**
     * test_01
     * test le constructeur de la classe ControlArchivageTache
     */
    @Test
    public void test_01_constructeurControlArchivageTache(){
        // Vérifier si le tableau est correctement initialisé
        assertEquals(tableau, controlArchivageTache.getTab());
    }

    /**
     * test_02
     * test la methode ExtraireNomColonneDeID de la classe ControlArchivageTache
     */
    @Test
    public void test_02_ExtraireNomTacheDeID() {
        // Appeler la méthode extraireNomTacheDeID avec un ID de bouton
        String nomTache = controlArchivageTache.extraireNomTacheDeID("boutonSupprimerTableauTest");

        // Vérifier si le nom de la tâche extrait est correct
        assertEquals("Test", nomTache);
    }

}
