package sn.ept.git.dic2.hello.Models;

/**
 * Created by Kalidou DIA.
 */

public class Personne {

    public Personne(String email, String clef, String prenom, String nom) {
        this.email = email;
        this.clef = clef;
        this.prenom = prenom;
        this.nom = nom;
    }

    String clef;
    String prenom;
    String nom;
    String email;
    String dateNaissance;
    String dateEnregistrement;
    String dateModification;

    public String getClef() { return clef; }

    public void setClef(String clef) {this.clef = clef;}

    public String getPrenom() {return prenom; }

    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getDateNaissance() { return dateNaissance; }

    public void setDateNaissance(String dateNaissance) { this.dateNaissance = dateNaissance; }

    public String getDateEnregistrement() { return dateEnregistrement; }

    public void setDateEnregistrement(String dateEnregistrement) { this.dateEnregistrement = dateEnregistrement; }

    public String getDateModification() { return dateModification; }

    public void setDateModification(String dateModification) { this.dateModification = dateModification; }


}
