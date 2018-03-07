package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import obj.LigneCommande;
import obj.Livres;

public class LigneCommandeDAO implements Serializable {

    private MaConnexion mc;

    public LigneCommandeDAO() throws NamingException {
        mc = new MaConnexion();
    }

    public List<LigneCommande> viewOrderLineByOrder(String IDCommande) throws SQLException {
        String req = "SELECT IDLigneCommande, IDLivreLigneCommande, quantiteLigneCommande, TVALigneCommande, prixHTLivreLigneCommande, valeurPromoLigneCommande "
                + " FROM LigneCommande join Commande "
                + " ON IDCommande=IDCommandeLigneCommande "
                + " JOIN Livre "
                + " ON IDLivreLigneCommande = IDLivre "
                + " WHERE IDCommande = ? and IDStatutLigneCommande != 3";
        System.out.println(req);
        Connection cnt = mc.getConnection();
        PreparedStatement pstm = cnt.prepareStatement(req);
        pstm.setString(1, IDCommande);

        List<LigneCommande> lcom = new ArrayList<>();

        try {
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                LigneCommande lc = new LigneCommande();
                String numLigneC = rs.getString("IDLigneCommande");
                lc.setIDLigneCommande(numLigneC);
                String IDLivre = rs.getString("IDLivreLigneCommande");
                lc.setIDLivreLigneCommande(IDLivre);
                int qty = rs.getInt("quantiteLigneCommande");
                lc.setQuantiteLigneCommande(qty);
                float tva = rs.getFloat("TVALigneCommande");
                lc.setTVALigneCommande(tva);
                float prixHT = rs.getFloat("prixHTLivreLigneCommande");
                lc.setPrixHTLivreLigneCommande(prixHT);
                float promo = rs.getFloat("valeurPromoLigneCommande");
                lc.setValeurPromoLigneCommande(promo);

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

    public List<Livres> selectBookByOrder(String IDCommande) throws SQLException {
        String req = "select Distinct IDLivre, ISBNlivre, titreLivre  "
                + "from Compte "
                + "join Commande "
                + "on IDCommande = IDCompteCommande "
                + "Join LigneCommande "
                + "on IDCommandeLigneCommande = IDCommande "
                + "join Livre "
                + "on IDLivreLigneCommande = IDLivre "
                + "Where IDCommande = ? and IDStatutLigneCommande != 3";
        System.out.println(req);
        Connection cnt = mc.getConnection();
        PreparedStatement pstm = cnt.prepareStatement(req);
        pstm.setString(1, IDCommande);

        List<Livres> lv = new ArrayList<>();

        try {
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Livres lvs = new Livres();
                String numLivre = rs.getString("IDLivre");
                lvs.setIDLivre(numLivre);
                String ISBNLivre = rs.getString("ISBNlivre");
                lvs.setISBNlivre(ISBNLivre);
                String titre = rs.getString("titreLivre");
                lvs.setTitreLivre(titre);

                lv.add(lvs);

            }
            rs.close();
        } finally {
            if (cnt != null) {
                cnt.close();
            }
        }
        return lv;

    }
}
