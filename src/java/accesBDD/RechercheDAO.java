package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import obj.Livres;

public class RechercheDAO implements Serializable {

    private MaConnexion mc;

    public RechercheDAO(MaConnexion mc) throws NamingException {
        mc = new MaConnexion();
    }

    public ArrayList<Livres> recherche() throws SQLException {
        ArrayList<Livres> mesResultats = new ArrayList<>();
        String req = "select prenomAuteur,nomAuteur,titreLivre,sousTitreLivre,nomEditeur,nomEdition, nomGenreAuteur"
                + " from Editeur "
                + " join Livre on IDEditeur=IDEditeurLivre"
                + "  join Ecriture on  IDLivre=IDLivreEcriture"
                + "  join Auteur on IDAuteur=IDAuteurEcriture "
                + "  join Documentation on IDAuteur = IDAuteurDocumentation"
                + "  join GenreAuteur on IDGenreAuteur=IDGenreAuteurDocumentation"
                + " where titreLivre like '%?%'or nomAuteur like '%?%'or prenomAuteur like '%?%'or"
                + " sousTitreLivre like '%?%'or nomEditeur like '%?%'or nomEdition like '%?%'or"
                + " nomGenreAuteur like '%?%'";
        Connection cnt = mc.getConnection();
        PreparedStatement stm = cnt.prepareStatement(req);
        HttpServletRequest request = null;
        Livres maRecherche = null;
        try {
            System.out.println("avant le if doit");
            if (request.getParameter("doIt") != null) {
                
                String saisie = request.getParameter("doIt");
                System.out.println(saisie);
                System.out.println(saisie);
                stm.setString(1, saisie);
                stm.setString(2, saisie);
                stm.setString(3, saisie);
                stm.setString(4, saisie);
                stm.setString(5, saisie);
                stm.setString(6, saisie);
                stm.setString(7, saisie);

            }
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    maRecherche = new Livres();
                    String prenom = rs.getString("prenomAuteur");
                    maRecherche.setPrenomAuteur(prenom);
                    String nom = rs.getString("nomAuteur");
                    maRecherche.setNomAuteur(nom);
                    String titre = rs.getString("titreLivre");
                    maRecherche.setTitreLivre(titre);
                    String sousTitre = rs.getString("sousTitreLivre");
                    maRecherche.setSousTitreLivre(sousTitre);
                    String editeur = rs.getString("nomEditeur");
                    maRecherche.setNomEditeur(editeur);
                    String edition = rs.getString("nomEdition");
                    maRecherche.setNomEdition(edition);
                    String genre = rs.getString("nomGenreAuteur");
                    maRecherche.setNomGenreAuteur(editeur);
                    
                    mesResultats.add(maRecherche);
                }
            }

        } finally {
            if (cnt != null) {
                cnt.close();
            }
        }
        return mesResultats;
    }
}
