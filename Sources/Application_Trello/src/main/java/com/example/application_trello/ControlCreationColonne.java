package com.example.application_trello;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControlCreationColonne implements EventHandler<ActionEvent> {
    /*Controleur pour le bouton + sur la colonne de droite servant à créer une nouvelle colonne.
    *Ouvre une fenêtre de dialogue temporaire pour que l'utilisateur rentre le nom de la colonne puis appelle
    * le modèle pour créer une nouvelle colonne.
    * Classe écrite par Titouan
     */
    private Tableau tab;

    public ControlCreationColonne(Tableau t){
        this.tab = t;
    }

    /**
     * getter du tableau
     * @return
     */
    public Tableau getTab() {
        return tab;
    }

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
