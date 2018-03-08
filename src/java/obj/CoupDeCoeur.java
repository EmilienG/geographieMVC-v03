package obj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CoupDeCoeur implements Serializable {

    private int IDCoupDeCoeur;
    private int IDCompteCoupDeCoeur;
    private String nomCoupDeCoeur;
    private String descriptionCoupDeCoeur;
    private int IDStatutCoupDeCoeur;
    private String dateStatutCoupDeCoeur;
    private String titreLivre;
    private String ISBNLivre;
    private List<String> titresLivres;
    private String titreClean;
    private String IDLivre;

    public CoupDeCoeur() {
        titresLivres = new ArrayList<>();
    }

    public CoupDeCoeur(int IDCoupDeCoeur, String nomCoupDeCoeur, String descriptionCoupDeCoeur, String titreLivre, String ISBNLivre,String IDLivre) {
        this();
        this.IDCoupDeCoeur = IDCoupDeCoeur;
        this.nomCoupDeCoeur = nomCoupDeCoeur;
        this.descriptionCoupDeCoeur = descriptionCoupDeCoeur;
        this.titreLivre = titreLivre;
        this.ISBNLivre = ISBNLivre;
        this.IDLivre = IDLivre;
    }

    public String getIDLivre() {
        return IDLivre;
    }

    public void setIDLivre(String IDLivre) {
        this.IDLivre = IDLivre;
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
                s = "<a href=ControllerMain?section=details&IDLivre="+this.IDLivre+">"+titresLivres.get(i)+"</a>";
            } else {
                s = s + ", " + "<a href=ControllerMain?section=details&IDLivre="+this.IDLivre+">"+titresLivres.get(i)+"</a>";
            }
        }
        return s;
    }

    public void setTitreClean(String titreClean) {
//     this.tameme;
    }

    @Override
    public String toString() {
        return "CoupDeCoeur{" + "IDCoupDeCoeur=" + IDCoupDeCoeur + ", IDCompteCoupDeCoeur=" + IDCompteCoupDeCoeur + ", nomCoupDeCoeur=" + nomCoupDeCoeur + ", descriptionCoupDeCoeur=" + descriptionCoupDeCoeur + ", IDStatutCoupDeCoeur=" + IDStatutCoupDeCoeur + ", dateStatutCoupDeCoeur=" + dateStatutCoupDeCoeur + ", titreLivre=" + titreLivre + ", ISBNLivre=" + ISBNLivre + '}';
    }

}
