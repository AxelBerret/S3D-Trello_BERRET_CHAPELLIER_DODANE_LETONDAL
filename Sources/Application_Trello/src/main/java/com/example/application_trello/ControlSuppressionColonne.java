package com.example.application_trello;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Contrôleur pour la suppression d'une colonne dans un tableau.
 * Classe écrite par Titouan
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
        if (event.getTarget() instanceof Button sourceButton) {//Si l'event vient d'un bouton
                // Extraction du nom de la colonne
                String nomColonne = extraireNomColonneDeID(sourceButton.getId());//On récupère le nom de la colonne
                // Parcourt toutes les colonnes du tableau
                for (Colonne c : tab.getListeColonnes()) {
                    // Si la colonne correspond au nom extrait, la supprime et sort de la boucle
                    if (c.getNomColonne().equals(nomColonne)) {

                        tab.supprimerColonne(c);

                        break;
                    }
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
