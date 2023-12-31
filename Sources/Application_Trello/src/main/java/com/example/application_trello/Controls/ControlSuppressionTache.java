package com.example.application_trello.Controls;

import com.example.application_trello.Objects.Tableau;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Contrôleur pour la suppression d'une tâche dans un tableau.
 * CLasse co écrite par Titouan et Sacha
 */
public class ControlSuppressionTache implements EventHandler<ActionEvent> {

    private Tableau tab;
    private String nomCol;
    private String nomTache;

    /**
     * Constructeur du contrôleur.
     *
     * @param t Le tableau associé au contrôleur.
     */
    public ControlSuppressionTache(Tableau t, String nomCol, String nomTache) {
        this.tab = t;
        this.nomCol = nomCol;
        this.nomTache = nomTache;
    }

    /**
     * Méthode appelée lorsqu'un événement (clic sur un bouton) se produit.
     *
     * @param event L'événement déclenché.
     */
    public void handle(ActionEvent event) {
        // Vérifie si la source de l'événement est un bouton
        Button targetButton = (Button) event.getTarget();//Si l'event vient d'un boutton
        // Vérifie si l'evenement est bien un bouton de suppression de tâche
            // Suppression de la tâche dans le tableau
            tab.supprimerTache(this.nomTache, this.nomCol);

    }

    /**
     * getter du tableau
     * @return
     */
    public Tableau getTab() {
        return tab;
    }

    /**
     * getter du nom de la colonne
     * @return
     */
    public String getNomCol() {
        return nomCol;
    }

    /**
     * getter du nom de la tache
     * @return
     */
    public String getNomTache() {
        return nomTache;
    }
}
