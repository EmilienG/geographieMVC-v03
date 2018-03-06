
package obj;

import java.util.List;


public class CoupDeCoeur {
    private int IDCoupDeCoeur;
    private int IDCompteCoupDeCoeur;
    private String nomCoupDeCoeur;
    private String descriptionCoupDeCoeur;
    private int IDStatutCoupDeCoeur;
    private String dateStatutCoupDeCoeur;
    private String titreLivre;
    private String ISBNLivre;
    private List<String> categories;

    public CoupDeCoeur(List<String> categories) {
        this.categories = categories;
    }

  

    public CoupDeCoeur(int IDCoupDeCoeur, int IDCompteCoupDeCoeur, String nomCoupDeCoeur, String descriptionCoupDeCoeur, int IDStatutCoupDeCoeur, String dateStatutCoupDeCoeur, String titreLivre, String ISBNLivre) {
        this.IDCoupDeCoeur = IDCoupDeCoeur;
        this.IDCompteCoupDeCoeur = IDCompteCoupDeCoeur;
        this.nomCoupDeCoeur = nomCoupDeCoeur;
        this.descriptionCoupDeCoeur = descriptionCoupDeCoeur;
        this.IDStatutCoupDeCoeur = IDStatutCoupDeCoeur;
        this.dateStatutCoupDeCoeur = dateStatutCoupDeCoeur;
        this.titreLivre = titreLivre;
        this.ISBNLivre = ISBNLivre;
    }

    public int getIDCoupDeCoeur() {
        return IDCoupDeCoeur;
    }

    public void setIDCoupDeCoeur(int IDCoupDeCoeur) {
        this.IDCoupDeCoeur = IDCoupDeCoeur;
    }

    public int getIDCompteCoupDeCoeur() {
        return IDCompteCoupDeCoeur;
    }

    public void setIDCompteCoupDeCoeur(int IDCompteCoupDeCoeur) {
        this.IDCompteCoupDeCoeur = IDCompteCoupDeCoeur;
    }

    public String getNomCoupDeCoeur() {
        return nomCoupDeCoeur;
    }

    public void setNomCoupDeCoeur(String nomCoupDeCoeur) {
        this.nomCoupDeCoeur = nomCoupDeCoeur;
    }

    public String getDescriptionCoupDeCoeur() {
        return descriptionCoupDeCoeur;
    }

    public void setDescriptionCoupDeCoeur(String descriptionCoupDeCoeur) {
        this.descriptionCoupDeCoeur = descriptionCoupDeCoeur;
    }

    public int getIDStatutCoupDeCoeur() {
        return IDStatutCoupDeCoeur;
    }

    public void setIDStatutCoupDeCoeur(int IDStatutCoupDeCoeur) {
        this.IDStatutCoupDeCoeur = IDStatutCoupDeCoeur;
    }

    public String getDateStatutCoupDeCoeur() {
        return dateStatutCoupDeCoeur;
    }

    public void setDateStatutCoupDeCoeur(String dateStatutCoupDeCoeur) {
        this.dateStatutCoupDeCoeur = dateStatutCoupDeCoeur;
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

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
    

    @Override
    public String toString() {
        return "CoupDeCoeur{" + "IDCoupDeCoeur=" + IDCoupDeCoeur + ", IDCompteCoupDeCoeur=" + IDCompteCoupDeCoeur + ", nomCoupDeCoeur=" + nomCoupDeCoeur + ", descriptionCoupDeCoeur=" + descriptionCoupDeCoeur + ", IDStatutCoupDeCoeur=" + IDStatutCoupDeCoeur + ", dateStatutCoupDeCoeur=" + dateStatutCoupDeCoeur + ", titreLivre=" + titreLivre + ", ISBNLivre=" + ISBNLivre + '}';
    }
    
    
    
}
