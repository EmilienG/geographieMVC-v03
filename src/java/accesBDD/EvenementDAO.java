package accesBDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.NamingException;
import obj.Evenement;

public class EvenementDAO {

    private MaConnexion mc;

    public EvenementDAO() throws NamingException {

        mc = new MaConnexion();

    }

    public ArrayList<Evenement> selectAllEvenement() throws SQLException {
        ArrayList<Evenement> mesEvenements = new ArrayList<>();

        String req = "select nomEvenement,dateDebutEvenement,dateFinEvenement,typeEvenement,descriptionEvenement,commentaireEvenement,dateStatutEvenement,ISBNLivre,titreLivre\n"
                + " from Evenement\n"
                + " join presentation on IDEvenement = IDEvenementPresentation\n"
                + " join livre on IDLivre = IDLivrePresentation\n"
                + " WHERE IDStatutEvenement != 3";
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();

        String nomEvenement = null;
        String dateDebutEvenement = null;
        String dateFinEvenement = null;
        String typeEvenement = null;
        String descriptionEvenement = null;
        String commentaireEvenement = null;
        String ISBNLivre = null;
        String titreLivre = null;

//          String RSdateStatutEvenement = null;

        try {
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                Evenement monEvenement = new Evenement();
                
                nomEvenement = rs.getString("nomEvenement");
                monEvenement.setNomEvenement(nomEvenement);
                
                dateDebutEvenement = rs.getString("dateDebutEvenement");
                monEvenement.setDateDebutEvenement(dateDebutEvenement);
                
                dateFinEvenement = rs.getString("dateFinEvenement");
                monEvenement.setDateFinEvenement(dateFinEvenement);
                
                typeEvenement = rs.getString("typeEvenement");
                monEvenement.setTypeEvenement(typeEvenement);
                
                descriptionEvenement = rs.getString("descriptionEvenement");
                monEvenement.setDescriptionEvenement(descriptionEvenement);
                
                commentaireEvenement = rs.getString("commentaireEvenement");
                monEvenement.setCommentaireEvenement(commentaireEvenement);
                
                ISBNLivre = rs.getString("ISBNLivre");
                monEvenement.setISBNLivre(ISBNLivre);
                
                titreLivre = rs.getString("titreLivre");
                monEvenement.setTitreLivre(titreLivre);

                mesEvenements.add(monEvenement);

//                RSdateStatutEvenement = rs.getString("dateStatutEvenement");
//                monEvenement.setDateStatutEvenement(RSdateStatutEvenement);
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
