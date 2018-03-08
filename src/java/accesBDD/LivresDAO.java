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
    
    public ArrayList<Livres> selectLivrePagin(boolean atif, String saisie, int debut, int pas) throws SQLException {
        ArrayList<Livres> mesLivres = new ArrayList<>();
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();
        PreparedStatement pstm = null;
        String req = "SELECT * FROM ( "
                + "  SELECT *, ROW_NUMBER() OVER (ORDER BY IDLivre) as row FROM VueEmilien"
                + " ) a WHERE a.row > " + debut + " and a.row <= " + pas;
        String req2 = null;
        
        if (atif) {
            req2 = "SELECT * FROM ( "
                    + "  SELECT *, ROW_NUMBER() OVER (ORDER BY IDLivre) as row FROM VueEmilien"
                    + " ) a WHERE a.row > " + debut + " and a.row <= " + pas + " and titreLivre like ? or nomAuteur like ? or prenomAuteur like ? or"
                    + " sousTitreLivre like ? or nomEditeur like ? or nomEdition like ? or"
                    + " nomGenreAuteur like ?";
            System.out.println(req2);
            pstm = cnt.prepareStatement(req2);
            if (saisie != null) {
//                System.out.println(saisie);
                pstm.setString(1, "%" + saisie + "%");
                pstm.setString(2, "%" + saisie + "%");
                pstm.setString(3, "%" + saisie + "%");
                pstm.setString(4, "%" + saisie + "%");
                pstm.setString(5, "%" + saisie + "%");
                pstm.setString(6, "%" + saisie + "%");
                pstm.setString(7, "%" + saisie + "%");
            }
        }
        try {
            ResultSet rs = null;
            if (atif) {
                rs = pstm.executeQuery();
            } else {
                rs = stm.executeQuery(req);
            }
            while (rs.next()) {
                Livres monLivre = new Livres();
                monLivre.setIDLivre(rs.getString("IDLivre"));
                monLivre.setTitreLivre(rs.getString("titreLivre"));
                monLivre.setSousTitreLivre(rs.getString("sousTitreLivre"));
                monLivre.setISBNlivre(rs.getString("ISBNLivre"));
                monLivre.setSousTitreLivre(rs.getString("sousTitreLivre"));
                monLivre.setDateParutionLivre(rs.getString("dateParutionLivre"));
                monLivre.setCouvertureLivre(rs.getString("couvertureLivre"));
                monLivre.setPrixHTLivre(rs.getFloat("prixHTLivre"));
                monLivre.setQuantiteStockLivre(rs.getInt("quantiteStockLivre"));
                monLivre.setResumeLivre(rs.getString("resumeLivre"));
                monLivre.setDescriptionMotClef(rs.getString("descriptionMotClef"));
                monLivre.setNomEditeur(rs.getString("nomEditeur"));
                monLivre.setPrenomAuteur(rs.getString("prenomAuteur"));
                monLivre.setNomAuteur(rs.getString("nomAuteur"));
                monLivre.setGabariLivre(rs.getString("gabariLivre"));
                monLivre.setNBPageLivre(rs.getInt("NBPageLivre"));
                monLivre.setPoidsLivre(rs.getInt("poidsLivre"));
                

               
                
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
    
    public ArrayList<Livres> selectAllLivre(boolean atif, String saisie) throws SQLException {
        ArrayList<Livres> mesLivres = new ArrayList<>();
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();
        PreparedStatement pstm = null;
        String req = "select * from VueEmilien";
        String req2 = null;
        if (atif) {
            req2 = "select * from VueEmilien where titreLivre like ? or nomAuteur like ? or prenomAuteur like ? or"
                    + " sousTitreLivre like ? or nomEditeur like ? or nomEdition like ? or"
                    + " nomGenreAuteur like ? ";
//            System.out.println(req2);
            pstm = cnt.prepareStatement(req2);
            if (saisie != null) {
//                System.out.println(saisie);
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
            ResultSet rs = null;
            if (atif) {
                rs = pstm.executeQuery();
            } else {
                rs = stm.executeQuery(req);
            }
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

    //Mettre PREPARE STATEMENT !!!!!
    public Livres getUnLivreByID(String IDLivre) throws SQLException {
        Livres monLivre = new Livres();
        String req = "select * from vueEmilien WHERE IDLivre = " + IDLivre;
//        System.out.println(req);
        try (Connection cnt = mc.getConnection();
                Statement stm = cnt.createStatement();
                ResultSet rs = stm.executeQuery(req);) {
            while (rs.next()) {
               monLivre.setIDLivre(rs.getString("IDLivre"));
                monLivre.setTitreLivre(rs.getString("titreLivre"));
                monLivre.setSousTitreLivre(rs.getString("sousTitreLivre"));
                monLivre.setISBNlivre(rs.getString("ISBNLivre"));
                monLivre.setSousTitreLivre(rs.getString("sousTitreLivre"));
                monLivre.setDateParutionLivre(rs.getString("dateParutionLivre"));
                monLivre.setCouvertureLivre(rs.getString("couvertureLivre"));
                monLivre.setPrixHTLivre(rs.getFloat("prixHTLivre"));
                monLivre.setQuantiteStockLivre(rs.getInt("quantiteStockLivre"));
                monLivre.setResumeLivre(rs.getString("resumeLivre"));
                monLivre.setDescriptionMotClef(rs.getString("descriptionMotClef"));
                monLivre.setNomEditeur(rs.getString("nomEditeur"));
                monLivre.setPrenomAuteur(rs.getString("prenomAuteur"));
                monLivre.setNomAuteur(rs.getString("nomAuteur"));
                monLivre.setGabariLivre(rs.getString("gabariLivre"));
                monLivre.setNBPageLivre(rs.getInt("NBPageLivre"));
                monLivre.setPoidsLivre(rs.getInt("poidsLivre"));
            }
        }
        return monLivre;
    }
}
