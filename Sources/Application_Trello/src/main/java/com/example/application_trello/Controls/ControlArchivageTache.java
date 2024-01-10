package com.example.application_trello.Controls;

import java.util.Optional;

import com.example.application_trello.Objects.Tableau;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
//Controleur sarchivageTache : Controleur qui va permettre d'archiver une tache en lien avec le bouton sur les taches
//Classe écrite par Sacha
public class ControlArchivageTache implements EventHandler<ActionEvent> {

    /**
     * attribut tab de la classe ControlArchivageTache
     * represente le modele que l on modifiera
     */
    private Tableau tab;
    private String nomCol;
    private String nomTache;
    public ControlArchivageTache(Tableau t, String nomTache, String nomCol) {
        this.tab = t;
        this.nomCol = nomCol;
        this.nomTache = nomTache;
    }


    /**
     * constructeur qui cree des objets de types ControlArchivageTache
     * a partir des donnees passees en parametres
     * @param t tableau que l on souhaite utiliser en modele
     */


    /**
     * methode handle de la classe ControlArchivageTache
     * qui permet la gestion du bouton d archivage des taches
     * @param event
     */
    public void handle(ActionEvent event) {
        if (event.getTarget() instanceof Button) {
            Button targetButton = (Button) event.getTarget();

            if (targetButton.getId().startsWith("boutonArchivageTache")){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de l archivage");
                alert.setHeaderText("Archiver la tache");
                alert.setContentText("Etes-vous sur de vouloir archiver cette tache?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    String nomTache = this.extraireNomTacheDeID(targetButton.getId());
                    this.tab.archiverTache(this.nomTache, this.nomCol);

                }
            }
        }
    }

    /**
     *
     * @param idBouton
     * @return
     */
    public String extraireNomTacheDeID(String idBouton) {
        if (idBouton != null && idBouton.startsWith("boutonSupprimerTableau")) {
            return idBouton.substring("boutonSupprimerTableau".length());
        }
        return null;
    }

    /**
     * getter du tableau
     * @return
     */
    public Tableau getTab() {
        return tab;
    }
}
