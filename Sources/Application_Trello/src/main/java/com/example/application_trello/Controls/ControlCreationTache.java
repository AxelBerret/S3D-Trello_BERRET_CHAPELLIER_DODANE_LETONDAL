package com.example.application_trello.Controls;

import com.example.application_trello.Objects.Colonne;
import com.example.application_trello.Objects.Tableau;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;

import java.util.ArrayList;

public class ControlCreationTache implements EventHandler<ActionEvent> {
    /*  Controleur du bouton + servant à créer une tache. Son rôle est d'ouvrir une fenêtre de dialogue temporaire
    * afin que l'utilisateur rentre le nom de la tâche puis l'ajoute au modèle. Le contrôleur récupère le nom de la colonne de laquelle
    * provient le bouton + grâce à l'ID du bouton qui est de la forme suivante : "btnCreerTacheColonne1" ce qui explique l'utilisation de la méthode
    * "extraireNomDeColonne". C'est pour ajouter la tâche dans la bonne colonne.
    * Le contrôleur a été écrit par Titouan*/
    private Tableau tab;
    private ArrayList<String> listeNomColonnes;

    public ControlCreationTache(Tableau t){
        this.tab = t;
        this.majListeNomColonnes();
    }

    public void handle(ActionEvent event) {
        this.majListeNomColonnes();
        if (event.getTarget() instanceof Button) {//Si l'event vient d'un boutton
            Button targetButton = (Button) event.getTarget();// On récupère ce bouton
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

    public void majListeNomColonnes(){//Méthode pour créer une liste des noms de colonnes a partir de la liste des colonnes du tableau pour simplifier la méthode handle
        ArrayList<Colonne> lc = this.tab.getListeColonnes();
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
}
