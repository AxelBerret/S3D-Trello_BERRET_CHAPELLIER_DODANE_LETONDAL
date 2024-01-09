package com.example.application_trello;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControlBoutonsModifTache implements EventHandler<ActionEvent> {
    /*Classe représentant le controleurs des boutons dans la fenêtre de modification des tâches.
    *Le controleur agit sur les boutons pour ajouter ou bien des dépendances ou bien des sous-tâches sur la tâche qu'on est en train de modifier.
    * Classe écrite par Titouan
     */
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
