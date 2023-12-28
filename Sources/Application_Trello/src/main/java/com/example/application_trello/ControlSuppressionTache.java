package com.example.application_trello;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Contrôleur pour la suppression d'une tâche dans un tableau.
 */
public class ControlSuppressionTache implements EventHandler<ActionEvent> {

    private Tableau tab;

    /**
     * Constructeur du contrôleur.
     *
     * @param t Le tableau associé au contrôleur.
     */
    public ControlSuppressionTache(Tableau t) {
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
            // Vérifie si l'evenement est bien un bouton de suppression de tâche
            if (sourceButton.getId().startsWith("btnSupprimerTache")) {
                // Extraction du nom de la colonne et de la tâche
                String nomColonne = extraireNomColonneDeID(sourceButton.getId());
                String nomTache = extraireNomTacheDeID(sourceButton.getId());
                // Suppression de la tâche dans le tableau
                tab.supprimerTache(nomTache, nomColonne);
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
    public String extraireNomColonneDeID(String idBouton) {
        if (idBouton != null && idBouton.startsWith("btnSupprimerTache")) {
            return idBouton.substring("btnSupprimerTache".length());
        }
        return null;
    }

    /**
     * Extrait le nom de la tâche à partir de l'ID du bouton.
     *
     * @param idBouton L'ID du bouton.
     * @return Le nom de la tâche extrait.
     */
    public String extraireNomTacheDeID(String idBouton) {
        if (idBouton != null && idBouton.startsWith("btnSupprimerTache")) {
            return idBouton.substring("btnSupprimerTache".length());
        }
        return null;
    }
}
