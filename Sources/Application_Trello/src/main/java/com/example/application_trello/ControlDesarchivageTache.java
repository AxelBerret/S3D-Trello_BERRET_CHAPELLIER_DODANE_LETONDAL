package com.example.application_trello;

import java.awt.event.ActionEvent;
import javafx.scene.control.Button;

public class ControlDesarchivageTache {

    /**
     * attribut tab de la classe ControlDesarchivageTache
     * represente le modele que l on modifiera
     */
    private Tableau tab;


    /**
     * constructeur qui cree des objets de types ControlDesarchivageTache
     * a partir des donnees passees en parametres
     * @param t tableau que l on souhaite utiliser en modele
     */
    public ControlDesarchivageTache(Tableau t) {this.tab = t;}


    /**
     * methode handle de la classe ControlDesarchivageTache
     * qui permet la gestion du desarchivage des taches
     * @param event evenement representant le bouton clickable
     */
    public void handle(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            Button sourceButton = (Button) event.getSource();
            if ("boutonDesarchivageTache".equals(sourceButton.getId())) {

            }
        }
    }
}
