
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
        
        String req = "select * from Evenement";
        
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();
        
        String RSnomEvenement = null;
        String RSdateDebutEvenement = null;
        
        
        
        try {
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                Evenement monEvenement = new Evenement();
                RSnomEvenement = rs.getString("nomEvenement");
                monEvenement.setNomEvenement(RSnomEvenement);
                RSdateDebutEvenement = rs.getString("dateDebutEvenement");
                monEvenement.setDateDebutEvenement(RSdateDebutEvenement);

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
