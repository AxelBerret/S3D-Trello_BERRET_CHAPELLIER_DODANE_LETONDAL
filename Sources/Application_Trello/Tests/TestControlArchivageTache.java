import com.example.application_trello.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestControlArchivageTache{
    // Attributs
    private Tableau tableau;
    private ControlArchivageTache controlArchivageTache;

    @BeforeEach
    public void setUp(){
        // Initialisation des objets nécessaires pour les tests
        tableau = new Tableau("Test");
        controlArchivageTache = new ControlArchivageTache(tableau);
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
