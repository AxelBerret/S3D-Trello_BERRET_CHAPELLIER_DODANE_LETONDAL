package com.example.application_trello.Controls;

import com.example.application_trello.Objects.Tableau;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Contrôleur pour la suppression d'une tâche dans un tableau.
 * CLasse co écrite par Titouan, Sacha et Logan
 */
public class ControlSuppressionTache implements EventHandler<ActionEvent> {

    /**
     * attribut tab de la classe ControlSuppressionTache
     * represente le modele que l on va utiliser
     */
    private Tableau tab;

    /**
     * attribut nomCol de la classe ControlSuppressionTache
     * represente le nom de la colonne dans laquelle se trouve la tache que l on va supprimer
     */
    private String nomCol;

    /**
     * attribut nomTache de la classe ControlSuppressionTache
     * represente le nom de la tache que l on va supprimer
     */
    private String nomTache;


    /**
     * constructeur qui cree des objets de types ControlSuprressionTache
     * a partir des donnees passees en parametres
     * @param t le tableau que l on souhaite utiliser en tant que modele
     */
    public ControlSuppressionTache(Tableau t, String nomCol, String nomTache) {
        this.tab = t;
        this.nomCol = nomCol;
        this.nomTache = nomTache;
    }


    /**
     * methode handle de la classe ControlSuppressionTache
     * @param event
     */
    public void handle(ActionEvent event) {
        // Vérifie si la source de l'événement est un bouton
        Button targetButton = (Button) event.getTarget();//Si l'event vient d'un boutton
        // Vérifie si l'evenement est bien un bouton de suppression de tâche
            // Suppression de la tâche dans le tableau
            tab.supprimerTache(this.nomTache, this.nomCol);

    }

    /**
     * methode getTab de la classe ControlSuppressionTache
     * @return le tableau
     */
    public Tableau getTab() {
        return tab;
    }

    /**
     * methode getNomCol de la classe ControlSuppressionTache
     * @return le nom de la colonne dans laquelle se trouve la tache que l on va supprimer
     */
    public String getNomCol() {
        return nomCol;
    }

    /**
     * methode getNomTache de la classe ControlSuppressionTache
     * @return le nom de la tache que l on souhaite supprimer
     */
    public String getNomTache() {
        return nomTache;
    }
}
