package com.example.application_trello.Controls;

import com.example.application_trello.Objects.Tableau;
import com.example.application_trello.Objects.Tache;
import com.example.application_trello.Views.VueTache;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
//Controleur qui en principe va, lorsqu'on clique sur une tâche quelconque, ouvrir une fenêtre affichant plus de détails
//Et qui va permettre de consulter les sous-tâches et les dépendances, et d'en ajouter ou d'en supprimer.
//Classe écrite par Titouan
public class ControlModificationTache implements EventHandler<ActionEvent> {
    private Tableau tab;
    private Tache tache;

    public ControlModificationTache(Tableau t, Tache tt){
        this.tab = t;
        this.tache = tt;
    }

    public void handle(ActionEvent event) {
        Stage stageModification = new Stage();
        stageModification.setTitle(tache.getNomTache());

        VueTache vueModificationTache = new VueTache(this.tache, this.tab);
        vueModificationTache.actualiser(this.tab);
        this.tab.enregistrerObservateur(vueModificationTache);

        Scene sceneModification = new Scene(vueModificationTache, 600, 400);

        stageModification.setScene(sceneModification);
        stageModification.showAndWait();
    }

}