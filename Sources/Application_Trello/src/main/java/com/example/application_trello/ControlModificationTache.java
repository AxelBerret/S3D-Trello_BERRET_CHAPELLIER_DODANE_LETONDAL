package com.example.application_trello;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControlModificationTache implements EventHandler<ActionEvent> {
    private Tableau tab;
    private Tache tache;

    public ControlModificationTache(Tableau t, Tache tt){
        this.tab = t;
        this.tache = tt;
    }

    public void handle(ActionEvent event) {
        Stage stageModification = new Stage();

        VueTache vueModificationTache = new VueTache(this.tache, this.tab);

        Scene sceneModification = new Scene(vueModificationTache);

        stageModification.setScene(sceneModification);
        stageModification.showAndWait();
    }

}