package com.example.application_trello;

import java.awt.event.ActionEvent;
import javafx.scene.control.Button;

public class ControlArchivageColonne {

    /**
     * attribut tab de la classe ControlArchivageColonne
     * represente le modele que l on modifiera
     */
    private Tableau tab;


    /**
     * constructeur qui cree des objets de types ControlArchivageColonne
     * a partir des donnees passees en parametres
     * @param t tableau que l on souhaite utiliser en modele
     */
    public ControlArchivageColonne(Tableau t) {this.tab = t;}


    /**
     * methode handle de la classe ControlArchivageColonne
     * qui permet la gestion du bouton d archivage des colonnes
     * @param event evenement representant le bouton clickable
     */
    public void handle(ActionEvent event) {}
}
