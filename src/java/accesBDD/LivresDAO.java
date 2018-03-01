package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.NamingException;
import obj.Livres;

public class LivresDAO implements Serializable {

    private MaConnexion mc;

    public LivresDAO() throws NamingException {
        mc = new MaConnexion();
    }

    public ArrayList<Livres> selectAllLivre(boolean atif, String saisie) throws SQLException {
        ArrayList<Livres> mesLivres = new ArrayList<>();
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();
        String req = "select * from VueEmilien";
        String req2 = null;
        if (atif) {
            req2 = "select * from VueEmilien where titreLivre like ? or nomAuteur like ? or prenomAuteur like ? or"
                    + " sousTitreLivre like ? or nomEditeur like ? or nomEdition like ? or"
                    + " nomGenreAuteur like ? ";
            PreparedStatement pstm = cnt.prepareStatement(req2);
            if (saisie != null) {
                System.out.println(saisie);
                pstm.setString(1, "%" + saisie + "%");
                pstm.setString(2, "%" + saisie + "%");
                pstm.setString(3, "%" + saisie + "%");
                pstm.setString(4, "%" + saisie + "%");
                pstm.setString(5, "%" + saisie + "%");
                pstm.setString(6, "%" + saisie + "%");
                pstm.setString(7, "%" + saisie + "%");
            }
        }
        String RStitreLivre = null;
        String RSSousTitreLivre = null;
        String RSISBNLivre = null;
        String RSDateParution = null;
        String RSCouverture = null;
        float RSPrix = 0;
        int RSQuantite = 0;
        String RSResume = null;
        String RSMotCle = null;

        try {
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                Livres monLivre = new Livres();
                RStitreLivre = rs.getString("titreLivre");
                monLivre.setTitreLivre(RStitreLivre);
                RSSousTitreLivre = rs.getString("sousTitreLivre");
                monLivre.setSousTitreLivre(RSSousTitreLivre);
                RSISBNLivre = rs.getString("ISBNLivre");
                monLivre.setISBNlivre(RSISBNLivre);
                monLivre.setSousTitreLivre(RSSousTitreLivre);
                RSDateParution = rs.getString("dateParutionLivre");
                monLivre.setDateParutionLivre(RSDateParution);
                monLivre.setSousTitreLivre(RSSousTitreLivre);
                RSCouverture = rs.getString("couvertureLivre");
                monLivre.setCouvertureLivre(RSCouverture);
                RSPrix = rs.getFloat("prixHTLivre");
                monLivre.setPrixHTLivre(RSPrix);
                RSQuantite = rs.getInt("quantiteStockLivre");
                monLivre.setQuantiteStockLivre(RSQuantite);
                monLivre.setPrixHTLivre(RSPrix);
                RSResume = rs.getString("resumeLivre");
                monLivre.setResumeLivre(RSResume);
                RSMotCle = rs.getString("descriptionMotClef");
                monLivre.setDescriptionMotClef(RSMotCle);

                mesLivres.add(monLivre);
            }
            rs.close();
        } finally {
            if (cnt != null) {
                cnt.close();
            }
        }
        return mesLivres;
    }
}
