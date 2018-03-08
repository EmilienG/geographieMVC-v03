package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import obj.Client;
import obj.CoupDeCoeur;

public class ClientDAO implements Serializable {

    private MaConnexion mc;

    public ClientDAO() throws NamingException {
        mc = new MaConnexion();
    }

    public String selectIDClientByName(String pseudo) throws SQLException {
        String req = "select IDCompte from compte where pseudoCompte=?";
        Client c = null;
        String s = null;
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            stm.setString(1, pseudo);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                c = new Client();
                c.setPseudo(pseudo);
                c.setId(rs.getString("IDCompte"));
                s = c.getId();
            }
        }
        return s;
    }

    //Pas besoin prepareStatement
    public Client selectLoginByID(String IDCompte) throws SQLException {
        ArrayList<String> mesAdresses = new ArrayList<>();
        String req = "select * from compte "
                + " JOIN Adresse"
                + " ON IDAdresse = IDCompteClientAdresse"
                + " where IDcompte=?";
        Client c = null;
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            stm.setString(1, IDCompte);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                c = new Client();
                c.setId(IDCompte);
                c.setPseudo(rs.getString("pseudoCompte"));
                c.setMDP(rs.getString("MDPCompte"));
                c.setNom(rs.getString("nomCompte"));
                c.setPrenom(rs.getString("prenomCompte"));
                c.setPseudo(rs.getString("pseudoCompte"));
                c.setDateCreation(rs.getDate("dateCreationCompte"));
                c.setEmail(rs.getString("emailCompte"));
                c.setTelephone(rs.getString("telephoneCompte"));
                mesAdresses.add(rs.getString("IDAdresse") + " " + rs.getString("nomVoieAdresse"));
            }
            c.setAdresses(mesAdresses);
            return c;
        }
    }
}
