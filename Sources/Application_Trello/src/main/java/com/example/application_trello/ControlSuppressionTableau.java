package com.example.application_trello;

import javafx.scene.control.*;
import javafx.scene.control.Alert.*;

import javafx.event.ActionEvent;
import java.util.Optional;

public class ControlSuppressionTableau {

    /**
     * attribut tab de la classe ControlSuppressionTableau
     * represente le modele que l on modifiera
     */
    private ListeTableaux listeTab;


    /**
     * constructeur qui cree des objets de types ControlSuppressionTableau
     * a partir des donnees passees en parametres
     * @param lt liste de tableaux que l on souhaite utiliser en modele
     */
    public ControlSuppressionTableau(ListeTableaux lt) {this.listeTab = lt;}


    /**
     * methode handle de la classe ControlSuppressionTableau
     * qui permet la gestion du bouton de suppression de tableau
     * @param event evenement representant le bouton clickable
     */
    public void handle(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            Button sourceButton = (Button) event.getSource();
            if ("boutonSuppressionTableau".equals(sourceButton.getId())) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de suppression");
                alert.setHeaderText("Supprimer le tableau");
                alert.setContentText("Êtes-vous sûr de vouloir supprimer ce tableau?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    String nomTab = this.extraireNomTableauDeID(sourceButton.getId());
                    this.listeTab.supprimerTableau(this.listeTab.getTableau(nomTab));
                }
            }
        }
    }

    /**
     *
     * @param idBouton
     * @return
     */
    private String extraireNomTableauDeID(String idBouton) {
        if (idBouton != null && idBouton.startsWith("boutonSupprimerTableau")) {
            return idBouton.substring("boutonSupprimerTableau".length());
        }
        return null;
    }
}
