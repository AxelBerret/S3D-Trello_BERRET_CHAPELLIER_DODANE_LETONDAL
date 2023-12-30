package com.example.application_trello;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Separator;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

import static javafx.application.Application.launch;

public class NewVueBureau extends HBox implements Observateur{

    private ArrayList<VueColonne> listColVue;
    private HBox rightHBox;

    public void NewVueBureau() {
        VBox leftVBox = new VBox(100);
        leftVBox.setAlignment(Pos.CENTER);

        for (int i = 1; i <= 5; i++) {
            Hyperlink link = new Hyperlink("Link " + i);
            link.setStyle("-fx-font-size: 14;-fx-padding: 50; -fx-border-color: transparent; -fx-background-color: transparent;");
            link.setStyle("-fx-text-fill: black; -fx-underline: none;");
            link.setOnMouseEntered(e -> link.setStyle(" -fx-background-color: white; -fx-text-fill: black;"));
            link.setOnMouseExited(e -> link.setStyle("-fx-background-color: transparent; -fx-text-fill: black;"));

            link.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            VBox.setMargin(link, new Insets(30));
            link.setPadding(new Insets(10, 30, 10, 30));
            leftVBox.getChildren().add(link);
        }

        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);

        VBox rightVBox = new VBox(20);
        rightVBox.setPadding(new Insets(20));
        rightVBox.setAlignment(Pos.CENTER);

        this.rightHBox = new HBox(20);


        //Création des 3 colonnes par défaut
        Colonne afaire = new Colonne("A faire");//On crée un objet colonne
        VueColonne columnAfaire = createColumn(afaire);//On le passe en paramètre de la méthode créer une colonne
        this.listColVue.add(columnAfaire);//On l'ajoute a l'attribut de la liste des colonnes présentes
        Colonne enCours = new Colonne("En cours");
        VueColonne columnEnCours = createColumn(enCours);
        this.listColVue.add(columnEnCours);
        Colonne termine = new Colonne("Terminé");
        VueColonne columnTermine = createColumn(termine);
        this.listColVue.add(columnTermine);


        // On ajoute des tâches par défaut à la première colonne pour servir d'exemple
        columnAfaire.addTask("Tache 1");
        columnAfaire.addTask("Tache 2");

        // Colonne pour créer une nouvelle colonne
        VueColonne createColumnColumn = createSpecialColumn();

        rightHBox.getChildren().addAll(columnAfaire, columnEnCours, columnTermine, createColumnColumn);
        rightHBox.setMargin(createColumnColumn, new Insets(0, 0, 0, 50));

        Button ganttButton = new Button("Création du Gantt");
        ganttButton.setStyle("-fx-font-size: 16; -fx-padding: 10 50; -fx-background-radius: 30 30 30 30; -fx-background-color: white; -fx-text-fill: black;");
        VBox.setMargin(ganttButton, new Insets(30));
        ganttButton.setOnMouseEntered(e -> ganttButton.setStyle("-fx-font-size: 16; -fx-padding: 10 50; -fx-background-radius: 30 30 30 30; -fx-background-color: black; -fx-text-fill: white;"));
        ganttButton.setOnMouseExited(e -> ganttButton.setStyle("-fx-font-size: 16; -fx-padding: 10 50; -fx-background-radius: 30 30 30 30; -fx-background-color: white; -fx-text-fill: black;"));
        this.setSpacing(20);
        this.getChildren().addAll(leftVBox, separator, rightVBox);
        this.setStyle("-fx-background-color: linear-gradient(to top, rgba(50,0,255,0.45), rgba(200,0,200,0.45)); -fx-background-radius: 0;");
        rightVBox.getChildren().addAll(rightHBox, ganttButton);
    }

    @Override
    public void actualiser(Sujet s){
        //On récupère les colonnes du modèle au moment où la méthode actualiser est appelée
        ArrayList<Colonne> listeCol = ((Tableau)s).getListeColonnes();
        ArrayList<String> listeNomCol = null;
        for (Colonne c : listeCol){
            listeNomCol.add(c.getNomColonne());//On crée une liste de noms des colonnes pour simplifier les comparaisons
        }

        for (Colonne c : listeCol){//On parcours les colonnes du modèle
            if (!this.listColVue.contains(new VueColonne(c.getNomColonne()))){//Si une colonne n'est pas présente dans la vue, on l'ajoute. (on crée une vueColonne temporaire pour comparer)
                this.createColumn(c);//et la méthode la crée graphiquement
            }
        }
        for (VueColonne c : this.listColVue){//On parcours les colonnes de la vue
            String nomC = c.getColumnLabel();//Pour chaque colonne on extrait son nom afin de pouvoir comparer
            if (!listeNomCol.contains(nomC)){//Si une colonne de la vue n'est plus présente dans le modèle, on la supprime.
                this.removeColumn(c);
            }
        }
    }

    private VueColonne createColumn(Colonne colonne) {//Cette méthode ajoute un objet colonne dans les données et renvoie une vueColonne
        VueColonne columnVBox = new VueColonne(colonne.getNomColonne());

        // Ajoutez un gestionnaire d'événements pour le drag-and-drop
        setDragDropHandlers(columnVBox);

        return columnVBox;
    }

    private void removeColumn(VueColonne colonne){
        this.listColVue.remove(colonne);
        this.rightHBox.getChildren().remove(colonne);
    }

    private VueColonne createSpecialColumn() {
        VueColonne specialColumnVBox = new VueColonne();

        // Ajoutez un gestionnaire d'événements pour le drag-and-drop
        setDragDropHandlers(specialColumnVBox);

        return specialColumnVBox;
    }

    // Méthode pour définir les gestionnaires d'événements de glisser-déposer
    private void setDragDropHandlers(VueColonne columnVBox) {
        columnVBox.setOnDragDetected(event -> {
            // Commence le glisser-déposer
            Dragboard db = columnVBox.startDragAndDrop(TransferMode.MOVE);

            // Ajoute les données à transférer (ici, le nom de la tâche)
            ClipboardContent content = new ClipboardContent();
            content.putString(columnVBox.getTaskName());
            db.setContent(content);

            event.consume();
        });

        columnVBox.setOnDragOver(event -> {
            // Autorise le déplacement si les données sont du type attendu
            if (event.getGestureSource() != columnVBox && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }

            event.consume();
        });

        columnVBox.setOnDragDropped(event -> {
            // Récupère le contenu des données déposées
            Dragboard db = event.getDragboard();
            boolean success = false;

            if (db.hasString()) {
                // Ajoute la tâche à la colonne actuelle
                columnVBox.addTask(db.getString());
                success = true;
            }

            // Indique que le déplacement est terminé
            event.setDropCompleted(success);
            event.consume();
        });

        columnVBox.setOnDragDone(DragEvent::consume);
    }

    public static void main(String[] args) {
        launch();
    }
}
