
package obj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Evenement implements Serializable{
    int IDEvenement;
    String dateDebutEvenement;
    String dateFinEvenement;
    String nomEvenement;
    String typeEvenement;
    String descriptionEvenement;
    String commentaireEvenement;
    int IDStatutEvenement;
    String dateStatutEvenement;
    String titreLivre;
    String ISBNLivre ;
    private List<String> titresLivres;
    private String titreClean;

    public Evenement() {
        titresLivres = new ArrayList<>();
        
    }

   

    

    public Evenement(int IDEvenement,String nomEvenement, String typeEvenement, String descriptionEvenement, String commentaireEvenement,String titreLivre, String ISBNLivre) {
        this();
        this.IDEvenement = IDEvenement;
        this.nomEvenement = nomEvenement;
        this.typeEvenement = typeEvenement;
        this.descriptionEvenement = descriptionEvenement;
        this.commentaireEvenement = commentaireEvenement;
        this.titreLivre = titreLivre;
        this.ISBNLivre = ISBNLivre;
    }
    

    public int getIDEvenement() {
        return IDEvenement;
    }

    public void setIDEvenement(int IDEvenement) {
        this.IDEvenement = IDEvenement;
    }

    public String getDateDebutEvenement() {
        return dateDebutEvenement;
    }

    public void setDateDebutEvenement(String dateDebutEvenement) {
        this.dateDebutEvenement = dateDebutEvenement;
    }

    public String getDateFinEvenement() {
        return dateFinEvenement;
    }

    public void setDateFinEvenement(String dateFinEvenement) {
        this.dateFinEvenement = dateFinEvenement;
    }

    public String getNomEvenement() {
        return nomEvenement;
    }

    public void setNomEvenement(String nomEvenement) {
        this.nomEvenement = nomEvenement;
    }

    public String getTypeEvenement() {
        return typeEvenement;
    }

    public void setTypeEvenement(String typeEvenement) {
        this.typeEvenement = typeEvenement;
    }

    public String getDescriptionEvenement() {
        return descriptionEvenement;
    }

    public void setDescriptionEvenement(String descriptionEvenement) {
        this.descriptionEvenement = descriptionEvenement;
    }

    public String getCommentaireEvenement() {
        return commentaireEvenement;
    }

    public void setCommentaireEvenement(String commentaireEvenement) {
        this.commentaireEvenement = commentaireEvenement;
    }

    public int getIDStatutEvenement() {
        return IDStatutEvenement;
    }

    public void setIDStatutEvenement(int IDStatutEvenement) {
        this.IDStatutEvenement = IDStatutEvenement;
    }

    public String getDateStatutEvenement() {
        return dateStatutEvenement;
    }

    public void setDateStatutEvenement(String dateStatutEvenement) {
        this.dateStatutEvenement = dateStatutEvenement;
    }

    public String getTitreLivre() {
        return titreLivre;
    }

    public void setTitreLivre(String titreLivre) {
        this.titreLivre = titreLivre;
    }

    public String getISBNLivre() {
        return ISBNLivre;
    }

    public void setISBNLivre(String ISBNLivre) {
        this.ISBNLivre = ISBNLivre;
        
    }

    public List<String> getTitresLivres() {
        return titresLivres;
    }

    public void setTitresLivres(List<String> titresLivres) {
        this.titresLivres = titresLivres;
    }
    
    
        public String getTitreClean() {
        String s = null;
        for (int i = 0; i < titresLivres.size(); i++) {
            if (s == null) {
                s = titresLivres.get(i);
            } else {
                s = s + ", " + titresLivres.get(i);
            }
        }
        return s;
    }

    public void setTitreClean(String titreClean) {
//     this.tameme;
    }
    

    @Override
    public String toString() {
        return  " L'Evenement : "+ nomEvenement + " Debute le : " + dateDebutEvenement + " Et se finit le " + dateFinEvenement +
                " type : " + typeEvenement + " description : " + descriptionEvenement +
                " commentaire : " + commentaireEvenement
                 + "   " + dateStatutEvenement + " Le livre concerné est : " + titreLivre + " ISBN numéro : " + ISBNLivre; 
    }

    
    
    
            
    
}
