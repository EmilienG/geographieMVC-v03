package traitements;

import accesBDD.ClientDAO;
import java.sql.SQLException;
import javax.naming.NamingException;
import obj.Client;

public class GestionClients {

    private ClientDAO cDAO;

    public GestionClients() throws NamingException {
        cDAO = new ClientDAO();
    }

    public String getIDCompteByName(String nom) throws SQLException {
        String s = cDAO.selectIDClientByName(nom);
        return s;
    }
    public Client afficherClientByID(String IDCompte) throws SQLException {
        Client cli = cDAO.selectLoginByID(IDCompte);
        return cli;
    }
}
