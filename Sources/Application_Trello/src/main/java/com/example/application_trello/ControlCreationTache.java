package com.example.application_trello;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class ControlCreationTache implements EventHandler<ActionEvent> {
    /*Explication de l'architecture MVC : L'architecture MVC mise en place ici se décompose en plusieurs parties.
     * Premièrement, dans la classe main principale, on créée un nouveau modèle, auquel on va associer des vues, auxquelles on va associer un controleur éventuellement.
     * le principe est que chaque vue affiche queleque chose par défaut, et lorsque l'utilisateur agit sur l'application,
     * le controleur reçoit l'action, et déclenche la méthode appropriée définie dans le modèle. Ce dernier notifie tous les observateurs qui vont se
     * mettre à jour si nécessaire. */
    private Tableau tab;

    public ControlCreationTache(Tableau t){
        this.tab = t;
    }

    public void handle(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            Button sourceButton = (Button) event.getSource();//Si l'event vient d'un boutton
            if ("boutonCreationTache".equals(sourceButton.getId())) {//Il faut faire un système d'ID de colonne pour savoir de quelle colonne provient le bouton. A faire dans ControlCreationColonne
                // Ouvrir une boîte de dialogue pour saisir le texte de la tâche
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Création de Tâche");
                dialog.setHeaderText("Entrer le texte de la tâche :");
                dialog.setContentText("Texte :");
                // Attendre que l'utilisateur entre le texte
                dialog.showAndWait().ifPresent(texteTache -> {
                    // Créer une nouvelle tâche avec le texte et l'ajouter au modèle
                    tab.ajouterTache(texteTache);
                });
            }
        }
    }

}
