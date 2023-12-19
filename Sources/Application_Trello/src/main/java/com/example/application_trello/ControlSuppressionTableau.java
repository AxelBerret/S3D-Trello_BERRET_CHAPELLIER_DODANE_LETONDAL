package com.example.application_trello;

import javafx.scene.control.*;
import javafx.scene.control.Alert.*;

import java.awt.event.ActionEvent;
import java.util.Optional;

public class ControlSuppressionTableau {

    /**
     * attribut tab de la classe ControlSuppressionTableau
     * represente le controleur du bouton de creation de tableau
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
     * qui permet la gestion du bouton de creation de tableau
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
                    // Supprimer le tableau de la liste
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
        if (idBouton != null && idBouton.startsWith("btnSupprimerTableau")) {
            return idBouton.substring("btnSupprimerTableau".length());
        }
        return null;
    }
}
