package com.example.application_trello.Controls;

import com.example.application_trello.Objects.Tableau;
import com.example.application_trello.Objects.Tache;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
//Controleur DesarchivageTache : Controleur qui va permettre de désarchiver une tache en lien avec le nouton désarchiver de la vueArchive
//Classe écrite par Sacha
public class ControlDesarchivageTache implements EventHandler<ActionEvent> {

    /**
     * attribut tab de la classe ControlDesarchivageTache
     * represente le modele que l on va utiliser
     */
    private Tableau tab;

    /**
     * attribut nomCol de la classe ControlDesarchivgeTache
     * represente le nom de la colonne dans laquelle se trouve la tache que l on va desarchiver
     */
    private String nomCol;

    /**
     * attribut nomTache de la classe ControlDesarchivageTache
     * represente le nom de la tache que l on souhaite desarchiver
     */
    private String nomTache;


    /**
     * constructeur qui cree des objets de types ControlDesarchivageTache
     * @param t tableau que l on souhaite utiliser en tant que modele
     * @param nomTache nom de la tache que l on souhaite desarchiver
     * @param nomCol nom de la colonne dans laquelle se trouve la tache que l on va desarchiver
     */
    public ControlDesarchivageTache(Tableau t, String nomTache, String nomCol) {
        this.tab = t;
        this.nomCol = nomCol;
        this.nomTache = nomTache;
    }


    /**
     * methode getTab de la classe ControlDesarchivageTache
     * @return le tableau
     */
    public Tableau getTab() {
        return tab;
    }

    /**
     * methode handle de la classe ControlDesarchivageTache
     * @param event
     */
    public void handle(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            Button sourceButton = (Button) event.getSource();
            String buttonId = sourceButton.getId();

            // Vérifier si le bouton est un bouton de désarchivage
            if (buttonId != null && buttonId.startsWith("boutonDesarchiver")) {
                // Extraire le nom de la tâche à partir de l'ID du bouton
                String tacheNom = buttonId.replace("boutonDesarchiver", "");

                // Rechercher la tâche dans la liste des tâches archivées du tableau
                Tache tacheDesarchivee = null;
                for (Tache tache : tab.getListeTachesArchives()) {
                    if (tache.getNomTache().equals(tacheNom)) {
                        tacheDesarchivee = tache;
                        break;
                    }
                }

                // Utiliser la tâche trouvée pour désarchiver
                if (tacheDesarchivee != null) {
                    tab.desarchiverTache(tacheDesarchivee.getNomTache(),tacheDesarchivee.getColonneParent().getNomColonne());
                }
            }
        }
    }
}
