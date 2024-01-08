package com.example.application_trello.TestMVC;

import com.example.application_trello.*;

import java.util.ArrayList;

public class VueTacheConsoleTest implements Observateur {

    @Override
    public void actualiser(Sujet s) {
        if (s instanceof TableauTest) {
            TableauTest tableau = (TableauTest) s;
            ArrayList<Tache> listeTaches = tableau.getListeTaches();
            if (!listeTaches.isEmpty()) {
                System.out.println("Nouvelle tâche ajoutée : " + listeTaches.get(listeTaches.size() - 1));
            } else {
                System.out.println("Aucune tâche disponible.");
            }
        }
    }
}
