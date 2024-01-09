package com.example.application_trello.Controls;

import com.example.application_trello.Objects.Tableau;
import javafx.event.ActionEvent;
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
     * getter du tableau
     * @return
     */
    public Tableau getTab() {
        return tab;
    }

    /**
     * methode handle de la classe ControlArchivageColonne
     * qui permet la gestion du bouton d archivage des colonnes
     * @param event evenement representant le bouton clickable
     */
    public void handle(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            Button sourceButton = (Button) event.getSource();
            if ("boutonArchivageColonne".equals(sourceButton.getId())) {

            }
        }
    }
}
