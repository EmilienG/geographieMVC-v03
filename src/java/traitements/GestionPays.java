 package traitements;

import accesBDD.PaysDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.naming.NamingException;
import obj.Pays;

public class GestionPays implements Serializable {

    private PaysDAO pDAO;

    public GestionPays() throws NamingException {
        pDAO = new PaysDAO();
    }

    public List<String> getCleDefaut() {
        List<String> clefs = new ArrayList<>();
        clefs.add("A-C");
        clefs.add("D-F");
        clefs.add("G-I");
        clefs.add("J-L");
        clefs.add("M-O");
        clefs.add("P-R");
        clefs.add("S-U");
        clefs.add("V-Z");
        return clefs;
    }

    public HashMap<String, List<Pays>> findPays() throws SQLException {
        List<String> clefs = getCleDefaut();
        HashMap<String, List<Pays>> mp = new HashMap<>();
        for (String cle : clefs) {
            List<Pays> lp = new ArrayList<>();
            mp.put(cle, lp);
        }
        List<Pays> lPays = pDAO.selectAllPays();
        for (Pays p : lPays) {
            String lettre = p.getNom().toUpperCase().charAt(0) + "";
            for (String cle : clefs) {
                String regex = "[" + cle + "]";
                if (lettre.matches(regex)) {
                    List<Pays> lp = mp.get(cle);
                    lp.add(p);
                }
            }
        }
        return mp;
    }

}
