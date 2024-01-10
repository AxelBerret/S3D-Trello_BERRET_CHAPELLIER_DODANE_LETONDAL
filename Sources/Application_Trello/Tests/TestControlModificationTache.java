import com.example.application_trello.Controls.ControlDesarchivageTache;
import com.example.application_trello.Controls.ControlModificationTache;
import com.example.application_trello.Objects.Tableau;
import com.example.application_trello.Objects.Tache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestControlModificationTache {

    //Attributs
    private Tableau tableau;
    private Tache tache;
    private ControlModificationTache controlModificationTache;

    @BeforeEach
    public void setUp(){
        //Initialisation des objets nécessaires pour les tests
        tableau = new Tableau("Test");
        controlModificationTache = new ControlModificationTache(tableau, tache);
    }

    /**
     * test_01
     * test le constructeur de la classe ControlModificationTache
     */

    @Test
    public void test_01_constructeurControlModificationTache(){
        //Vérifier si le tableau est correctement initialisé
        assertEquals(tableau, controlModificationTache.getTab());
    }


}
