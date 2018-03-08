package traitements;

import accesBDD.LigneCommandeDAO;
import accesBDD.LivresDAO;
import accesBDD.RechercheDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import obj.Livres;

public class GestionLivres implements Serializable {

    private LivresDAO lDAO;
    private RechercheDAO rDAO;
    private LigneCommandeDAO lcDAO;

    public GestionLivres() throws NamingException {
        lDAO = new LivresDAO();
        rDAO = new RechercheDAO();
    }

    public ArrayList<Livres> findLivresPagin(boolean atif, String saisie, int debut, int pas) throws SQLException {
        ArrayList<Livres> livres = lDAO.selectLivrePagin(atif, saisie, debut, pas);
        return livres;
    }

    public ArrayList<Livres> findLivres(boolean atif, String saisie) throws SQLException {
        ArrayList<Livres> livres = lDAO.selectAllLivre(atif, saisie);
        return livres;
    }

    public ArrayList<Livres> findLivresbysearch(String saisie) throws SQLException {
        ArrayList<Livres> livres = rDAO.recherche(saisie);
        return livres;
    }

    public Livres findLivreByID(String IDLivre) throws SQLException {
        Livres monLivre = lDAO.getUnLivreByID(IDLivre);
        return monLivre;
    }

//    public List<Livres> findBookByOrder(String IDCommande) throws SQLException{
//        List<Livres> livres = lDAO.selectBookByOrder(IDCommande);
//        return livres;
//    }
}
