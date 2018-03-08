package accesBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import obj.Evenement;

public class EvenementDAO {

    private MaConnexion mc;

    public EvenementDAO() throws NamingException {

        mc = new MaConnexion();

    }

    public ArrayList<Evenement> selectAllEvenement(boolean atif, String saisie) throws SQLException {
        ArrayList<Evenement> mesEvenements = new ArrayList<>();

        String req = "select IDLivre, IDEvenement, nomEvenement, dateDebutEvenement, dateFinEvenement, typeEvenement, descriptionEvenement, commentaireEvenement, dateStatutEvenement, ISBNLivre, titreLivre"
                + " from Evenement"
                + " join presentation on IDEvenement = IDEvenementPresentation"
                + " join livre on IDLivre = IDLivrePresentation"
                + " WHERE IDStatutEvenement != 3"
                + " ORDER BY IDEvenement";
        System.out.println(req);
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();
        PreparedStatement pstm = null;
        String req2 = null;
        if (atif) {
            req2 = "select IDLivre, IDEvenement, nomEvenement, dateDebutEvenement, dateFinEvenement, typeEvenement, descriptionEvenement, commentaireEvenement, dateStatutEvenement, ISBNLivre, titreLivre"
                    + " from Evenement"
                    + " join presentation on IDEvenement = IDEvenementPresentation"
                    + " join livre on IDLivre = IDLivrePresentation"
                    + " WHERE IDStatutEvenement != 3 and nomEvenement like ? or typeEvenement like ?"
                    + " or descriptionEvenement like ? or commentaireEvenement like ?"
                    + " or ISBNLivre like ? or titreLivre like ?"
                    + " ORDER BY IDEvenement";
            pstm = cnt.prepareStatement(req2);
            if (saisie != null) {
                System.out.println(saisie);
                System.out.println(req2);
                pstm.setString(1, "%" + saisie + "%");
                pstm.setString(2, "%" + saisie + "%");
                pstm.setString(3, "%" + saisie + "%");
                pstm.setString(4, "%" + saisie + "%");
                pstm.setString(5, "%" + saisie + "%");
                pstm.setString(6, "%" + saisie + "%");
            }
        }
        try {

            ResultSet rs = null;
            if (atif) {
                rs = pstm.executeQuery();
            } else {
                rs = stm.executeQuery(req);
            }
            Evenement lastEvenement = null;
            while (rs.next()) {
                int id = rs.getInt("IDEvenement");
                if (lastEvenement == null || (id != lastEvenement.getIDEvenement())) {

                    int IDEvenement = rs.getInt("IDEvenement");

                    String nomEvenement = rs.getString("nomEvenement");
                    String typeEvenement = rs.getString("typeEvenement");
                    String descriptionEvenement = rs.getString("descriptionEvenement");
                    String commentaireEvenement = rs.getString("commentaireEvenement");
                    String ISBNLivre = rs.getString("ISBNLivre");
                    String titreLivre = rs.getString("titreLivre");
                    String IDLivre = rs.getString("IDLivre");

                    lastEvenement = new Evenement(IDEvenement, nomEvenement, typeEvenement, descriptionEvenement, commentaireEvenement, titreLivre, ISBNLivre, IDLivre);

                    if (titreLivre != null) {
                        List<String> titreLivres = lastEvenement.getTitresLivres();

                        titreLivres.add(titreLivre);

                    }
                    mesEvenements.add(lastEvenement);
                } else {
                    String titreLivre = rs.getString("titreLivre");
                    List<String> titreLivres = lastEvenement.getTitresLivres();
                    titreLivres.add(titreLivre);
                }
            }
            rs.close();
        } finally {
            if (cnt != null) {
                cnt.close();
            }
        }
        return mesEvenements;

    }

}
