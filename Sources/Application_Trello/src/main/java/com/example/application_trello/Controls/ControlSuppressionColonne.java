package com.example.application_trello.Controls;

import com.example.application_trello.Objects.Colonne;
import com.example.application_trello.Objects.Tableau;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Contrôleur pour la suppression d'une colonne dans un tableau.
 * Classe écrite par Titouan et Logan
 */
public class ControlSuppressionColonne implements EventHandler<ActionEvent> {

    /**
     * attribut tab de la classe ControlSuppressionColonne
     * represente le modele que l on va utiliser
     */
    private Tableau tab;


    /**
     * constructeur qui cree des objets de types ControlSuppressionColonne
     * a partir des donnees passees en parametres
     * @param t tableau que l on va utiliser en tant que modele
     */
    public ControlSuppressionColonne(Tableau t) {
        this.tab = t;
    }


    /**
     * methode handle de la classe ControlSuppressionColonne
     * @param event
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
     * methode getTab de la classe ControlSuppressionColonne
     * @return le tableau
     */
    public Tableau getTab() {
        return tab;
    }

    /**
     * methode extraireNomColonneDeID de la classe ControlSuppressionColonne
     * @param idBouton identifiant du bouton que l on souhaite verifier
     * @return le nom de la colonne
     */
    public String extraireNomColonneDeID(String idBouton) {
        if (idBouton != null && idBouton.startsWith("btnSupprimerColonne")) {
            return idBouton.substring("btnSupprimerColonne".length());
        }
        return null;
    }
}
