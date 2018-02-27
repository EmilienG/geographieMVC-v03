package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.NamingException;
import obj.Livres;

public class LivresDAO implements Serializable {

    private MaConnexion mc;

    public LivresDAO() throws NamingException {
        mc = new MaConnexion();
    }

    public ArrayList<Livres> selectAllLivre() throws SQLException {
        ArrayList<Livres> mesLivres = new ArrayList<>();
        String req = "select * from livre";
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();
        String RStitreLivre = null;
        String RSSousTitreLivre = null;
        try {
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
        Livres monLivre = new Livres();
                RStitreLivre = rs.getString("titreLivre");
                monLivre.setTitreLivre(RStitreLivre);
                RSSousTitreLivre = rs.getString("sousTitreLivre");
                monLivre.setSousTitreLivre(RSSousTitreLivre);

                mesLivres.add(monLivre);
            }
            rs.close();
        } finally {
            if (cnt != null) {
                cnt.close();
            }
        }
        return mesLivres;
    }

}
