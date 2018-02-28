package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
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

    public ArrayList<Livres> selectAllLivre() throws SQLException {
//        System.out.println("mlklmkmlkmlml");
        ArrayList<Livres> mesLivres = new ArrayList<>();
        String req = "select * from VueEmilien";
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();
        String RStitreLivre = null;
        String RSSousTitreLivre = null;
        String RSISBNLivre = null;
        String RSDateParution = null;
        String RSCouverture = null;
        float RSPrix = 0;
        int RSQuantite = 0;
        String RSResume = null;
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
//                System.out.println("slmkfmlsdkfmlsdkfmls");
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