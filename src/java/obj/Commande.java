
package obj;

import java.io.Serializable;
import java.util.Date;


public class Commande implements Serializable {
    
    private String IDCommande;
    private String IDAdresseFacturationCommande;
    private String IDAdresseLivraisonCommande;
    private String IDCompteCommande;
    private String IDLivreurCommande;
    private String IDOrganismePaiementCommande;
    private Date dateCommande;
    private String adresseIPCommande;
    private String commentaireCommande;
    private String IDStatutCommande;
    private float tarifLivraisonCommande;
    private String modeLivraisonCommande;
    private String IDLivraisonCommande;
    private String IDStatutLivraisonCommande;
    private float montantCommande;
    private String modeReglementCommande;
    private String numTransactionReglementCommande;
    private Date dateExpeditionCommande;
    private String IDStatutReglementCommande;
    private Date dateStatutCommande;

    public Commande() {
    }

    public Commande(String IDCommande, String IDAdresseFacturationCommande, String IDAdresseLivraisonCommande, String IDCompteCommande, String IDLivreurCommande, String IDOrganismePaiementCommande, Date dateCommande, String adresseIPCommande, String commentaireCommande, String IDStatutCommande, float tarifLivraisonCommande, String modeLivraisonCommande, String IDLivraisonCommande, String IDStatutLivraisonCommande, float montantCommande, String modeReglementCommande, String numTransactionReglementCommande, Date dateExpeditionCommande, String IDStatutReglementCommande, Date dateStatutCommande) {
        this.IDCommande = IDCommande;
        this.IDAdresseFacturationCommande = IDAdresseFacturationCommande;
        this.IDAdresseLivraisonCommande = IDAdresseLivraisonCommande;
        this.IDCompteCommande = IDCompteCommande;
        this.IDLivreurCommande = IDLivreurCommande;
        this.IDOrganismePaiementCommande = IDOrganismePaiementCommande;
        this.dateCommande = dateCommande;
        this.adresseIPCommande = adresseIPCommande;
        this.commentaireCommande = commentaireCommande;
        this.IDStatutCommande = IDStatutCommande;
        this.tarifLivraisonCommande = tarifLivraisonCommande;
        this.modeLivraisonCommande = modeLivraisonCommande;
        this.IDLivraisonCommande = IDLivraisonCommande;
        this.IDStatutLivraisonCommande = IDStatutLivraisonCommande;
        this.montantCommande = montantCommande;
        this.modeReglementCommande = modeReglementCommande;
        this.numTransactionReglementCommande = numTransactionReglementCommande;
        this.dateExpeditionCommande = dateExpeditionCommande;
        this.IDStatutReglementCommande = IDStatutReglementCommande;
        this.dateStatutCommande = dateStatutCommande;
    }

    public Commande(String IDCommande, String IDCompteCommande, Date dateCommande, String IDStatutCommande, float montantCommande) {
        this.IDCommande = IDCommande;
        this.IDCompteCommande = IDCompteCommande;
        this.dateCommande = dateCommande;
        this.IDStatutCommande = IDStatutCommande;
        this.montantCommande = montantCommande;
    }
    
    

    public String getIDCommande() {
        return IDCommande;
    }

    public void setIDCommande(String IDCommande) {
        this.IDCommande = IDCommande;
    }

    public String getIDAdresseFacturationCommande() {
        return IDAdresseFacturationCommande;
    }

    public void setIDAdresseFacturationCommande(String IDAdresseFacturationCommande) {
        this.IDAdresseFacturationCommande = IDAdresseFacturationCommande;
    }

    public String getIDAdresseLivraisonCommande() {
        return IDAdresseLivraisonCommande;
    }

    public void setIDAdresseLivraisonCommande(String IDAdresseLivraisonCommande) {
        this.IDAdresseLivraisonCommande = IDAdresseLivraisonCommande;
    }

    public String getIDCompteCommande() {
        return IDCompteCommande;
    }

    public void setIDCompteCommande(String IDCompteCommande) {
        this.IDCompteCommande = IDCompteCommande;
    }

    public String getIDLivreurCommande() {
        return IDLivreurCommande;
    }

    public void setIDLivreurCommande(String IDLivreurCommande) {
        this.IDLivreurCommande = IDLivreurCommande;
    }

    public String getIDOrganismePaiementCommande() {
        return IDOrganismePaiementCommande;
    }

    public void setIDOrganismePaiementCommande(String IDOrganismePaiementCommande) {
        this.IDOrganismePaiementCommande = IDOrganismePaiementCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getAdresseIPCommande() {
        return adresseIPCommande;
    }

    public void setAdresseIPCommande(String adresseIPCommande) {
        this.adresseIPCommande = adresseIPCommande;
    }

    public String getCommentaireCommande() {
        return commentaireCommande;
    }

    public void setCommentaireCommande(String commentaireCommande) {
        this.commentaireCommande = commentaireCommande;
    }

    public String getIDStatutCommande() {
        return IDStatutCommande;
    }

    public void setIDStatutCommande(String IDStatutCommande) {
        this.IDStatutCommande = IDStatutCommande;
    }

    public float getTarifLivraisonCommande() {
        return tarifLivraisonCommande;
    }

    public void setTarifLivraisonCommande(float tarifLivraisonCommande) {
        this.tarifLivraisonCommande = tarifLivraisonCommande;
    }

    public String getModeLivraisonCommande() {
        return modeLivraisonCommande;
    }

    public void setModeLivraisonCommande(String modeLivraisonCommande) {
        this.modeLivraisonCommande = modeLivraisonCommande;
    }

    public String getIDLivraisonCommande() {
        return IDLivraisonCommande;
    }

    public void setIDLivraisonCommande(String IDLivraisonCommande) {
        this.IDLivraisonCommande = IDLivraisonCommande;
    }

    public String getIDStatutLivraisonCommande() {
        return IDStatutLivraisonCommande;
    }

    public void setIDStatutLivraisonCommande(String IDStatutLivraisonCommande) {
        this.IDStatutLivraisonCommande = IDStatutLivraisonCommande;
    }

    public float getMontantCommande() {
        return montantCommande;
    }

    public void setMontantCommande(float montantCommande) {
        this.montantCommande = montantCommande;
    }

    public String getModeReglementCommande() {
        return modeReglementCommande;
    }

    public void setModeReglementCommande(String modeReglementCommande) {
        this.modeReglementCommande = modeReglementCommande;
    }

    public String getNumTransactionReglementCommande() {
        return numTransactionReglementCommande;
    }

    public void setNumTransactionReglementCommande(String numTransactionReglementCommande) {
        this.numTransactionReglementCommande = numTransactionReglementCommande;
    }

    public Date getDateExpeditionCommande() {
        return dateExpeditionCommande;
    }

    public void setDateExpeditionCommande(Date dateExpeditionCommande) {
        this.dateExpeditionCommande = dateExpeditionCommande;
    }

    public String getIDStatutReglementCommande() {
        return IDStatutReglementCommande;
    }

    public void setIDStatutReglementCommande(String IDStatutReglementCommande) {
        this.IDStatutReglementCommande = IDStatutReglementCommande;
    }

    public Date getDateStatutCommande() {
        return dateStatutCommande;
    }

    public void setDateStatutCommande(Date dateStatutCommande) {
        this.dateStatutCommande = dateStatutCommande;
    }

    @Override
    public String toString() {
        return "Vos Commandes : \n" + "N° Commande" + IDCommande + ", IDAdresseFacturationCommande=" + IDAdresseFacturationCommande + ", IDAdresseLivraisonCommande=" + IDAdresseLivraisonCommande + ", IDCompteCommande=" + IDCompteCommande + ", IDLivreurCommande=" + IDLivreurCommande + ", IDOrganismePaiementCommande=" + IDOrganismePaiementCommande + " Date d'achat : " + dateCommande + " Commentaires : " + commentaireCommande + ", IDStatutCommande=" + IDStatutCommande + "Frais de livraison : " + tarifLivraisonCommande + ", modeLivraisonCommande=" + modeLivraisonCommande + ", IDLivraisonCommande=" + IDLivraisonCommande + ", IDStatutLivraisonCommande=" + IDStatutLivraisonCommande + ", montantCommande=" + montantCommande + ", modeReglementCommande=" + modeReglementCommande + ", numTransactionReglementCommande=" + numTransactionReglementCommande + ", dateExpeditionCommande=" + dateExpeditionCommande + ", IDStatutReglementCommande=" + IDStatutReglementCommande + ", dateStatutCommande=" + dateStatutCommande;
    }
    
   
    
    
}
