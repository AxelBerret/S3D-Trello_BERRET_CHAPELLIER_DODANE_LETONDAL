package com.example.application_trello;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControlBoutonsModifTache implements EventHandler<ActionEvent> {
    /*Explication de l'architecture MVC : L'architecture MVC mise en place ici se décompose en plusieurs parties.
     * Premièrement, dans la classe main principale, on créée un nouveau modèle, auquel on va associer des vues, auxquelles on va associer un controleur éventuellement.
     * le principe est que chaque vue affiche queleque chose par défaut, et lorsque l'utilisateur agit sur l'application,
     * le controleur reçoit l'action, et déclenche la méthode appropriée définie dans le modèle. Ce dernier notifie tous les observateurs qui vont se
     * mettre à jour si nécessaire. */
    private Tableau tab;
    private ArrayList<String> listeNomTaches;

    public ControlBoutonsModifTache(Tableau t){
        this.tab = t;
        this.majListeNomTaches();
    }

    public void handle(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            Button targetButton = (Button) event.getTarget();//Si l'event vient d'un boutton
            if (targetButton.getId().startsWith("addDependButton")) {//Si c'est un bouton d'ajout de dépendance
                String nomTache = extraireNomTacheID(targetButton.getId());//On récupère le nom de la tache
                if (this.listeNomTaches.contains(nomTache)) {//Si la tache existe dans notre tableau
                    VueTache vt = this.tab.getVueTache();
                    String dep = vt.getDependanceSelectionnee();//On récupère le nom de la dépendance à ajouter à cette tâche
                    // On ajoute la dépendance a la tâche
                    this.tab.ajouterDependance(nomTache, dep);
                }
            } else if (targetButton.getId().startsWith("addSousTacheButton")) {//Sinon si c'est un bouton d'ajout de sous-tâche
                String nomTache = extraireNomTacheID(targetButton.getId());//On récupère le nom de la tache
                if (this.listeNomTaches.contains(nomTache)) {//Si la tache existe dans notre tableau
                    VueTache vt = this.tab.getVueTache();
                    String st = vt.getSousTacheSelectionnee();//On récupère le nom de la sous-tâche à ajouter à cette tâche
                    // On ajoute la st a la tâche
                    this.tab.ajouterSousTache(nomTache, st);
                }
            }
        }
    }

    public void majListeNomTaches(){
        ArrayList<Tache> lt = this.tab.getListeTaches();
        this.listeNomTaches = new ArrayList<>();
        for (Tache t : lt){
            this.listeNomTaches.add(t.getNomTache());
        }
    }

    public String extraireNomTacheID(String idBouton) {//Méthode pour récupérer la tache dans laquelle ajouter la dépendance/sous-tâche
        if (idBouton != null && idBouton.startsWith("addDependButton")) {
            return idBouton.substring("addDependButton".length());
        }else if (idBouton != null && idBouton.startsWith("addSousTacheButton")){
            return idBouton.substring("addSousTacheButton".length());
        }
        return null;
    }

}
