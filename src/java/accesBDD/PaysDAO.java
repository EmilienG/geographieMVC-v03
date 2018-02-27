package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import obj.Pays;

public class PaysDAO implements Serializable {

    private MaConnexion mc;

    public PaysDAO() throws NamingException {
        mc = new MaConnexion();
    }

    public List<Pays> selectAllPays() throws SQLException {
        String req = "select p.Pays, p.A2, p.A3, p.Number "
                + "from iso3166 p order by p.Pays";
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();
        List<Pays> lp = new ArrayList<>();
        try {
            ResultSet rs = stm.executeQuery(req);

            while (rs.next()) {
                String nom = rs.getString("Pays");
                String a2 = rs.getString("A2");
                String a3 = rs.getString("A3");
                int number = rs.getInt("Number");
                Pays p = new Pays(nom, a2, a3, number);
                lp.add(p);
            }
            rs.close();
        } finally {
            if (cnt != null) {
                cnt.close();
            }
        }
        return lp;
    }

    public Pays selectPaysById(String a2) throws SQLException {
        String req = "select p.Pays, p.A2, p.A3, p.Number "
                + "from iso3166 p where p.A2 = ? "
                + "order by p.Pays";
        Pays p = null;
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            stm.setString(1, a2);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                String nom = rs.getString("Pays");
                a2 = rs.getString("A2");
                String a3 = rs.getString("A3");
                int number = rs.getInt("Number");
                p = new Pays(nom, a2, a3, number);
            }
        }
        return p;
    }
}
