
package obj;

public class Client {
    private String pseudo;
    private String MDP;
    private String email;
    private String nom;

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
    
    
}
