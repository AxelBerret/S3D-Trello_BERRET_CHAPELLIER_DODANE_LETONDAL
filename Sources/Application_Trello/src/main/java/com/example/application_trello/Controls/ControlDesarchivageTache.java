package com.example.application_trello.Controls;

import com.example.application_trello.Objects.Tableau;
import com.example.application_trello.Objects.Tache;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControlDesarchivageTache implements EventHandler<ActionEvent> {

    private Tableau tab;
    private String nomCol;
    private String nomTache;

    public ControlDesarchivageTache(Tableau t, String nomTache, String nomCol) {
        this.tab = t;
        this.nomCol = nomCol;
        this.nomTache = nomTache;
    }

    /**
     * getter du tableau
     * @return
     */
    public Tableau getTab() {
        return tab;
    }

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
                    tab.desarchiverTache(tacheDesarchivee.getNomTache());
                }
            }
        }
    }
}
