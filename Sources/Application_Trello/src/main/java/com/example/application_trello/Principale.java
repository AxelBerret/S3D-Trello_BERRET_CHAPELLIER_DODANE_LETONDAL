package com.example.application_trello;

import com.example.application_trello.Objects.Colonne;
import com.example.application_trello.Objects.Sujet;
import com.example.application_trello.Objects.Tableau;
import com.example.application_trello.Views.VueBureau;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Principale extends Application {

    @Override
    public void start(Stage stage) {

        Sujet t = new Tableau("Test");

        VueBureau vb = new VueBureau(t);
        t.enregistrerObservateur(vb);

        Scene scene = new Scene(vb, 1200, 600);

        stage.setTitle("TRELLO");
        stage.setScene(scene);
        stage.show();
        ArrayList<Colonne> a = new ArrayList<>();
        a = ((Tableau) t).getListeColonnes();
        t.notifierObservateurs();
    }

    public static void main(String[] args) {launch();}
}
