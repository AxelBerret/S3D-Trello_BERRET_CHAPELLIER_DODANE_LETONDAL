package com.example.application_trello;

import java.awt.event.ActionEvent;
import javafx.scene.control.Button;

public class ControlDesarchivageColonne {

    /**
     * attribut tab de la classe ControlDesarchivageColonne
     * represente le modele que l on modifiera
     */
    private Tableau tab;


    /**
     * constructeur qui cree des objets de types ControlDesarchivageColonne
     * a partir des donnees passees en parametres
     * @param t tableau qu l on souhaite utiliser en modele
     */
    public ControlDesarchivageColonne(Tableau t) {this.tab = t;}


    /**
     * methode handle de la classe ControlDesarchivageColonne
     * qui permet la gestion du bouton de desarchivage des colonnes
     * @param event evenement representant le bouton clickable
     */
    public void handle(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            Button sourceButton = (Button) event.getSource();
            if ("boutonDesarchivageColonne".equals(sourceButton.getId())) {

            }
        }
    }
}
