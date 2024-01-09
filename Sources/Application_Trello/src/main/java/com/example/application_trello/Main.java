package com.example.application_trello;

public class Main {

    public static void main(String[] args) {
        // liste des tableaux
        ListeTableaux listeTab = new ListeTableaux();

        // creation d'un tableau
        Tableau tab1 = new Tableau("Tableau 1");
        Tableau tab2 = new Tableau("Tableau 2");

        // creation de colonnes
        Colonne col1 = new Colonne("A faire");
        Colonne col2 = new Colonne("En cours");
        Colonne col3 = new Colonne("Terminee");

        // creation de taches
        // taches complexes
        TacheComplexe tc1 = new TacheComplexe("TacheC 1");
        TacheComplexe tc2 = new TacheComplexe("TacheC 2");

        // taches simples
        TacheSimple ts1 = new TacheSimple("TacheS 1");
        TacheSimple ts2 = new TacheSimple("TacheS 2");
        TacheSimple ts3 = new TacheSimple("TacheS 3");
        TacheSimple ts4 = new TacheSimple("TacheS 4");
        TacheSimple ts5 = new TacheSimple("TacheS 5");
        TacheSimple ts6 = new TacheSimple("TacheS 6");
        TacheSimple ts7 = new TacheSimple("TacheS 7");
        TacheSimple ts8 = new TacheSimple("TacheS 8");


        // ajout des sous taches
        tc2.ajouterTache(ts1);
        tc2.ajouterTache(ts2);

        tc1.ajouterTache(tc2);
        tc1.ajouterTache(ts3);
        tc1.ajouterTache(ts4);

        //ajout des dependances
        ts5.ajouterDependance(ts7);
        ts5.ajouterDependance(ts8);

        // ajout des taches dans les colonnes
        col1.ajouterTache(tc1);
        col2.ajouterTache(ts5);
        col3.ajouterTache(ts6);

        // ajout des colonnes dans le tableau
        tab1.ajouterColonne(col1);
        tab1.ajouterColonne(col2);
        tab1.ajouterColonne(col3);

        // ajout du tableau dans la liste des tableaux
        listeTab.ajouterTableau(tab1);
        listeTab.ajouterTableau(tab2);

        // affichage des tableaux
        System.out.println("Affichage des tableaux");
        System.out.println(listeTab);
    }
}
