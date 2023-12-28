package com.example.application_trello;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControlModificationTache implements EventHandler<ActionEvent> {
    /*Explication de l'architecture MVC : L'architecture MVC mise en place ici se décompose en plusieurs parties.
     * Premièrement, dans la classe main principale, on créée un nouveau modèle, auquel on va associer des vues, auxquelles on va associer un controleur éventuellement.
     * le principe est que chaque vue affiche queleque chose par défaut, et lorsque l'utilisateur agit sur l'application,
     * le controleur reçoit l'action, et déclenche la méthode appropriée définie dans le modèle. Ce dernier notifie tous les observateurs qui vont se
     * mettre à jour si nécessaire. */
    private Tableau tab;
    private ArrayList<String> listeNomColonnes;
    private FenetreModification fenetreModification;

    public ControlModificationTache(Tableau t){
        this.tab = t;
        this.majListeNomColonnes();
        this.fenetreModification = new FenetreModification();
    }

    public void gererClicSurTache(Tache tache) {
        // Créez une nouvelle fenêtre de modification
        Stage stageModification = new Stage();

        // Créez la vue de modification de la tâche avec les détails de la tâche
        VueTache vueModificationTache = new VueTache(tache, this.tab);

        // Ajoutez la vue de modification à la scène
        Scene sceneModification = new Scene(vueModificationTache);

        // Configurez et montrez la nouvelle fenêtre
        stageModification.setScene(sceneModification);
        stageModification.showAndWait();

        // Récupérez les informations modifiées après la fermeture de la fenêtre
        String nouveauNom = vueModificationTache.getNouveauNom();
        // ... récupérer d'autres informations ...

        // Mettez à jour la tâche avec les informations modifiées
        tache.setNomTache(nouveauNom);
        // ... mettre à jour d'autres informations ...
    }

    private void openSecondWindow() {
        Stage secondStage = new Stage();

        Button closeButton = new Button("Close Second Window");
        closeButton.setOnAction(e -> secondStage.close());

        StackPane secondRoot = new StackPane();
        secondRoot.getChildren().add(closeButton);

        Scene secondScene = new Scene(secondRoot, 200, 100);

        secondStage.setTitle("Second Window");
        secondStage.setScene(secondScene);
        secondStage.show();
    }

    public void majListeNomColonnes(){
        ArrayList<Colonne> lc = this.tab.getColonnes();
        this.listeNomColonnes = new ArrayList<>();
        for (Colonne c : lc){
            this.listeNomColonnes.add(c.getNomColonne());
        }
    }

    private String extraireNomColonneDeID(String idBouton) {//Méthode pour récupérer la colonne dans laquelle ajouter la tâche
        if (idBouton != null && idBouton.startsWith("btnCreerTache")) {
            return idBouton.substring("btnCreerTache".length());
        }
        return null;
    }

}