
package obj;

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

    public Client() {
    }
    
    public String getPseudo() {
        return pseudo;
    }

    public String getMDP() {
        return MDP;
    }

    public String getEmail() {
        return email;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setMDP(String MDP) {
        this.MDP = MDP;
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

    public String getId() {
        return id;
    }

    public String getIdPermission() {
        return idPermission;
    }

    public String getIdstatut() {
        return idstatut;
    }

    public String getTelephone() {
        return telephone;
    }
    
    public String getCommentaire() {
        return commentaire;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public Date getDateDestruction() {
        return dateDestruction;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdPermission(String idPermission) {
        this.idPermission = idPermission;
    }

    public void setIdstatut(String idstatut) {
        this.idstatut = idstatut;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setDateDestruction(Date dateDestruction) {
        this.dateDestruction = dateDestruction;
    }
    
    
}
