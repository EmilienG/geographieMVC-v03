
package traitements;

import accesBDD.EvenementDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import obj.Evenement;


public class GestionEvenement implements Serializable {
    
    private EvenementDAO EDAO;
   
    
   public GestionEvenement() throws NamingException {
       EDAO = new EvenementDAO();
   }
    
   public ArrayList<Evenement>findEvenement(boolean atif, String saisie) throws SQLException {
       ArrayList<Evenement>Evenement = EDAO.selectAllEvenement(atif, saisie);
       return Evenement;
       
   }
  
    
}
