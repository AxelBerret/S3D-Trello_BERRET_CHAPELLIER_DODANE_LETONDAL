package com.example.application_trello.TestMVC;

public class ControlCreationTacheTest {

    private TableauTest tableau;

    public ControlCreationTacheTest(TableauTest tableau) {
        this.tableau = tableau;
    }

    public void creerTache(String nomColonne, String nomTache) {
        tableau.ajouterTache(nomTache, nomColonne);
        tableau.notifierObservateurs(); // Notifier la vue du changement
    }
}
