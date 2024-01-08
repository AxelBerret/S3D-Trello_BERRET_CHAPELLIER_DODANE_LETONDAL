package com.example.application_trello.TestMVC;

public class ControlCreationColonneTest {

    private TableauTest tableau;

    public ControlCreationColonneTest(TableauTest tableau) {
        this.tableau = tableau;
    }

    public void creerColonne(String nomColonne) {
        tableau.ajouterColonne(nomColonne);
    }
}
