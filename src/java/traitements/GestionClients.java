package traitements;

import accesBDD.ClientDAO;
import java.sql.SQLException;
import javax.naming.NamingException;
import obj.Client;

public class GestionClients {

    private ClientDAO cDAO;
//    private ClientDAO ccDAO;

    public GestionClients() throws NamingException {
        cDAO = new ClientDAO();
//        ccDAO = new ClientDAO();
    }

    public String afficheIDClient(String nom) throws SQLException {
        String s = cDAO.selectLogin(nom).getId();
        return s;
    }

    public Client afficherClient(String nom) throws SQLException {
        Client cli = cDAO.selectLogin(nom);
        return cli;
    }

}
