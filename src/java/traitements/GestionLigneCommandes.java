package traitements;

import accesBDD.LigneCommandeDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import obj.LigneCommande;
import obj.Livres;

public class GestionLigneCommandes implements Serializable {

    private LigneCommandeDAO lcDAO;

    public GestionLigneCommandes() throws NamingException {
        lcDAO = new LigneCommandeDAO();
    }

    public List<LigneCommande> findOrderLineByOrder(String IDCommande) throws SQLException {
        List<LigneCommande> LigneCommandes = lcDAO.viewOrderLineByOrder(IDCommande);
        return LigneCommandes;
    }

    public List<Livres> findBookByOrder(String IDCommande) throws SQLException{
        List<Livres> livres = lcDAO.selectBookByOrder(IDCommande);
        return livres;
    }


}
