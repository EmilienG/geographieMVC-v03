package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.NamingException;

public class LivresDAO implements Serializable {

    private MaConnexion mc;

    public LivresDAO() throws NamingException {
        mc = new MaConnexion();
    }

    public ArrayList<String> selectAllLivre() throws SQLException {
        ArrayList<String> mesLivres = new ArrayList<>();
        String req = "select titreLivre from livre";
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();
        String nom = null;
        try {
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                nom = rs.getString("titreLivre");
                mesLivres.add(nom);
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
