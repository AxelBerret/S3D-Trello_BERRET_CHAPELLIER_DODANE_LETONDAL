package com.example.application_trello;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControlCreationTache implements EventHandler<ActionEvent> {
    /*Explication de l'architecture MVC : L'architecture MVC mise en place ici se décompose en plusieurs parties.
     * Premièrement, dans la classe main principale, on créée un nouveau modèle, auquel on va associer des vues, auxquelles on va associer un controleur éventuellement.
     * le principe est que chaque vue affiche queleque chose par défaut, et lorsque l'utilisateur agit sur l'application,
     * le controleur reçoit l'action, et déclenche la méthode appropriée définie dans le modèle. Ce dernier notifie tous les observateurs qui vont se
     * mettre à jour si nécessaire. */
    private Tableau tab;
    private ArrayList<String> listeNomColonnes;

    public ControlCreationTache(Tableau t){
        this.tab = t;
        this.majListeNomColonnes();
    }

    public void handle(ActionEvent event) {
        this.majListeNomColonnes();
        if (event.getSource() instanceof Button) {
            Button targetButton = (Button) event.getTarget();//Si l'event vient d'un boutton
            if (targetButton.getId().startsWith("btnCreerTache")) {//Si c'est un bouton de création de tâche
                String nomColonne = extraireNomColonneDeID(targetButton.getId());//On récupère le nom de la colonne
                if (this.listeNomColonnes.contains(nomColonne)){//Si la colonne existe dans notre tableau
                    // On ouvre une fenetre de dialogue pour rentrer le nom de la tâche
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Création de Tâche");
                    dialog.setHeaderText("Entrer le texte de la tâche :");
                    dialog.setContentText("Texte :");
                    // Attendre que l'utilisateur entre le texte
                    dialog.showAndWait().ifPresent(texteTache -> {
                        // Créer une nouvelle tâche avec le texte et l'ajouter au modèle
                        tab.ajouterTache(texteTache, nomColonne);//On ajoute la tâche dans la colonne
                    });
                }
            }
        }
    }

    public void majListeNomColonnes(){
        ArrayList<Colonne> lc = this.tab.getColonnes();
        this.listeNomColonnes = new ArrayList<>();
        for (Colonne c : lc){
            this.listeNomColonnes.add(c.getNomColonne());
        }
    }

    public String extraireNomColonneDeID(String idBouton) {//Méthode pour récupérer la colonne dans laquelle ajouter la tâche
        if (idBouton != null && idBouton.startsWith("btnCreerTache")) {
            return idBouton.substring("btnCreerTache".length());
        }
        return null;
    }

    public ArrayList<String> getListeNomColonnes(){
        return this.listeNomColonnes;
    }

}
