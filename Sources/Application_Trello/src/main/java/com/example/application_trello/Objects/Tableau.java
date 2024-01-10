
package com.example.application_trello.Objects;

import com.example.application_trello.Views.VueTache;

import java.util.ArrayList;

/**
 * Classe Tableau
 * représente un tableau de l'application, contient toutes les méthodes requises à l'architecture MVC et au fonctionnement interne de l'application.
 * fait par Axel, Sacha, Titouan et Logan
 */
public class Tableau implements Sujet {

    /**
     * attribut nomTableau de la classe Tableau
     * represente le nom du tableau (espace de travail)
     */
    private String nomTableau;
    private boolean estEnCoursDActualisation = false;

    /**
     * attribut listeObjets de la classe Tableau
     * represente la liste de tout les objets presents dans le tableau
     * (colonnes et taches)
     */
    private ArrayList<InterfaceListeTaches> listeObjets;

    /**
     * attribut archive de la classe Tableau
     * represente l archive du tableau
     */
    private Archive archive;

    /**
     * attribut observateurs de la classe Tableau
     * represente la liste des observateurs
     */
    private ArrayList<Observateur> observateurs;


    /**
     * constructeur qui cree des objets de types Tableau
     * a partir des donnees passees en parametres
     * @param pNom nom que l on souhaite donner au tableau
     */
    public Tableau(String pNom) {
        this.nomTableau = pNom;
        this.listeObjets = new ArrayList<InterfaceListeTaches>();
        this.observateurs = new ArrayList<Observateur>();
        this.archive = new Archive();
    }


    /**
     * methode getNomTableau de la classe Tableau
     * @return le nom du tableau
     */
    public String getNomTableau() {return this.nomTableau;}

    /**
     * methode getArchive de la classe Tableau
     * @return l archive du tableau
     */
    public Archive getArchive() {return this.archive;}

    /**
     * methode getListeObjets de la classe Tableau
     * @return la liste des objets (colonne ou taches)
     */
    public ArrayList<InterfaceListeTaches> getListeObjets() {return this.listeObjets;}

    /**
     * methode getListeTaches de la classe Tableau
     * @return la liste des taches dans la liste des objets
     */
    public ArrayList<Tache> getListeTaches() {
        ArrayList<Tache> listeTaches = new ArrayList<Tache>();
        for (int i = 0; i < this.listeObjets.size(); i++) {
            if (this.listeObjets.get(i) instanceof Colonne) {
                for (int j = 0; j < this.listeObjets.get(i).getListeTaches().size(); j++) {
                    listeTaches.add((Tache)this.listeObjets.get(i).getListeTaches().get(j));
                }
            }
        }
        return listeTaches;
    }

    /**
     * methode getColonnes de la classe Tableau
     * @return la liste des colonnes dans la liste des objets
     */
    public ArrayList<Colonne> getListeColonnes() {
        ArrayList<Colonne> listeColonnes = new ArrayList<Colonne>();
        for (int i = 0; i < this.listeObjets.size(); i++) {
            if (this.listeObjets.get(i) instanceof Colonne) {
                listeColonnes.add((Colonne)this.listeObjets.get(i));
            }
        }
        return listeColonnes;
    }

    /**
     * methode getTache de la classe Tableau
     * @param nomTache nom de la tache que l on souhaite posseder
     * @return la tache voulue
     */
    public Tache getTache(String nomTache) {
        Tache res = null;
        for (int i = 0; i < this.getListeTaches().size(); i++) {
            if (this.getListeTaches().get(i).getNomTache().equals(nomTache)) {
                res = this.getListeTaches().get(i);
            }
        }
        return res;
    }

    /**
     * methode getColonne de la classe Tableau
     * @param nomColonne nom de la colonne que l on souhaite posseder
     * @return la colonne voulue
     */
    public Colonne getColonne(String nomColonne) {
        Colonne res = null;
        for (int i = 0; i < this.getListeColonnes().size(); i++) {
            if (this.getListeColonnes().get(i).getNomColonne().equals(nomColonne)) {
                res = this.getListeColonnes().get(i);
            }
        }
        return res;
    }

    /**
     * methode ajouterColonne de la classe Tableau
     * @param col colonne que l on souhaite ajouter au tableau
     */
    public void ajouterColonne(Colonne col) {
        ArrayList<Colonne> lc = this.getListeColonnes();
        if (!(lc.contains(col))) {
            this.listeObjets.add(col);
            this.notifierObservateurs();
        }
    }

    /**
     * methode supprimerColonne de la classe Tableau
     * @param col colonne que l on souhaite supprimer du tableau
     */
    public void supprimerColonne(Colonne col) {
        this.listeObjets.remove(col);
        this.notifierObservateurs();
    }

    /**
     * methode ajouterTache de la classe Tableau
     * @param nomTache nom de la tache que l on souhaite ajouter
     * @param nomColonne nom de la colonne dans laquelle on veut ajouter la tache
     */
    public void ajouterTache(String nomTache, String nomColonne){
        for (int i = 0; i < this.getListeColonnes().size(); i++) {
            if (this.getListeColonnes().get(i).getNomColonne().equals(nomColonne)) {
                Tache t = new TacheSimple(nomTache);
                this.getListeColonnes().get(i).ajouterTache(t);
            }
        }
        this.notifierObservateurs();
    }

    /**
     * methode supprimerTache de la classe Tableau
     * @param nomTache nom de la tache que l on souhaite supprimer
     * @param nomColonne nom de la colonne dans laquelle on souhaite supprimer la tache
     */
    public void supprimerTache(String nomTache, String nomColonne){
        ArrayList<Colonne> lc = this.getListeColonnes();
        for (Colonne c : lc){
            if (c.getNomColonne().equals(nomColonne)){
                Tache t = c.getTache(nomTache);
                c.supprimerTache(c.getTache(nomTache));

            }
        }
        notifierObservateurs();
    }

    /**
     * methode archiverTache de la classe Tableau
     * @param nomTache nom de la tache que l on souhaite archiver
     * @param nomColonne nom de la colonne dans laquelle on souhaite archiver la tache
     */
    public void archiverTache(String nomTache, String nomColonne) {
        for (int i = 0; i < this.getListeColonnes().size(); i++) {
            System.out.println("NOM DE LA COLONNE PARAMETRE : " + nomColonne + "Nom de la colonne réelle ; " + this.getListeColonnes().get(i));
            if (this.getListeColonnes().get(i).getNomColonne().equals(nomColonne)) {
                Tache t = this.getTache(nomTache);
                this.archive.archiverTache(t);
                this.getListeColonnes().get(i).supprimerTache(t);
            }
        }
        this.notifierObservateurs();
    }

    /**
     * methode desarchiverTache de la classe Tableau
     * @param nomTache nom de la tache que l on souhaite desarchiver la tache
     */
    public void desarchiverTache(String nomTache,String nomCol) {
        for (int i = 0; i < this.archive.getListeTachesArchivees().size(); i++) {
            if (this.archive.getListeTachesArchivees().get(i).getNomTache().equals(nomTache)) {
                Tache t = this.archive.getListeTachesArchivees().get(i);
                this.getColonne(nomCol).ajouterTache(t);
                this.archive.desarchiverTache(t);
            }
        }
        this.notifierObservateurs();
    }

    /**
     * methode archiverColonne de la classe Tableau
     * @param nomColonne nom de la colonne que l on souhaite archiver
     */
    public void archiverColonne(String nomColonne) {
        Colonne colonne = this.getColonne(nomColonne);
        this.archive.archiverColonne(colonne);
        this.notifierObservateurs();
        this.supprimerColonne(colonne);

    }

    /**
     * methode desarchiverColonne de la classe Tableau
     * @param nomColonne nom de la colonne que l on souhaite desarchiver
     */
    public void desarchiverColonne(String nomColonne) {
        for (int i = 0; i < this.archive.getListeColonnesArchivees().size(); i++) {
            if (this.archive.getListeColonnesArchivees().get(i).getNomColonne().equals(nomColonne)) {
                Colonne colonne = this.archive.getListeColonnesArchivees().get(i);
                this.ajouterColonne(colonne);
                this.archive.desarchiverColonne(colonne);
            }
        }
        this.notifierObservateurs();
    }
    public void deplacerTache(String nomTache, String nomColonneSource, String nomColonneDestination) {
        Colonne colonneSource = getColonne(nomColonneSource);
        Colonne colonneDestination = getColonne(nomColonneDestination);

        if (colonneSource != null && colonneDestination != null) {
            Tache tache = colonneSource.getTache(nomTache);

            if (tache != null) {

                // Ajoute la tâche à la colonne destination

                ajouterTache(tache.getNomTache(), nomColonneDestination);

                // Supprime la tâche de la colonne source
                supprimerTache(tache.getNomTache(), nomColonneSource);

                // Notifie les observateurs du tableau
                notifierObservateurs();
            }
        }
    }


    public void ajouterDependance(String nomTache, String nomTacheAAjouter) {
        Tache tAAjouter = null;
        for (Tache t : this.getListeTaches()) {
            if (t.getNomTache().equals(nomTacheAAjouter)) {
                tAAjouter = t;
            }
        }
        for (Tache t : this.getListeTaches()) {
            if (t.getNomTache().equals(nomTache)) {
                t.ajouterDependance(tAAjouter);
            }
        }
        this.notifierObservateurs();
    }

    public void ajouterSousTache(String nomTache, String nomTacheAAjouter){
        Tache tAAjouter = null;
        for (Tache t : this.getListeTaches()){
            if (t.getNomTache().equals(nomTacheAAjouter)){
                tAAjouter = t;
            }
        }
        for (Tache t : this.getListeTaches()){
            if (t.getNomTache().equals(nomTache)){
                if (t instanceof TacheSimple ts){
                    TacheComplexe tc = tacheSimpleToTacheComplexe(ts);
                    tc.ajouterTache(tAAjouter);
                } else if(t instanceof TacheComplexe tc){
                    tc.ajouterTache(tAAjouter);
                }
            }
        }
        this.notifierObservateurs();
    }

    public Colonne getColonneByTask(Tache t){
        for (Colonne c : this.getListeColonnes()){
            if (c.getListeTaches().contains(t)){
                return c;
            }
        }
        return null;
    }

    public TacheComplexe tacheSimpleToTacheComplexe(TacheSimple ts){
        TacheComplexe tc = new TacheComplexe(ts);
        Colonne actuelle = getColonneByTask(ts);
        actuelle.supprimerTache(ts);
        actuelle.ajouterTache(tc);
        return tc;
    }

    /**
     * methode enregistrerObservateur de la classe Tableau
     * @param o observateur que l on souhaite enregistrer
     */
    @Override
    public void enregistrerObservateur(Observateur o) {
        this.observateurs.add(o);
    }

    /**
     * methode supprimerObservateur de la classe Tableau
     * @param o observateur que l on souhaite supprimer
     */
    @Override
    public void supprimerObservateur(Observateur o) {
        int i = this.observateurs.indexOf(o);
        if (i >= 0) {
            this.observateurs.remove(i);
        }
    }

    /**
     * methode notifierObservateur de la classe Tableau
     */
    @Override
    public void notifierObservateurs() {
        for (int i = 0; i < this.observateurs.size(); i++) {
            Observateur observer = this.observateurs.get(i);
            observer.actualiser(this);
        }
    }

    /**
     * methode toString de la classe Tableau
     * @return le mode d affiche pour les objets de types Tableau
     */
    public String toString(){
        String res = this.nomTableau + " :\n";
        for (Colonne c : this.getListeColonnes()){
            res += "+" + c.toString() + "\n";
        }
        return res;
    }

    public VueTache getVueTache(){
        for (Observateur o : this.observateurs){
            if (o instanceof VueTache){
                return (VueTache) o;
            }
        }
        return null;
    }

    public ArrayList<Tache> getListeTachesArchives() {
        return this.archive.getListeTachesArchivees();
    }
}
