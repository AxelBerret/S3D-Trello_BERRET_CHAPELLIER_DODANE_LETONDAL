package com.example.application_trello.Controls;

import com.example.application_trello.Objects.Colonne;
import com.example.application_trello.Objects.Tableau;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;

public class ControlCreationColonne implements EventHandler<ActionEvent> {

    /**
     * attribut tab de la classe ControlCreationColonne
     * represente le modele que l on va utiliser
     */
    private Tableau tab;


    /**
     * constructeur qui cree des objets de types ControlCreationColonne
     * a partir des donnees passees en parametres
     * @param t tableau que l on souhaite utiliser en tant que modele
     */
    public ControlCreationColonne(Tableau t){
        this.tab = t;
    }

    /**
     * methode getTab de la classe ControlCreationColonne
     * @return le tableau
     */
    public Tableau getTab() {
        return tab;
    }

    /**
     * methode handle de la classe controlCreationColonne
     * @param event
     */
    public void handle(ActionEvent event) {
        if (event.getTarget() instanceof Button) {//Si l'event vient d'un boutton
            Button targetButton = (Button) event.getTarget();//On récupère ce bouton
            if (targetButton.getId().startsWith("btnCreerColonne")) {//Si c'est un bouton de création de colonne
                    // On ouvre une fenetre de dialogue pour rentrer le nom de la colonne
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Création de colonne");
                    dialog.setHeaderText("Entrer le nom de la colonne :");
                    dialog.setContentText("Texte :");
                    // Attendre que l'utilisateur entre le texte
                    dialog.showAndWait().ifPresent(texteColonne -> {
                        // Créer une nouvelle colonne avec le nom et l'ajouter au modèle
                        Colonne c = new Colonne(texteColonne);
                        tab.ajouterColonne(c);//On ajoute la colonne dans le tableau
                    });
            }
        }
    }
}
