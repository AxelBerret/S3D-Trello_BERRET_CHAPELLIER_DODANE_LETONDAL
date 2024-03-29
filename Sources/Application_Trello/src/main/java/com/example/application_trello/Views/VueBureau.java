package com.example.application_trello.Views;
import com.example.application_trello.Controls.ControlCreationColonne;
import com.example.application_trello.Objects.Colonne;
import com.example.application_trello.Objects.Observateur;
import com.example.application_trello.Objects.Sujet;
import com.example.application_trello.Objects.Tableau;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

import static javafx.application.Application.launch;
//Cette classe représente la vue bureau qui est la vue principale que l'on utilise dans l'application et qui englobe d'autres vues.
//Elle a été écrite par Titouan et Sacha

    public class VueBureau extends HBox implements Observateur {

        /**
         * attributs de la classe listColVue
         */
        private ArrayList<VueColonne> listColVue;
        private HBox rightHBox;
        private VBox vbox;  // Nouvelle VBox
        private Tableau t;


        /**
         * constructeur qui cree des objets de types VueBureau
         * @param t modele que l on souhaite utiliser
         */
        public VueBureau(Sujet t) {
            VBox leftVBox = new VBox(0);
            leftVBox.setAlignment(Pos.CENTER);
            this.t = (Tableau) t;

            VBox rightVBox = new VBox(10);
            rightVBox.setPadding(new Insets(10));
            rightVBox.setAlignment(Pos.CENTER);

            this.rightHBox = new HBox(10);

            this.vbox = new VBox(10);  // Nouvelle VBox
            vbox.setAlignment(Pos.CENTER);  // Alignement au centre

            // Création des 3 colonnes par défaut
            this.listColVue = new ArrayList<>();
            Colonne aFaire = new Colonne("A faire");
            VueColonne columnAfaire = createColumn(aFaire);
            this.t.ajouterColonne(aFaire);
            this.t.enregistrerObservateur(columnAfaire);
            Colonne enCours = new Colonne("En cours");
            VueColonne columnEnCours = createColumn(enCours);
            this.t.ajouterColonne(enCours);
            this.t.enregistrerObservateur(columnEnCours);
            Colonne termine = new Colonne("Termine");
            VueColonne columnTermine = createColumn(termine);
            this.t.ajouterColonne(termine);
            this.t.enregistrerObservateur(columnTermine);

            // Ajout des tâches par défaut à la première colonne pour servir d'exemple
            this.t.ajouterTache("Tache 1", "A faire");
            this.t.ajouterTache("Tache 2", "A faire");

            Colonne cAjout = new Colonne("Ajout");
            VueColonne colonneAjout = createAddColumn(cAjout);


            Button vueListeButton = new Button("Vue Liste");
            configureButton(vueListeButton);
            vueListeButton.setOnAction(event -> afficherVueListe());

            Button vueArchive = new Button("Accéder aux archives");
            configureButton(vueArchive);
            vueArchive.setOnAction(event -> afficherVueArchive());

            Button boutonArchivageColonne = new Button("Accéder aux archives des colonnes");
            configureButton(boutonArchivageColonne);
            boutonArchivageColonne.setOnAction(event -> afficherVueArchiveColonne());

            Button ganttButton = new Button("Création du Gantt");
            configureButton(ganttButton);
            ganttButton.setOnAction(event -> afficherVueGantt());

            Button ajoutercolonne = new Button("Ajouter une colonne");
            configureButton(ajoutercolonne);
            ControlCreationColonne contrajoutercolonne = new ControlCreationColonne(this.t);
            ajoutercolonne.setId("btnCreerColonne");
            ajoutercolonne.setOnAction(contrajoutercolonne);

            vbox.getChildren().addAll(vueListeButton, ganttButton, vueArchive, boutonArchivageColonne, ajoutercolonne, rightHBox);
            this.setStyle("-fx-background-color: linear-gradient(to top, rgba(50,0,255,0.45), rgba(200,0,200,0.45)); -fx-background-radius: 0;");
            this.setAlignment(Pos.CENTER);
            rightVBox.getChildren().addAll(vbox);
            this.getChildren().addAll(rightVBox, leftVBox);
        }


        /**
         * methode configureButton de la classe VueBureau
         * @param button bouton que l on souhaite configurer
         */
        private void configureButton(Button button) {
            button.setStyle("-fx-font-size: 14; -fx-padding: 10 30; -fx-background-radius: 100 100 100 100; -fx-background-color: white; -fx-text-fill: black;");
            button.setOnMouseEntered(e -> button.setStyle("-fx-font-size: 14; -fx-padding: 10 30; -fx-background-radius: 100 100 100 100; -fx-background-color: black; -fx-text-fill: white;"));
            button.setOnMouseExited(e -> button.setStyle("-fx-font-size: 14; -fx-padding: 10 30; -fx-background-radius: 100 100 100 100; -fx-background-color: white; -fx-text-fill: black;"));
        }

        /**
         * methode afficherVueListe de la classe VueBureau
         */
        private void afficherVueListe() {
        // Créez la VueListe en utilisant le premier objet Colonne (ici, la première colonne de la liste)
        if (!listColVue.isEmpty()) {
            VueListe vueListe = new VueListe(t, listColVue.get(0).getNomVueColonne());

            // Créez une nouvelle scène pour la VueListe
            Scene scene = new Scene(vueListe, 600, 600);
            Stage stage = new Stage();
            stage.setScene(scene);


            // Affichez la fenêtre
            stage.show();
        }
    }

    /**
     * methode afficherVueArchive de la classe VueBureau
     */
    private void afficherVueArchive() {

            VueArchive vueArchive = new VueArchive(t, listColVue.get(0).getNomVueColonne());

            // Créez une nouvelle scène pour la VueListe
            Scene scene = new Scene(vueArchive, 600, 600);
            Stage stage = new Stage();
            stage.setScene(scene);


            // Affichez la fenêtre
            stage.show();
    }

    /**
     * methode afficherVueArchiveColonne de la classe VueBureau
     */
    private void afficherVueArchiveColonne() {
        System.out.println("test");
        VueColonneArchive VueColonneArchive = new VueColonneArchive(t, listColVue.get(0).getNomVueColonne());

        // Créez une nouvelle scène pour la VueListe
        Scene scene = new Scene(VueColonneArchive, 600, 600);
        Stage stage = new Stage();
        stage.setScene(scene);


        // Affichez la fenêtre
        stage.show();
    }

    /**
     * methode afficherVueGantt de la classe VueBureau
     */
    private void afficherVueGantt() {
        // Créez la VueGantt
        VueGantt vueGantt = new VueGantt(t);

        // Créez une nouvelle scène pour la VueGantt
        Scene scene = new Scene(vueGantt, 600, 600);
        // Créez une nouvelle fenêtre (Stage)
        Stage stage = new Stage();
        stage.setScene(scene);

        // Affichez la fenêtre
        stage.show();
    }

    /**
     * methode actualiser de la classe VueBureau
     * @param s sujet que l on va actualiser
     */
    @Override
    public void actualiser(Sujet s){
        //On récupère les colonnes du modèle au moment où la méthode actualiser est appelée
        ArrayList<Colonne> listeCol = ((Tableau)s).getListeColonnes();
        ArrayList<String> listeNomCol = new ArrayList<>();//On crée une liste des noms seulement des colonnes pour simplifier les comparaisons plus tard
        for (Colonne c : listeCol) {//Pour chaque colonne du modèle
            listeNomCol.add(c.getNomColonne());// On prend son nom et le met dans la liste des noms
        }
        for (Colonne c : listeCol){//On parcours les colonnes du modèle
            if (!containsColumn(c.getNomColonne())){//Si une colonne n'est pas présente dans cette vue, on l'ajoute. (On utilise une méthode auxiliaire pour simplifier le code)
                VueColonne vc = createColumn(c);//et la méthode la crée graphiquement
                ((Tableau)s).enregistrerObservateur(vc);//et on l'enregistre dans le modèle.
            }
        }
        for (VueColonne c : this.listColVue) {// On parcourt les colonnes de la vue
            String nomC = c.getNomVueColonne();// Pour chaque colonne, on extrait son nom afin de pouvoir comparer
            if (!listeNomCol.contains(nomC)) {// Si une colonne de la vue n'est plus présente dans le modèle, on la supprime.
                ((Tableau)s).supprimerObservateur(c);
                this.removeColumnById(nomC);
            }
        }
    }

    /**
     * methode createColumn de la classe VueBureau
     * @param colonne colonne que l on souhaite cree
     * @return la vue colonne a partir de la colonne donnee
     */
    private VueColonne createColumn(Colonne colonne) {// Cette méthode ajoute un objet colonne graphiquement et renvoie la vueColonne
        VueColonne columnVBox = new VueColonne(colonne.getNomColonne(), this.t);
        this.listColVue.add(columnVBox);
        columnVBox.setId(colonne.getNomColonne());
        // gestionnaire d'événements pour le drag and drop
        setDragDropHandlers(columnVBox);
        rightHBox.getChildren().add(columnVBox);
        return columnVBox;
    }

    /**
     * methode removeColumnById de la classe VueBureau
     * @param nomColonne nom de la colonne que l on veut supprimer
     */
    public void removeColumnById(String nomColonne) {
        Node columnToRemove = null;
        // Parcourir les enfants pour trouver le HBox avec l'id donné
        for (Node node : rightHBox.getChildren()) {
            if (node.getId() != null && node.getId().equals(nomColonne)) {
                columnToRemove = node;
                break;
            }
        }

        // Supprimer le HBox si on l'a trouvé
        if (columnToRemove != null) {
            rightHBox.getChildren().remove(columnToRemove);
            //Si la liste contient un objet du même nom, on le supprime
            this.listColVue.removeIf(vueColonne -> vueColonne.getNomVueColonne().equals(nomColonne));
        }
    }

    /**
     * methode createAddColumn de la classe VueBureau
     * @param colonne colonne que l on souhaite ajouter et creer
     * @return la vue colonne partir de la colonne donnee
     */
    private VueColonne createAddColumn(Colonne colonne) {
        VueColonne specialColumnVBox = new VueColonne(colonne.getNomColonne(), this.t);
        // Ajoutez un gestionnaire d'événements pour le drag-and-drop
        setDragDropHandlers(specialColumnVBox);

        return specialColumnVBox;
    }

    /**
     * methode setDragDropHandlers de la classe VueBureau
     * @param columnVBox
     */
    private void setDragDropHandlers(VueColonne columnVBox) {
        columnVBox.setOnDragDetected(event -> {
            // Commence le glisser-déposer
            Dragboard db = columnVBox.startDragAndDrop(TransferMode.MOVE);
            // Ajoute les données à transférer (ici, le nom et la colonne de la tâche)
            ClipboardContent content = new ClipboardContent();
            content.putString(columnVBox.getTaskName(event) + "|" + columnVBox.getNomVueColonne());
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
                // Sépare le nom de la tâche et le nom de la colonne
                String[] taskInfo = db.getString().split("\\|");
                if (taskInfo.length == 2) {
                    String taskName = taskInfo[0];
                    String sourceColumn = taskInfo[1];

                    // Appelle la méthode deplacerTache sur l'instance du tableau
                    t.deplacerTache(taskName, sourceColumn, columnVBox.getNomVueColonne());

                    success = true;
                }
            }

            // Indique que le déplacement est terminé
            event.setDropCompleted(success);
            event.consume();
        });

        columnVBox.setOnDragDone(DragEvent::consume);
    }

    /**
     * methode findColumnByName de la classe VueBureau
     * @param parent
     * @param columnName
     * @return la vue colonne a partir du parent et du nom de la colonne
     */
    private VueColonne findColumnByName(Parent parent, String columnName) {
        if (parent instanceof HBox) {
            HBox hbox = (HBox) parent;

            for (Node node : hbox.getChildren()) {
                if (node instanceof VueColonne && node.getId().equals(columnName)) {
                    return (VueColonne) node;
                }
            }
        }

        return null;
    }

    /**
     * methode containsColumn de la classe VueBureau
     * @param columnName npm de la colonne que l on souhaite verifier
     * @return vrai si contenu sinon faux
     */
    private boolean containsColumn(String columnName) {//Méthode qui compare le nom en paramètre avec les noms de la liste des colonnes présentes dans la vue.
        //Renvoie vrai si la colonne est présente, faux sinon
        for (VueColonne vueColonne : this.listColVue) {
            if (vueColonne.getNomVueColonne().equals(columnName)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        launch();
    }
}
