
package obj;

import java.util.Date;

public class Client {
    private String pseudo;
    private String MDP;
    private String email;
    private String nom;
    private String prenom;
    private int id;
    private int idPermission;
    private int idstatut;
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

    public int getId() {
        return id;
    }

    public int getIdPermission() {
        return idPermission;
    }

    public int getIdstatut() {
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
    
    
}
