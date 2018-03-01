
package accesBDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.NamingException;
import obj.Evenement;


public class EvenementDAO {
    
    private MaConnexion mc ;

    public EvenementDAO() throws NamingException {
        
        mc = new MaConnexion();
        
    }
 public ArrayList<Evenement> selectAllEvenement() throws SQLException {
        ArrayList<Evenement> mesEvenements = new ArrayList<>();
        
        String req = "select \n"
                + "nomEvenement,dateDebutEvenement,dateFinEvenement,typeEvenement,\n"
                + "descriptionEvenement,commentaireEvenement,,dateStatutEvenement, ,ISBNLivre,titreLivre\n"
                + "from Evenement \n"
                + " join presentation on IDEvenement = IDEvenementPresentation\n"
                + " join livre on IDLivre = IDLivrePresentation\n"
                + " WHERE IDStatutEvenement != 3";
        
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();
        
        String RSnomEvenement = null;
        String RSdateDebutEvenement = null;
        String RSdateFinEvenement = null;
        String RStypeEvenement = null;
        String RSdescriptionEvenement = null;
        String RScommentaireEvenement = null;
//        String RSdateStatutEvenement = null;
        String RSISBNLivre = null;
        String RStitreLivre = null;
        
        
        
        
        
        try {
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                Evenement monEvenement = new Evenement();
                RSnomEvenement = rs.getString("nomEvenement");
                monEvenement.setNomEvenement(RSnomEvenement);
                RSdateDebutEvenement = rs.getString("dateDebutEvenement");
                monEvenement.setDateDebutEvenement(RSdateDebutEvenement);
                RSdateFinEvenement = rs.getString("dateFinEvenement");
                monEvenement.setDateFinEvenement(RSdateFinEvenement);
                RStypeEvenement = rs.getString("typeEvenement");
                monEvenement.setTypeEvenement(RStypeEvenement);
                RSdescriptionEvenement = rs.getString("descriptionEvenement");
                monEvenement.setDescriptionEvenement(RSdescriptionEvenement);
                RScommentaireEvenement = rs.getString("commentaireEvenement");
                monEvenement.setCommentaireEvenement(RScommentaireEvenement);
//                RSdateStatutEvenement = rs.getString("dateStatutEvenement");
//                monEvenement.setDateStatutEvenement(RSdateStatutEvenement);
                RSISBNLivre = rs.getString("ISBNLivre");
                monEvenement.setISBNLivre(RSISBNLivre);
                RStitreLivre = rs.getString("titreLivre");
                monEvenement.setTitreLivre(RStitreLivre);

                mesEvenements.add(monEvenement);
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
