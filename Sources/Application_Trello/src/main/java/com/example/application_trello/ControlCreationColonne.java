package com.example.application_trello;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControlCreationColonne implements EventHandler<ActionEvent> {
    /*Explication de l'architecture MVC : L'architecture MVC mise en place ici se décompose en plusieurs parties.
     * Premièrement, dans la classe main principale, on créée un nouveau modèle, auquel on va associer des vues, auxquelles on va associer un controleur éventuellement.
     * le principe est que chaque vue affiche queleque chose par défaut, et lorsque l'utilisateur agit sur l'application,
     * le controleur reçoit l'action, et déclenche la méthode appropriée définie dans le modèle. Ce dernier notifie tous les observateurs qui vont se
     * mettre à jour si nécessaire. */
    private Tableau tab;

    public ControlCreationColonne(Tableau t){
        this.tab = t;
    }

    public void handle(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            Button sourceButton = (Button) event.getSource();//Si l'event vient d'un boutton
            if (sourceButton.getId().startsWith("btnCreerColonne")) {//Si c'est un bouton de création de colonne
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
