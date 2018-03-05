
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
    
      public boolean check(String nom, String prenom, String pseudo, String mdp,String email,String tel, String commentaire) {
        try {
            Client c;
            c = cDAO.ajoutClient( nom,  prenom,  pseudo,  mdp, email, tel,  commentaire);            
            if( nom==null ||  prenom==null || pseudo==null || mdp== null || email== null ||  tel== null){
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
