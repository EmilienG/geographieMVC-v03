
package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import obj.Pays;

public class RechercheDAO implements Serializable{
    private MaConnexion mc;

    public RechercheDAO(MaConnexion mc) throws NamingException {
        mc = new MaConnexion();
    }
    
      public Pays selectPaysById(String a2) throws SQLException {
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
        Pays p = null;
        try (Connection cnt = mc.getConnection2();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            stm.setString(1, a2);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                String nom = rs.getString("Pays");
                a2 = rs.getString("A2");
                String a3 = rs.getString("A3");
                int number = rs.getInt("Number");
                p = new Pays(nom, a2, a3, number);
            }
        }
        return p;
    }
}
