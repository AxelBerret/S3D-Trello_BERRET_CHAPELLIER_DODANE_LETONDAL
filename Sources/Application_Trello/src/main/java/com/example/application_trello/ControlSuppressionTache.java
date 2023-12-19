package com.example.application_trello;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControlSuppressionTache implements EventHandler<ActionEvent> {

    private Tableau tab;

    public ControlSuppressionTache(Tableau t) {
        this.tab = t;
    }

    public void handle(ActionEvent event) {
        if (event.getSource() instanceof Button sourceButton) {
            if (sourceButton.getId().startsWith("btnSupprimerTache")) {
                String nomColonne = extraireNomColonneDeID(sourceButton.getId());
                String nomTache = extraireNomTacheDeID(sourceButton.getId());
                tab.supprimerTache(nomTache, nomColonne);
            }
        }
    }

    private String extraireNomColonneDeID(String idBouton) {
        if (idBouton != null && idBouton.startsWith("btnSupprimerTache")) {
            return idBouton.substring("btnSupprimerTache".length());
        }
        return null;
    }

    private String extraireNomTacheDeID(String idBouton) {
        if (idBouton != null && idBouton.startsWith("btnSupprimerTache")) {
            return idBouton.substring("btnSupprimerTache".length());
        }
        return null;
    }
}
