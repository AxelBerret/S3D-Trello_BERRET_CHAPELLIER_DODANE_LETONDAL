package com.example.application_trello;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Contrôleur pour la suppression d'une colonne dans un tableau.
 */
public class ControlSuppressionColonne implements EventHandler<ActionEvent> {

    private Tableau tab;

    /**
     * Constructeur du contrôleur.
     *
     * @param t Le tableau associé au contrôleur.
     */
    public ControlSuppressionColonne(Tableau t) {
        this.tab = t;
    }

    /**
     * Méthode appelée lorsqu'un événement (clic sur un bouton) se produit.
     *
     * @param event L'événement déclenché.
     */
    public void handle(ActionEvent event) {
        // Vérifie si la source de l'événement est un bouton
        if (event.getSource() instanceof Button sourceButton) {
            // Vérifie si le bouton est destiné à la suppression de colonne
            if (sourceButton.getId().startsWith("btnSupprimerColonne")) {
                // Extraction du nom de la colonne
                String nomColonne = extraireNomColonneDeID(sourceButton.getId());
                // Parcourt toutes les colonnes du tableau
                for (Colonne c : tab.getListeColonnes()) {
                    // Si la colonne correspond au nom extrait, la supprime et sort de la boucle
                    if (c.getNomColonne().equals(nomColonne)) {
                        tab.supprimerColonne(c);
                        break;
                    }
                }

                // Notification de l'observateur
                tab.notifierObservateurs();
            }
        }
    }

    /**
     * Extrait le nom de la colonne à partir de l'ID du bouton.
     *
     * @param idBouton L'ID du bouton.
     * @return Le nom de la colonne extrait.
     */
    private String extraireNomColonneDeID(String idBouton) {
        if (idBouton != null && idBouton.startsWith("btnSupprimerColonne")) {
            return idBouton.substring("btnSupprimerColonne".length());
        }
        return null;
    }
}
