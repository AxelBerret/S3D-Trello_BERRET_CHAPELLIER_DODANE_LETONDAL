package com.example.application_trello;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class ControlArchivageTache {

    /**
     * attribut tab de la classe ControlArchivageTache
     * represente le modele que l on modifiera
     */
    private Tableau tab;


    /**
     * constructeur qui cree des objets de types ControlArchivageTache
     * a partir des donnees passees en parametres
     * @param t tableau que l on souhaite utiliser en modele
     */
    public ControlArchivageTache(Tableau t) {this.tab = t;}


    /**
     * methode handle de la classe ControlArchivageTache
     * qui permet la gestion du bouton d archivage des taches
     * @param event
     */
    public void handle(ActionEvent event) {

    }
}
