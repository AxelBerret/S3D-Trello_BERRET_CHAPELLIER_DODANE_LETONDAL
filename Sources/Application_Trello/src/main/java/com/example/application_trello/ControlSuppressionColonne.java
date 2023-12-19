package com.example.application_trello;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControlSuppressionColonne implements EventHandler<ActionEvent> {

    private Tableau tab;

    public ControlSuppressionColonne(Tableau t) {
        this.tab = t;
    }

    public void handle(ActionEvent event) {
        if (event.getSource() instanceof Button sourceButton) {
            if (sourceButton.getId().startsWith("btnSupprimerColonne")) {
                String nomColonne = extraireNomColonneDeID(sourceButton.getId());
                for (Colonne c : tab.getColonnes()) {
                    if (c.getNomColonne().equals(nomColonne)) {
                        tab.supprimerColonne(c);
                        break;
                    }
                }

                tab.notifierObservateurs();
            }
        }
    }

    private String extraireNomColonneDeID(String idBouton) {
        if (idBouton != null && idBouton.startsWith("btnSupprimerColonne")) {
            return idBouton.substring("btnSupprimerColonne".length());
        }
        return null;
    }
}
