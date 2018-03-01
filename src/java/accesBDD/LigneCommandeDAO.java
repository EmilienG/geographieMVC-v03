package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import obj.LigneCommande;

public class LigneCommandeDAO implements Serializable {

    private MaConnexion mc;

    public LigneCommandeDAO() throws NamingException {
        mc = new MaConnexion();
    }

    public List<LigneCommande> selectAllOrderLineByOrder() throws SQLException {
        String req = "SELECT IDLigneCommande, IDLivreLigneCommande, quantiteLigneCommande, TVALigneCommande, prixHTLivreLigneCommande, valeurPromoLigneCommande "
                + "FROM LigneCommande lc "
                + "JOIN Livre lv "
                + "ON lc.IDLivreLigneCommande = lv.IDLivre "
                + "JOIN TVA t "
                + "ON lv.IDTVALivre = t.IDTVA "
                + "WHERE IDCommandeLigneCommande = '2'";
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();
        
        System.out.println(req);

        List<LigneCommande> lcom = new ArrayList<>();
        try {
            ResultSet rs = stm.executeQuery(req);

            while (rs.next()) {
                String numLigneC = rs.getString("IDLigneCommande");
                String IDLivre = rs.getString("IDLivreLigneCommande");
                Integer  qty = rs.getInt("quantiteLigneCommande");
                Float tva = rs.getFloat("TVALigneCommande");
                Float prixHT = rs.getFloat("prixHTLivreLigneCommande");
                Float promo = rs.getFloat("valeurPromoLigneCommande");

                LigneCommande lc = new LigneCommande(numLigneC, IDLivre, qty, tva, prixHT, promo);
                lcom.add(lc);
            }
            rs.close();
        } finally {
            if (cnt != null) {
                cnt.close();
            }
        }
        return lcom;

    }
    
//    public List<LigneCommande> selectISBNBook () throws SQLException{
//        String req = "SELECT ISBNLivre, titreLivre "
//                + "FROM Livre lv "
//                + "WHERE IDLivre ='2'";
//        Connection cnt = mc.getConnection();
//        Statement stm = cnt.createStatement();
//        
//        System.out.println(req);
//
//        List<LigneCommande> lcom = new ArrayList<>();
//        try {
//            ResultSet rs = stm.executeQuery(req);
//
//            while (rs.next()) {
//                String numLigneC = rs.getString("IDLigneCommande");
//                String IDLivre = rs.getString("IDLivreLigneCommande");
//                Integer  qty = rs.getInt("quantiteLigneCommande");
//                Float tva = rs.getFloat("TVALigneCommande");
//                Float prixHT = rs.getFloat("prixHTLivreLigneCommande");
//                Float promo = rs.getFloat("valeurPromoLigneCommande");
//
//                LigneCommande lc = new LigneCommande(numLigneC, IDLivre, qty, tva, prixHT, promo);
//                lcom.add(lc);
//            }
//            rs.close();
//        } finally {
//            if (cnt != null) {
//                cnt.close();
//            }
//        }
//        return lcom;
//
//    }
    
}
