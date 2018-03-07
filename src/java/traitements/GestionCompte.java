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

    
//      public boolean check(String nom, String prenom, String pseudo,  String mdp,String email) {
//        try {
//            Client c;
//            c = cDAO.ajoutClient( nom,  prenom,pseudo, mdp, email);            
//             if(nom!="" &&  prenom!="" && pseudo!="" && mdp!= "" && email!= ""){
//            
//                    return true; 
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }    
    
    public Client addCustomer(String nom, String prenom, String pseudo,  String mdp, String email) throws SQLException {
        Client cli = cDAO.ajoutClient(nom, prenom,pseudo, mdp, email);

        return cli;
    }

    public void modifCompte(String IDCompte, String nom, String prenom, String pseudo, String email, String telephone, String mdp) throws SQLException {
        cDAO.modifClient(IDCompte, nom, prenom, pseudo, email, telephone, mdp);
      
    }
}
