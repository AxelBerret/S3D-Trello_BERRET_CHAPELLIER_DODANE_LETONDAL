package com.example.application_trello;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class VueColonne extends VBox implements Observateur{

    private String nomColonne;
    private Tableau t;
    private ArrayList<String> listeTaches;

    public VueColonne(String columnName, Tableau t) {
        this.nomColonne = columnName;
        this.t = t;
        this.listeTaches = new ArrayList<>();
        Colonne c = new Colonne(columnName);
        initialize();
    }

    public VueColonne(Colonne c){
        this.nomColonne = c.getNomColonne();
        this.listeTaches = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        setMinWidth(200);
        setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        setAlignment(Pos.TOP_CENTER);

        Label columnLabel = new Label(this.nomColonne);
        columnLabel.setPadding(new Insets(30));
        columnLabel.setAlignment(Pos.TOP_CENTER);

        HBox additionalButtonsRow = new HBox(15);
        additionalButtonsRow.setAlignment(Pos.CENTER);
        Button newButton1 = createIconButton("trombonne.png");
        Button boutonSupp = createIconButton("croix.png");

        boutonSupp.setId("btnSupprimerColonne" + this.nomColonne);
        ControlSuppressionColonne controlSup = new ControlSuppressionColonne(this.t);
        boutonSupp.setOnAction(controlSup);
        Button boutonPlus = createIconButton("plus.png");
        boutonPlus.setId("btnCreerTache" + this.getNomVueColonne());
        ControlCreationTache cct = new ControlCreationTache(this.t);
        boutonPlus.setOnAction(cct);
        additionalButtonsRow.getChildren().addAll(newButton1, boutonSupp, boutonPlus);
        additionalButtonsRow.setPadding(new Insets(20));
        getChildren().addAll(columnLabel, additionalButtonsRow);

        setOnDragOver(event -> {
            if (event.getGestureSource() != this && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            boolean success = false;

            if (db.hasString()) {
                // Move the task to this column
                addTask(db.getString());
                success = true;
            }

            event.setDropCompleted(success);
            event.consume();
        });
    }

    @Override
    public void actualiser(Sujet s) {
        Colonne colonneModele = ((Tableau)s).getColonne(this.nomColonne);
        if (colonneModele != null){
            ArrayList<Tache> lisTacheCol = colonneModele.getListeTaches();//On récupère depuis le modèle la liste des tâches que doit contenir cette colonne
            for (Tache t : lisTacheCol){//boucle qui parcourt les taches présentes dans le modèle et ajoute celles qui ne le sont pas encore
                String nom = t.getNomTache();
                System.out.println("Ajout en cours de la tâche " + nom);
                if (!this.listeTaches.contains(nom)){//Si la liste de la vue ne contient pas la tache nom alors
                    addTask(nom);//On l'ajoute
                }
            }
            for (String nomT : this.listeTaches){//Boucle qui parcourt les taches présentes dans la vue et supprime celles qui ne sont plus dans le modèle
                if (!containsTache(nomT, lisTacheCol)){//Si la liste du modèle ne contient pas la tache nomT alors
                    //On la supprime de notre liste
                    removeTaskById(nomT);
                }
            }
        }
    }

    private boolean containsTache(String nomT, ArrayList<Tache> lisT) {//Méthode auxiliaire à la méthode actualiser
        for (Tache t : lisT) {
            if (t.getNomTache().equals(nomT)) {
                return true;
            }
        }
        return false;
    }

    public String getNomVueColonne() {
        return this.nomColonne;
    }

    public String getTaskName() {
        // Récupère le dernier élément ajouté à la colonne, qui est la tâche
        HBox taskInColumn = (HBox) getChildren().get(getChildren().size() - 1);
        Hyperlink clickableText = (Hyperlink) taskInColumn.getChildren().get(0);
        return clickableText.getText();
    }

    public void addTask(String taskName) {
        this.listeTaches.add(taskName);
        Hyperlink clickableText = new Hyperlink(taskName);
        clickableText.setStyle("-fx-text-fill: black; -fx-underline: none;");

        HBox buttonRow = new HBox(10);
        buttonRow.setAlignment(Pos.CENTER);
        Button trombonneButton = createIconButton("trombonne.png");
        Button croixButton = createIconButton("croix.png");
        ControlSuppressionTache conSupTache = new ControlSuppressionTache(this.t, this.nomColonne, taskName);
        croixButton.setOnAction(conSupTache);
        buttonRow.getChildren().addAll(trombonneButton, croixButton);

        HBox taskInColumn = new HBox(10);
        taskInColumn.setPadding(new Insets(20));
        taskInColumn.setId(taskName);
        taskInColumn.getChildren().addAll(clickableText, buttonRow);

        Separator columnSeparator = new Separator();
        columnSeparator.setOrientation(Orientation.HORIZONTAL);
        columnSeparator.setStyle("-fx-background-color: black; -fx-min-height: 2px; -fx-pref-height: 2px; -fx-max-height: 2px;");

        this.getChildren().addAll(columnSeparator, taskInColumn);
    }

    public void removeTaskById(String nomT) {
        Node taskToRemove = null;

        // Parcourir les enfants pour trouver le HBox avec l'id donné
        for (Node node : getChildren()) {
            if (node.getId() != null && node.getId().equals(nomT)) {
                taskToRemove = node;
                break;
            }
        }

        // Supprimer le HBox et son séparateur si on l'a trouvé
        if (taskToRemove != null) {
            int indexToRemove = getChildren().indexOf(taskToRemove);
            if (indexToRemove > 0) {
                // Supprimer le HBox et son séparateur
                getChildren().remove(indexToRemove - 1, indexToRemove + 1);
            } else {
                // Supprimer uniquement le HBox si le séparateur n'est pas présent
                getChildren().remove(taskToRemove);
            }
            this.listeTaches.remove(nomT);//On supprime la tâche de la liste de la vue
        }
    }




    private Button createIconButton(String imageName) {
        Image image = new Image("file:Image/" + imageName);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        imageView.setPreserveRatio(true);
        Button button = new Button("", imageView);
        button.setStyle("-fx-background-color: lightblue;");
        addHoverEffect(button);
        return button;
    }

    private void addHoverEffect(Button button) {
        button.setOnMouseEntered(e -> button.setStyle("-fx-background-color: pink;"));
        button.setOnMouseExited(e -> button.setStyle("-fx-background-color: lightblue;"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VueColonne that = (VueColonne) o;
        return Objects.equals(getNomVueColonne(), that.getNomVueColonne());
    }
}
