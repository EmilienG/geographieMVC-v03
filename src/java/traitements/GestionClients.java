package traitements;

import accesBDD.ClientDAO;
import java.sql.SQLException;
import javax.naming.NamingException;

public class GestionClients {

    private ClientDAO cDAO;

    public GestionClients() throws NamingException {
        cDAO = new ClientDAO();
    }

    public String test(String nom) throws SQLException {
        String s = cDAO.selectLogin(nom).getId();
        return s;
    }

}
