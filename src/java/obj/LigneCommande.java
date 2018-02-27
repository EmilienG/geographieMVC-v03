
package obj;

import java.io.Serializable;
import java.util.Date;


public class LigneCommande implements Serializable {
    
    private String IDLigneCommande;
    private String IDCommandeLigneCommande;
    private String IDLivreLigneCommande;
    private String quantiteLigneCommande;
    private float TVALigneCommande;
    private float prixHTLivreLigneCommande;
    private float valeurPromoLigneCommande;
    private String IDStatutLigneCommande;
    private Date dateStatutLigneCommande;   

    public LigneCommande() {
    }

    public LigneCommande(String IDLigneCommande, String IDCommandeLigneCommande, String IDLivreLigneCommande, String quantiteLigneCommande, float TVALigneCommande, float prixHTLivreLigneCommande, float valeurPromoLigneCommande, String IDStatutLigneCommande, Date dateStatutLigneCommande) {
        this.IDLigneCommande = IDLigneCommande;
        this.IDCommandeLigneCommande = IDCommandeLigneCommande;
        this.IDLivreLigneCommande = IDLivreLigneCommande;
        this.quantiteLigneCommande = quantiteLigneCommande;
        this.TVALigneCommande = TVALigneCommande;
        this.prixHTLivreLigneCommande = prixHTLivreLigneCommande;
        this.valeurPromoLigneCommande = valeurPromoLigneCommande;
        this.IDStatutLigneCommande = IDStatutLigneCommande;
        this.dateStatutLigneCommande = dateStatutLigneCommande;
    }

    public String getIDLigneCommande() {
        return IDLigneCommande;
    }

    public void setIDLigneCommande(String IDLigneCommande) {
        this.IDLigneCommande = IDLigneCommande;
    }

    public String getIDCommandeLigneCommande() {
        return IDCommandeLigneCommande;
    }

    public void setIDCommandeLigneCommande(String IDCommandeLigneCommande) {
        this.IDCommandeLigneCommande = IDCommandeLigneCommande;
    }

    public String getIDLivreLigneCommande() {
        return IDLivreLigneCommande;
    }

    public void setIDLivreLigneCommande(String IDLivreLigneCommande) {
        this.IDLivreLigneCommande = IDLivreLigneCommande;
    }

    public String getQuantiteLigneCommande() {
        return quantiteLigneCommande;
    }

    public void setQuantiteLigneCommande(String quantiteLigneCommande) {
        this.quantiteLigneCommande = quantiteLigneCommande;
    }

    public float getTVALigneCommande() {
        return TVALigneCommande;
    }

    public void setTVALigneCommande(float TVALigneCommande) {
        this.TVALigneCommande = TVALigneCommande;
    }

    public float getPrixHTLivreLigneCommande() {
        return prixHTLivreLigneCommande;
    }

    public void setPrixHTLivreLigneCommande(float prixHTLivreLigneCommande) {
        this.prixHTLivreLigneCommande = prixHTLivreLigneCommande;
    }

    public float getValeurPromoLigneCommande() {
        return valeurPromoLigneCommande;
    }

    public void setValeurPromoLigneCommande(float valeurPromoLigneCommande) {
        this.valeurPromoLigneCommande = valeurPromoLigneCommande;
    }

    public String getIDStatutLigneCommande() {
        return IDStatutLigneCommande;
    }

    public void setIDStatutLigneCommande(String IDStatutLigneCommande) {
        this.IDStatutLigneCommande = IDStatutLigneCommande;
    }

    public Date getDateStatutLigneCommande() {
        return dateStatutLigneCommande;
    }

    public void setDateStatutLigneCommande(Date dateStatutLigneCommande) {
        this.dateStatutLigneCommande = dateStatutLigneCommande;
    }

    @Override
    public String toString() {
        return "LigneCommande : " + "IDLigneCommande=" + IDLigneCommande + ", IDCommandeLigneCommande=" + IDCommandeLigneCommande + ", IDLivreLigneCommande=" + IDLivreLigneCommande + ", quantiteLigneCommande=" + quantiteLigneCommande + ", TVALigneCommande=" + TVALigneCommande + ", prixHTLivreLigneCommande=" + prixHTLivreLigneCommande + ", valeurPromoLigneCommande=" + valeurPromoLigneCommande + ", IDStatutLigneCommande=" + IDStatutLigneCommande + ", dateStatutLigneCommande=" + dateStatutLigneCommande;
    }
    
    
}
