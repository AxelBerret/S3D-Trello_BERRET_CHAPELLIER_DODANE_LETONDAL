package com.example.application_trello;

public interface InterfaceListeTaches {
    public void ajouterTache(Tache tache);
    public void supprimerTache(Tache tache);
    public Tache getTache(String nomTache);
    public void supprimerTache(Tache tache);
    public ArrayList<Tache> getListeTaches();
}
