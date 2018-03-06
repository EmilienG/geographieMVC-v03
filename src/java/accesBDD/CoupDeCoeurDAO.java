package accesBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
                + " WHERE IDStatutCoupDeCoeur!= 3";
        System.out.println(req);
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
                    + "or ISBNLivre like ? or titreLivre like ?";
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

        String nomCoupDeCoeur = null;
        String descriptionCoupDeCoeur = null;
        String titreLivre = null;
        String ISBNLivre = null ;
//          String RSdateStatutEvenement = null;
        try {
//            ResultSet rs = stm.executeQuery(req);
            ResultSet rs = null;
            if (atif) {
                rs = pstm.executeQuery();
            } else {
                rs = stm.executeQuery(req);
            }
            while (rs.next()) {
                CoupDeCoeur monCoupDeCoeur = new CoupDeCoeur();

                nomCoupDeCoeur = rs.getString("nomCoupDeCoeur");
                monCoupDeCoeur.setNomCoupDeCoeur(nomCoupDeCoeur);

                descriptionCoupDeCoeur = rs.getString("descriptionCoupDeCoeur");
                monCoupDeCoeur.setDescriptionCoupDeCoeur(descriptionCoupDeCoeur);

                ISBNLivre = rs.getString("ISBNLivre");
                monCoupDeCoeur.setISBNLivre(ISBNLivre);

                titreLivre = rs.getString("titreLivre");
                monCoupDeCoeur.setTitreLivre(titreLivre);

                mesCoupDeCoeurs.add(monCoupDeCoeur);

//                RSdateStatutEvenement = rs.getString("dateStatutEvenement");
//                monEvenement.setDateStatutEvenement(RSdateStatutEvenement);
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
