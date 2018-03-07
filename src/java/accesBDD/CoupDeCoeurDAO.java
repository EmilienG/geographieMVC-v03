package accesBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import obj.CoupDeCoeur;

public class CoupDeCoeurDAO {

    private MaConnexion mc;

    public CoupDeCoeurDAO() throws NamingException {

        mc = new MaConnexion();

    }

    public ArrayList<CoupDeCoeur> selectAllCoupDeCoeur(boolean atif, String saisie) throws SQLException {
        ArrayList<CoupDeCoeur> mesCoupDeCoeurs = new ArrayList<>();

        String req = "select IDCoupDecoeur, IDCompteCoupDeCoeur, nomCoupDeCoeur, descriptionCoupDeCoeur, IDStatutCoupDeCoeur, dateStatutCoupDeCoeur, ISBNLivre, titreLivre"
                + " from CoupDeCoeur"
                + " join MiseEnAvant on IDCoupDeCoeur = IDCoupDeCoeurMiseEnAvant"
                + " join livre on IDLivre = IDLivreMiseEnAvant"
                + " WHERE IDStatutCoupDeCoeur!= 3"
                + " ORDER BY IDCoupDeCoeur";
//        System.out.println(req);
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();
        PreparedStatement pstm = null;
        String req2 = null;
        if (atif) {
            req2 = "select IDCoupDecoeur, IDCompteCoupDeCoeur, nomCoupDeCoeur, descriptionCoupDeCoeur, IDStatutCoupDeCoeur, dateStatutCoupDeCoeur, ISBNLivre, titreLivre"
                    + " from CoupDeCoeur"
                    + " join MiseEnAvant on IDCoupDeCoeur = IDCoupDeCoeurMiseEnAvant"
                    + " join livre on IDLivre = IDLivreMiseEnAvant"
                    + " WHERE IDStatutCoupDeCoeur!= 3 and nomCoupDeCoeur like ? or descriptionCoupDeCoeur like ?"
                    + " or ISBNLivre like ? or titreLivre like ?"
                    + " ORDER BY IDCoupDeCoeur";
            pstm = cnt.prepareStatement(req2);
            if (saisie != null) {
                System.out.println(saisie);
                System.out.println(req2);
                pstm.setString(1, "%" + saisie + "%");
                pstm.setString(2, "%" + saisie + "%");
                pstm.setString(3, "%" + saisie + "%");
                pstm.setString(4, "%" + saisie + "%");

            }
        }

        try {
            ResultSet rs = null;
            if (atif) {
                rs = pstm.executeQuery();
            } else {
                rs = stm.executeQuery(req);
            }
            CoupDeCoeur lastCoupDeCoeur = null;
            while (rs.next()) {
                int id = rs.getInt("IDCoupDeCoeur");
//                System.out.println(">>>>  id1" + id + " id2" + lastCoupDeCoeur.getIDCoupDeCoeur());
                if (lastCoupDeCoeur == null || (id != lastCoupDeCoeur.getIDCoupDeCoeur())) {
//                    System.out.println("<<<<< id1" + id + " id2" + lastCoupDeCoeur.getIDCoupDeCoeur());
                    int IDCoupDeCoeur = rs.getInt("IDCoupDeCoeur");
                    String nomCoupDeCoeur = rs.getString("nomCoupDeCoeur");
                    String descriptionCoupDeCoeur = rs.getString("descriptionCoupDeCoeur");
                    String ISBNLivre = rs.getString("ISBNLivre");
                    String titreLivre = rs.getString("titreLivre");
                    lastCoupDeCoeur = new CoupDeCoeur(IDCoupDeCoeur, nomCoupDeCoeur, descriptionCoupDeCoeur, titreLivre, ISBNLivre);
                    if (titreLivre != null) {
                        List<String> titreLivres = lastCoupDeCoeur.getTitresLivres();

                        titreLivres.add(titreLivre);

                    }
                    mesCoupDeCoeurs.add(lastCoupDeCoeur);

                } else {
                    String titreLivre = rs.getString("titreLivre");
                    List<String> titreLivres = lastCoupDeCoeur.getTitresLivres();
                    titreLivres.add(titreLivre);
                }
            }
            rs.close();
        } finally {
            if (cnt != null) {
                cnt.close();
            }
        }
        return mesCoupDeCoeurs;

    }

}
