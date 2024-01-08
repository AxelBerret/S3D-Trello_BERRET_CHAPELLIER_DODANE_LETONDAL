package com.example.application_trello;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Principale extends Application {

    @Override
    public void start(Stage stage) {

        Sujet t = new Tableau("Test");
        NewVueBureau vb = new NewVueBureau(t);
        t.enregistrerObservateur(vb);
        t.notifierObservateurs();

        Scene scene = new Scene(vb, 1200, 600);

        stage.setTitle("Hello JavaFX!");
        stage.setScene(scene);
        stage.show();
        ArrayList<Colonne> a = new ArrayList<>();
        a = ((Tableau) t).getListeColonnes();
        System.out.println(a);
    }

    public static void main(String[] args) {
        launch();
    }
}
