package traitements;

import accesBDD.LivresDAO;
import accesBDD.RechercheDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import obj.Livres;

public class GestionLivres implements Serializable {

    private LivresDAO lDAO;
    private RechercheDAO rDAO;

    public GestionLivres() throws NamingException {
        lDAO = new LivresDAO();
        rDAO = new RechercheDAO();
    }

    public ArrayList<Livres> findLivres2(int debut, int pas) throws SQLException {
        ArrayList<Livres> livres = lDAO.selectLivrePagin(debut, pas);
        return livres;
    }

    public ArrayList<Livres> findLivres(boolean atif, String saisie) throws SQLException {
        ArrayList<Livres> livres = lDAO.selectAllLivre(atif, saisie);
        return livres;
    }

    public ArrayList<Livres> findLivresbysearch(String saisie) throws SQLException {
//        System.out.println(">>>>>>" + (rDAO == null));
        ArrayList<Livres> livres = rDAO.recherche(saisie);
        return livres;
    }
}
