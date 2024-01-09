import org.junit.jupiter.api.Test;
import com.example.application_trello.Tache;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import com.example.application_trello.*;
import org.junit.jupiter.api.BeforeEach;

/**
 * classe TestControlCreationTache
 * test les differentes methodes de la classe ControlCreationTache
 * fait par Titouan
 */
public class TestControlCreationTache {

    // Attributs
    private ControlCreationTache controlCreationTache;
    private Tableau tableau;

    @BeforeEach
    void setUp() {
        // Initialisation des objets nécessaires pour les tests
        tableau = new Tableau("Test");
        controlCreationTache = new ControlCreationTache(tableau);
    }

    /**
     * test_01
     * test la methode MajListeNomColonnes de la classe ControlCreationTache
     */
    @Test
    void testMajListeNomColonnes() {
        // Ajouter des colonnes pour le test
        Colonne colonne1 = new Colonne("Colonne1");
        Colonne colonne2 = new Colonne("Colonne2");
        tableau.ajouterColonne(colonne1);
        tableau.ajouterColonne(colonne2);

        // Appeler la méthode majListeNomColonnes
        controlCreationTache.majListeNomColonnes();

        // Vérifier si la liste des noms de colonnes est correcte
        ArrayList<String> listeNomColonnes = controlCreationTache.getListeNomColonnes();
        assertEquals(2, listeNomColonnes.size());
        assertTrue(listeNomColonnes.contains("Colonne1"));
        assertTrue(listeNomColonnes.contains("Colonne2"));
    }

    /**
     * test_02
     * test la methode ExtraireNomColonneDeID de la classe ControlCreationTache
     */
    @Test
    void testExtraireNomColonneDeID() {
        // Appeler la méthode extraireNomColonneDeID avec un ID de bouton
        String nomColonne = controlCreationTache.extraireNomColonneDeID("btnCreerTacheColonne1");

        // Vérifier si le nom de colonne extrait est correct
        assertEquals("Colonne1", nomColonne);
    }
}