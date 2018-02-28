
package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import obj.Livres;

public class RechercheDAO implements Serializable{
    private MaConnexion mc;

    public RechercheDAO(MaConnexion mc) throws NamingException {
        mc = new MaConnexion();
    }
    
      public Livres recherche() throws SQLException {
        String req = "select prenomAuteur,nomAuteur,titreLivre,sousTitreLivre,nomEditeur,nomEdition, nomGenre\n" +
" from Editeur \n" +
" join Livre on IDEditeur=IDEditeurLivre\n" +
"  join Ecriture on  IDLivre=IDLivreEcriture\n" +
"  join Auteur on IDAuteur=IDAuteurEcriture \n" +
"  join description on IDLivre=IDLivreDescription\n" +
"  join genre on IDGenre=IDGenreDescription\n" +
"where titreLivre like '%?%'or nomAuteur like '%?%'or prenomAuteur like '%?%'or\n" +
"sousTitreLivre like '%?%'or nomEditeur like '%?%'or nomEdition like '%?%'or\n" +
"nomGenre like '%?%'";
        HttpServletRequest request=null;
        Livres l = null;
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            stm.setString(1, request.getParameter("doIt"));
            stm.setString(2, request.getParameter("doIt"));
            stm.setString(3, request.getParameter("doIt"));
            stm.setString(4, request.getParameter("doIt"));
            stm.setString(5, request.getParameter("doIt"));
            stm.setString(6, request.getParameter("doIt"));
            stm.setString(7, request.getParameter("doIt"));
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                l = new Livres();
                String prenom = rs.getString("prenomAuteur");
                l.setPrenomAuteur(prenom);
                String nom = rs.getString("nomAuteur");
                l.setNomAuteur(nom);
                String titre = rs.getString("titreLivre");
                l.setTitreLivre(titre);
                String sousTitre = rs.getString("sousTitreLivre");
                l.setSousTitreLivre(sousTitre);
                String editeur = rs.getString("nomEditeur");
                l.setNomEditeur(editeur);
                String edition = rs.getString("nomEdition");
                l.setNomEdition(edition);
                String genre = rs.getString("nomGenre");
                l.setNomGenreAuteur(editeur);
            }
        }
        return l;
    }
}
