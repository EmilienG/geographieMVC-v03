package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import obj.Client;

public class ClientDAO implements Serializable {

    private MaConnexion mc;

    public ClientDAO() throws NamingException {
        mc = new MaConnexion();
    }

    public Client selectLogin(String pseudo) throws SQLException {
        String req = "select * from compte where pseudoCompte=?";
        Client c = null;
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            stm.setString(1, pseudo);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                c = new Client();
                c.setId(rs.getString("IDCompte"));
                c.setMDP(rs.getString("MDPCompte"));
                c.setPseudo(pseudo);
                c.setNom(rs.getString("nomCompte"));
                c.setPseudo(rs.getString("pseudoCompte"));
                c.setDateCreation(rs.getDate("dateCreationCompte"));
            }
        }
        return c;
    }
}
