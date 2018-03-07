
package traitements;

import accesBDD.CoupDeCoeurDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import obj.CoupDeCoeur;


public class GestionCoupDeCoeur implements Serializable{

    
    private CoupDeCoeurDAO EDAO;
   
    
   public GestionCoupDeCoeur() throws NamingException {
       EDAO = new CoupDeCoeurDAO();
   }
    
   public ArrayList<CoupDeCoeur>findCoupDeCoeur(boolean atif, String saisie) throws SQLException {
       ArrayList<CoupDeCoeur>ListCoupDeCoeur = EDAO.selectAllCoupDeCoeur(atif, saisie);
       return ListCoupDeCoeur;
       
   }
  
    


    
}
