package com.example.application_trello;

import java.util.Date;

public class TacheSimple extends Tache {

    public TacheSimple(String nomTache) {
        super(nomTache);
    }

    @Override
    public String toString() {
        return "TacheSimple{" +
                "nomTache='" + nomTache + '\'' +
                ", commentaire='" + commentaire + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", listeDependances=" + listeDependances +
                '}';
    }
}
