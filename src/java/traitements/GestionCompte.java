
package traitements;

import accesBDD.CompteDAO;
import java.sql.SQLException;
import javax.naming.NamingException;
import obj.Client;

public class GestionCompte {
    private CompteDAO cDAO;
    
    public GestionCompte() throws NamingException {
        cDAO = new CompteDAO();
    }
    
      public boolean check(String nom, String prenom,  String mdp,String email) {
        try {
            Client c;
            c = cDAO.ajoutClient( nom,  prenom, mdp, email);            
            if( nom==null ||  prenom==null || mdp== null || email== null){
                return false;
            }else{
            
                    return true; 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }    
	
}
