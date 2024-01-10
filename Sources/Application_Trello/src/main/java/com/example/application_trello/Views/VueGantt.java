package com.example.application_trello.Views;

import com.example.application_trello.Controls.ControlModificationTache;
import com.example.application_trello.Objects.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class VueGantt extends HBox implements Observateur {

    private Tableau tableau;

    public VueGantt(Tableau tableau) {
        this.tableau = tableau;
        initialize();
    }

    private void initialize() {
        setSpacing(10);
        setPadding(new Insets(10));
        setAlignment(Pos.TOP_CENTER);
        setStyle("-fx-background-color: linear-gradient(to top, rgba(50,0,255,0.45), rgba(200,0,200,0.45)); -fx-background-radius: 0;");

        actualiser(tableau);

        tableau.enregistrerObservateur(this);
    }

    private Rectangle createTransparentRectangle(LocalDate baseDate, LocalDate startDate, double daySize) {
        // Calculer la différence entre la baseDate et la date de début
        long daysBeforeStart = ChronoUnit.DAYS.between(baseDate, startDate);
        Rectangle rectangletr = new Rectangle(daysBeforeStart * daySize, 30);
        rectangletr.setFill(Color.TRANSPARENT);
        return rectangletr;
    }

    private Rectangle createGanttRectangle(Tache tache, LocalDate baseDate, double daySize) {
        // Vérifier si la baseDate ou la date de fin est null
        if (baseDate == null || tache.getDateFin() == null) {
            // Gérer le cas où la baseDate ou la date de fin est null
            System.err.println("La baseDate ou la date de fin est null");
            return new Rectangle();  // Ou renvoyer une valeur par défaut
        }

        // Utiliser un mapping pour associer chaque colonne à un indice fictif
        int indiceColonne = getIndiceColonne(tache);

        long totalDaysLong = ChronoUnit.DAYS.between(baseDate, tache.getDateFin()) + 1;
        int totalDays = Math.toIntExact(totalDaysLong);

        double startOffset = ChronoUnit.DAYS.between(baseDate, tache.getDateDebut());
        double duration = tache.getDuree();

        double DAY_SIZE = daySize;
        Rectangle rectangle = new Rectangle(startOffset * DAY_SIZE, 30, duration * DAY_SIZE, 30);

        // Utiliser la couleur associée à l'indice fictif
        rectangle.setFill(getCouleurByIndice(indiceColonne));
        System.out.println("affichage du rectangle");
        return rectangle;
    }

    public void actualiser(Sujet s) {
        getChildren().clear();

        // Partie gauche avec les hyperliens
        VBox hyperlinksBox = new VBox(10);
        hyperlinksBox.setAlignment(Pos.CENTER_LEFT);

        // Partie droite avec les rectangles
        VBox rectanglesBox = new VBox(10);
        rectanglesBox.setAlignment(Pos.CENTER_LEFT);

        // Trouver la date de début de la première tâche
        LocalDate baseDate = determinerBaseDate(tableau);

        // Parcourir toutes les colonnes du tableau
        for (Colonne colonne : tableau.getListeColonnes()) {
            for (Tache tache : colonne.getListeTaches()) {
                if (tache.getDateDebut() != null && tache.getDateFin() != null) {
                    Hyperlink hyperlinkTache = new Hyperlink(tache.getNomTache());
                    hyperlinkTache.setStyle("-fx-text-fill: white; -fx-font-size: 16;");

                    Tache ta = this.tableau.getTache(tache.getNomTache());
                    ControlModificationTache cmt = new ControlModificationTache(this.tableau, ta);

                    hyperlinkTache.setOnAction(cmt);

                    hyperlinksBox.getChildren().add(hyperlinkTache);

                    // Ajouter le rectangle transparent avant la date de début
                    Rectangle preStartRect = createTransparentRectangle(baseDate, tache.getDateDebut(), 10);
                    // Ajouter le rectangle de la tâche
                    Rectangle rectangleTache = createGanttRectangle(tache, baseDate, 10);

                    // Ajouter la ligne actuelle avec les rectangles
                    HBox rowBox = new HBox(10);
                    rowBox.setAlignment(Pos.CENTER_LEFT);
                    rowBox.getChildren().addAll(preStartRect, rectangleTache);

                    rectanglesBox.getChildren().add(rowBox);
                }
                if (tache instanceof TacheComplexe){
                for (Tache tac : ((TacheComplexe) tache).getListeTaches()) {
                    if (tache.getDateDebut() != null && tache.getDateFin() != null) {
                        Hyperlink hyperlinkTache = new Hyperlink(tache.getNomTache());
                        hyperlinkTache.setStyle("-fx-text-fill: white; -fx-font-size: 16;");

                        Tache ta = this.tableau.getTache(tache.getNomTache());
                        ControlModificationTache cmt = new ControlModificationTache(this.tableau, ta);

                        hyperlinkTache.setOnAction(cmt);

                        hyperlinksBox.getChildren().add(hyperlinkTache);

                        // Ajouter le rectangle transparent avant la date de début
                        Rectangle preStartRect = createTransparentRectangle(baseDate, tache.getDateDebut(), 10);
                        // Ajouter le rectangle de la tâche
                        Rectangle rectangleTache = createGanttRectangle(tache, baseDate, 10);

                        // Ajouter la ligne actuelle avec les rectangles
                        HBox rowBox = new HBox(10);
                        rowBox.setAlignment(Pos.CENTER_LEFT);
                        rowBox.getChildren().addAll(preStartRect, rectangleTache);

                        rectanglesBox.getChildren().add(rowBox);
                    }
                }
            }
        }

        // Ajouter les hyperliens et rectangles à la vue Gantt
        getChildren().addAll(hyperlinksBox, rectanglesBox);
    }}


    // Méthode pour obtenir l'indice fictif associé à la colonne
    private int getIndiceColonne(Tache tache) {
        int indice = 0;
        for (Colonne colonne : tableau.getListeColonnes()) {
            if (colonne.getListeTaches().contains(tache)) {
                break;
            }
            indice++;
        }
        return indice;
    }

    // Méthode pour obtenir la couleur associée à l'indice fictif
    private Color getCouleurByIndice(int indiceColonne) {
        // Utiliser l'indice fictif pour déterminer la couleur
        switch (indiceColonne) {
            case 0:
                return Color.BLUE;
            case 1:
                return Color.ORANGE;
            case 2:
                return Color.GREEN;
            case 3:
                return Color.RED;
            case 4:
                return Color.DARKCYAN;
            case 5:
                return Color.LIGHTGREY;
            default:
                return Color.WHITE;
        }
    }

    private LocalDate determinerBaseDate(Tableau tableau) {
        // Trouver la date de début de la première tâche
        for (Colonne colonne : tableau.getListeColonnes()) {
            for (Tache tache : colonne.getListeTaches()) {
                if (tache.getDateDebut() != null) {
                    return tache.getDateDebut();
                }
            }
        }
        return null;  // Retourner null si aucune tâche n'a de date de début
    }
}
