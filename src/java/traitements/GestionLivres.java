package traitements;

import accesBDD.LivresDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import obj.Livres;

public class GestionLivres implements Serializable {

    private LivresDAO lDAO;

    public GestionLivres() throws NamingException {
        lDAO = new LivresDAO();
    }

    public ArrayList<Livres> findLivres() throws SQLException {
        ArrayList<Livres> livres = lDAO.selectAllLivre();
        return livres;
    }

}
