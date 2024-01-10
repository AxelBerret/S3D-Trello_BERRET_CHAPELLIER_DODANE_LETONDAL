package com.example.application_trello.Views;
import com.example.application_trello.Objects.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static com.example.application_trello.Objects.Tache.determinerBaseDate;

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

    public void actualiser(Sujet s) {
        getChildren().clear();

        // Parcourir toutes les colonnes du tableau
        for (Colonne colonne : tableau.getListeColonnes()) {
            String nomColonne = colonne.getNomColonne();

            // Ajouter un label pour indiquer la colonne
            Label labelColonne = new Label(nomColonne);
            labelColonne.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 18;");
            getChildren().add(labelColonne);
            // Ajouter la logique du diagramme de Gantt ici
            for (Tache tache : colonne.getListeTaches()) {
                // Vérifier si la tâche a des dates de début et de fin définies
                System.out.println("taches trouvées" +tache);

                if (tache.getDateDebut() != null && tache.getDateFin() != null) {
                    System.out.println("récuppérations de la date de la tache : " +tache);
                    System.out.println("date début" +tache.getDateDebut());
                    System.out.println("date fin" +tache.getDateFin());


                    Rectangle rectangleTache = createGanttRectangle(tache);
                    getChildren().add(rectangleTache);
                }
            }
        }
    }



    private Rectangle createGanttRectangle(Tache tache) {
        LocalDate baseDate = determinerBaseDate(tableau);

        // Vérifier si la baseDate est null
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

        double DAY_SIZE = 10;
        Rectangle rectangle = new Rectangle(startOffset * DAY_SIZE, 20, duration * DAY_SIZE, 20);

        // Utiliser la couleur associée à l'indice fictif
        rectangle.setFill(getCouleurByIndice(indiceColonne));
        System.out.println("affichage du rectangle");
        return rectangle;
    }

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
            default:
                return Color.WHITE;
        }
    }



}
