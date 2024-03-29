import com.example.application_trello.*;
import com.example.application_trello.Objects.Archive;
import com.example.application_trello.Objects.Colonne;
import com.example.application_trello.Objects.Tache;
import com.example.application_trello.Objects.TacheSimple;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * classe TestArchive
 * test les differentes methodes de la classe Archive
 * fait par Logan
 */
public class TestArchive {

    /**
     * test_01
     * test le constructeur de la classe Archive
     */
    @Test
    public void test_01_ConstructeurArchive() {
        Archive archive = new Archive();
        assertEquals(archive.getListeTachesArchivees(),new ArrayList<>());
        assertEquals(archive.getListeColonnesArchivees(),new ArrayList<>());
    }

    /**
     * test_02
     * test la methode archiverTache de la classe Archive
     */
    @Test
    public void test_02_ArchiverTache() {
        Archive archive = new Archive();
        TacheSimple tacheS = new TacheSimple("tache1");
        archive.archiverTache(tacheS);
        assertEquals(1, archive.getListeTachesArchivees().size());
        assertEquals(archive.getListeTachesArchivees().get(0), tacheS);
    }

    /**
     * test_03
     * test la methode archiverColonne de la classe Archive
     */
    @Test
    public void test_03_ArchiverColonne(){
        Archive archive = new Archive();
        Colonne c1 = new Colonne("colonne1");
        archive.archiverColonne(c1);
        assertEquals(1, archive.getListeColonnesArchivees().size());
        assertEquals(archive.getListeColonnesArchivees().get(0), c1);
    }

    /**
     * test_04
     * test la methode desarchiverTache de la classe Archive
     */
    @Test
    public void test_04_DesarchiverTache(){
        Archive archive = new Archive();
        Tache t1 = new TacheSimple("tache1");
        Tache t2 = new TacheSimple("tache2");
        archive.archiverTache(t1);
        archive.archiverTache(t2);
        archive.desarchiverTache(t1);
        assertEquals(1, archive.getListeTachesArchivees().size());
        assertEquals("tache2", archive.getListeTachesArchivees().get(0).getNomTache());
    }

/**
     * test_05
     * test la methode desarchiverColonne de la classe Archive
     */
    @Test
    public void test_05_DesarchiverColonne(){
        Archive archive = new Archive();
        Colonne c1 = new Colonne("colonne1");
        Colonne c2 = new Colonne("colonne2");
        archive.archiverColonne(c1);
        archive.archiverColonne(c2);
        archive.desarchiverColonne(c1);
        assertEquals(1, archive.getListeColonnesArchivees().size());
        assertEquals("colonne2", archive.getListeColonnesArchivees().get(0).getNomColonne());
    }
}
