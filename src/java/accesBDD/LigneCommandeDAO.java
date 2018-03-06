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
        String req = "SELECT IDLigneCommande, ISBNLivre, titreLivre, quantiteLigneCommande, TVALigneCommande, prixHTLivreLigneCommande, valeurPromoLigneCommande "
                + "FROM LigneCommande lc "
                + "JOIN Livre lv "
                + "ON lc.IDLivreLigneCommande = lv.IDLivre "
                + "JOIN TVA t "
                + "ON lv.IDTVALivre = t.IDTVA "
                + "WHERE IDCommandeLigneCommande = '2' and IDStatut!=3";
        System.out.println(req);
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();

        System.out.println(req);

        List<LigneCommande> lcom = new ArrayList<>();
        try {
            ResultSet rs = stm.executeQuery(req);

            while (rs.next()) {
                LigneCommande lc = new LigneCommande();
                String numLigneC = rs.getString("IDLigneCommande");
//                lc.get(req);
                String ISBNLivre = rs.getString("ISBNLivre");
                String titreLivre = rs.getString("titreLivre");
                Integer qty = rs.getInt("quantiteLigneCommande");
                Float tva = rs.getFloat("TVALigneCommande");
                Float prixHT = rs.getFloat("prixHTLivreLigneCommande");
                Float promo = rs.getFloat("valeurPromoLigneCommande");

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
}
