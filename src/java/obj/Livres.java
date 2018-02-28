package obj;

import java.io.Serializable;

public class Livres implements Serializable{

    private int IDLivre;
    private String ISBNlivre;
    private String titreLivre;
    private String sousTitreLivre;
    private String nomAuteur;
    private String prenomAuteur;
    private float prixHTLivre;
    private int quantiteStockLivre;
    private String couvertureLivre;
    private String nomGenreAuteur;
    private String dateNaissanceAuteur;
    private String dateDecesAuteur;
    private String biographieAuteur;
    private String commentaireAuteur;
    private String sexeAuteur;
    private String IDAuteur;
    private int NBPageLivre;
    private int poidsLivre;
    private String gabariLivre;
    private String resumeLivre;
    private String nomEditeur;
    private String nomEdition;
    private String dateParutionLivre;
    private int IDStatutLivre;
    private String descriptionStatut;

    public Livres() {
    }

    public int getIDLivre() {
        return IDLivre;
    }

    public void setIDLivre(int IDLivre) {
        this.IDLivre = IDLivre;
    }

    public String getISBNlivre() {
        return ISBNlivre;
    }

    public void setISBNlivre(String ISBNlivre) {
        this.ISBNlivre = ISBNlivre;
    }

    public String getTitreLivre() {
        return titreLivre;
    }

    public void setTitreLivre(String titreLivre) {
        this.titreLivre = titreLivre;
    }

    public String getSousTitreLivre() {
        return sousTitreLivre;
    }

    public void setSousTitreLivre(String sousTitreLivre) {
        this.sousTitreLivre = sousTitreLivre;
    }

    public String getNomAuteur() {
        return nomAuteur;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }

    public String getPrenomAuteur() {
        return prenomAuteur;
    }

    public void setPrenomAuteur(String prenomAuteur) {
        this.prenomAuteur = prenomAuteur;
    }

    public float getPrixHTLivre() {
        return prixHTLivre;
    }

    public void setPrixHTLivre(float prixHTLivre) {
        this.prixHTLivre = prixHTLivre;
    }

    public int getQuantiteStockLivre() {
        return quantiteStockLivre;
    }

    public void setQuantiteStockLivre(int quantiteStockLivre) {
        this.quantiteStockLivre = quantiteStockLivre;
    }

    public String getCouvertureLivre() {
        return couvertureLivre;
    }

    public void setCouvertureLivre(String couvertureLivre) {
        this.couvertureLivre = couvertureLivre;
    }

    public String getNomGenreAuteur() {
        return nomGenreAuteur;
    }

    public void setNomGenreAuteur(String nomGenreAuteur) {
        this.nomGenreAuteur = nomGenreAuteur;
    }

    public String getDateNaissanceAuteur() {
        return dateNaissanceAuteur;
    }

    public void setDateNaissanceAuteur(String dateNaissanceAuteur) {
        this.dateNaissanceAuteur = dateNaissanceAuteur;
    }

    public String getDateDecesAuteur() {
        return dateDecesAuteur;
    }

    public void setDateDecesAuteur(String dateDecesAuteur) {
        this.dateDecesAuteur = dateDecesAuteur;
    }

    public String getBiographieAuteur() {
        return biographieAuteur;
    }

    public void setBiographieAuteur(String biographieAuteur) {
        this.biographieAuteur = biographieAuteur;
    }

    public String getCommentaireAuteur() {
        return commentaireAuteur;
    }

    public void setCommentaireAuteur(String commentaireAuteur) {
        this.commentaireAuteur = commentaireAuteur;
    }

    public String getSexeAuteur() {
        return sexeAuteur;
    }

    public void setSexeAuteur(String sexeAuteur) {
        this.sexeAuteur = sexeAuteur;
    }

    public String getIDAuteur() {
        return IDAuteur;
    }

    public void setIDAuteur(String IDAuteur) {
        this.IDAuteur = IDAuteur;
    }

    public int getNBPageLivre() {
        return NBPageLivre;
    }

    public void setNBPageLivre(int NBPageLivre) {
        this.NBPageLivre = NBPageLivre;
    }

    public int getPoidsLivre() {
        return poidsLivre;
    }

    public void setPoidsLivre(int poidsLivre) {
        this.poidsLivre = poidsLivre;
    }

    public String getGabariLivre() {
        return gabariLivre;
    }

    public void setGabariLivre(String gabariLivre) {
        this.gabariLivre = gabariLivre;
    }

    public String getResumeLivre() {
        return resumeLivre;
    }

    public void setResumeLivre(String resumeLivre) {
        this.resumeLivre = resumeLivre;
    }

    public String getNomEditeur() {
        return nomEditeur;
    }

    public void setNomEditeur(String nomEditeur) {
        this.nomEditeur = nomEditeur;
    }

    public String getNomEdition() {
        return nomEdition;
    }

    public void setNomEdition(String nomEdition) {
        this.nomEdition = nomEdition;
    }

    public String getDateParutionLivre() {
        return dateParutionLivre;
    }

    public void setDateParutionLivre(String dateParutionLivre) {
        this.dateParutionLivre = dateParutionLivre;
    }

    public int getIDStatutLivre() {
        return IDStatutLivre;
    }

    public void setIDStatutLivre(int IDStatutLivre) {
        this.IDStatutLivre = IDStatutLivre;
    }

    public String getDescriptionStatut() {
        return descriptionStatut;
    }

    public void setDescriptionStatut(String descriptionStatut) {
        this.descriptionStatut = descriptionStatut;
    }

    @Override
    public String toString() {
        return "Livres{" + "IDLivre=" + IDLivre + ", ISBNlivre=" + ISBNlivre + ", titreLivre=" + titreLivre + ", sousTitreLivre=" + sousTitreLivre + ", nomAuteur=" + nomAuteur + ", prenomAuteur=" + prenomAuteur + ", prixHTLivre=" + prixHTLivre + ", quantiteStockLivre=" + quantiteStockLivre + ", couvertureLivre=" + couvertureLivre + ", nomGenreAuteur=" + nomGenreAuteur + ", dateNaissanceAuteur=" + dateNaissanceAuteur + ", dateDecesAuteur=" + dateDecesAuteur + ", biographieAuteur=" + biographieAuteur + ", commentaireAuteur=" + commentaireAuteur + ", sexeAuteur=" + sexeAuteur + ", IDAuteur=" + IDAuteur + ", NBPageLivre=" + NBPageLivre + ", poidsLivre=" + poidsLivre + ", gabariLivre=" + gabariLivre + ", resumeLivre=" + resumeLivre + ", nomEditeur=" + nomEditeur + ", nomEdition=" + nomEdition + ", dateParutionLivre=" + dateParutionLivre + ", IDStatutLivre=" + IDStatutLivre + ", descriptionStatut=" + descriptionStatut + '}';
    }



}
