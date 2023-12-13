package com.example.application_trello;

import java.util.ArrayList;
import java.util.Date;

public class Tache {
    protected String nomTache;
    protected String commentaire;
    protected Date dateDebut;
    protected Date dateFin;
    protected ArrayList<Tache> listeDependances;
}
