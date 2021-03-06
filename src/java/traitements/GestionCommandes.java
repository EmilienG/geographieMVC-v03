package traitements;

import accesBDD.CommandeDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import obj.Commande;

public class GestionCommandes implements Serializable {

    private CommandeDAO cDAO;

    public GestionCommandes() throws NamingException {
        cDAO = new CommandeDAO();
    }

    public List<Commande> findOrder(String IDCompte) throws SQLException {
        List<Commande> Commandes = cDAO.viewOrderByUser(IDCompte);
        return Commandes;
    }
}
