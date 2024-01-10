package com.example.application_trello.Controls;

import com.example.application_trello.Objects.Colonne;
import com.example.application_trello.Objects.Tableau;
import com.example.application_trello.Objects.Tache;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
//Controleur DesarchivageTache : Controleur qui va permettre de désarchiver une tache en lien avec le nouton désarchiver de la vueArchive
//Classe écrite par Sacha
public class ControlDesarchivageColonne implements EventHandler<ActionEvent> {

    private Tableau tab;
    private String nomCol;

    public ControlDesarchivageColonne(Tableau t, String nomCol) {
        this.tab = t;
        this.nomCol = nomCol;

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
                Colonne ColonneDesarchivee = null;
                for (Colonne colonne : tab.getArchive().getListeColonnesArchivees()) {
                    if (colonne.getNomColonne().equals(tacheNom)) {
                        ColonneDesarchivee = colonne;
                        break;
                    }
                }

                // Utiliser la tâche trouvée pour désarchiver
                if (ColonneDesarchivee != null) {

                    tab.desarchiverColonne(ColonneDesarchivee.getNomColonne());
                }
            }
        }
    }
}
