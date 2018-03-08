
package obj;

import java.util.ArrayList;
import java.util.Date;

public class Client {
    private String pseudo;
    private String MDP;
    private String email;
    private String nom;
    private String prenom;
    private String id;
    private String idPermission;
    private String idstatut;
    private String telephone;
    private String commentaire;
    private Date dateCreation;
    private Date dateDestruction;
    private ArrayList<String> adresses;
    private String IDAdresse;
    private String nomVoieAdresse;

    public Client() {
        adresses = new ArrayList<>();
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMDP() {
        return MDP;
    }

    public void setMDP(String MDP) {
        this.MDP = MDP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(String idPermission) {
        this.idPermission = idPermission;
    }

    public String getIdstatut() {
        return idstatut;
    }

    public void setIdstatut(String idstatut) {
        this.idstatut = idstatut;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateDestruction() {
        return dateDestruction;
    }

    public void setDateDestruction(Date dateDestruction) {
        this.dateDestruction = dateDestruction;
    }

    public ArrayList<String> getAdresses() {
        return adresses;
    }

    public void setAdresses(ArrayList<String> adresses) {
        this.adresses = adresses;
    }

    public String getIDAdresse() {
        return IDAdresse;
    }

    public void setIDAdresse(String IDAdresse) {
        this.IDAdresse = IDAdresse;
    }

    public String getNomVoieAdresse() {
        return nomVoieAdresse;
    }

    public void setNomVoieAdresse(String nomVoieAdresse) {
        this.nomVoieAdresse = nomVoieAdresse;
    }
    
}
