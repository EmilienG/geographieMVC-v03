package traitements;

import accesBDD.LivresDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

public class GestionLivres implements Serializable {

    private LivresDAO lDAO;

    public GestionLivres() throws NamingException {
        lDAO = new LivresDAO();
    }

    public ArrayList<String> findLivres() throws SQLException {
        ArrayList<String> a = lDAO.selectAllLivre();
        return a;
    }

}
