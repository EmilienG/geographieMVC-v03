package traitements;

import accesBDD.LigneCommandeDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import obj.LigneCommande;

public class GestionLigneCommandes implements Serializable {

    private LigneCommandeDAO lcDAO;

    public GestionLigneCommandes() throws NamingException {
        lcDAO = new LigneCommandeDAO();
    }

    public List<LigneCommande> findOrderLine() throws SQLException {
        List<LigneCommande> LigneCommandes = lcDAO.selectAllOrderLineByOrder();
        return LigneCommandes;
    }

//    public String findISBNBooks() throws SQLException {
//        List<LigneCommande> LigneCommandes = lcDAO.selectISBNBook();
//        return LigneCommandes;
//        
//        }
    

}
