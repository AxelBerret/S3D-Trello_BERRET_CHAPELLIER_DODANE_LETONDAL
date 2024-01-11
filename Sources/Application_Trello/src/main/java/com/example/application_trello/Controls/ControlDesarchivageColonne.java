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

    /**
     * attribut tab de la classe ControlDesarchivageColonne
     * represente le modele que l on va utiliser
     */
    private Tableau tab;

    /**
     * attribut nomCol de la classe ControlDesarchivageColonne
     * represente le nom de la colonne que l on va manipuler
     */
    private String nomCol;


    /**
     * constructeur qui cree des objets de types ControlDesarchivageColonne
     * a partir des donnees passees en parametres
     * @param t tableau que l on souhaite utiliser en tant que modele
     * @param nomCol nom de la colonne que l on va manipuler
     */
    public ControlDesarchivageColonne(Tableau t, String nomCol) {
        this.tab = t;
        this.nomCol = nomCol;

    }

    /**
     * methode getTab de la classe ControlDesarchivageColonne
     * @return le tableau
     */
    public Tableau getTab() {
        return tab;
    }

    /**
     * methode handle de la classe ControlDesarchivageColonne
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
