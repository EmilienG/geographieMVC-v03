package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import obj.Commande;

public class CommandeDAO implements Serializable {

    private MaConnexion mc;

    public CommandeDAO() throws NamingException {
        mc = new MaConnexion();
    }

    public List<Commande> viewOrderByUser(String IDCompte) throws SQLException {
        String req = "SELECT IDCommande, dateCommande, montantCommande, descriptionStatut "
                + "from Compte "
                + "join Commande "
                + "on IDCommande = IDCompteCommande "
                + "JOIN Statut "
                + "ON IDStatutCommande = IDStatut "
                + "WHERE IDCompte = ? and IDStatutCommande != 3";
        System.out.println(req);
        Connection cnt = mc.getConnection();
        PreparedStatement pstm = cnt.prepareStatement(req);
        pstm.setString(1, IDCompte);

        List<Commande> com = new ArrayList<>();
        try {
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Commande c = new Commande();
                String numCommande = rs.getString("IDCommande");
                c.setIDCommande(numCommande);
                Date dateCommande = rs.getDate("dateCommande");
                c.setDateCommande(dateCommande);
                Float montantCommande = rs.getFloat("montantCommande");
                c.setMontantCommande(montantCommande);
                String statutCommande = rs.getString("descriptionStatut");
                c.setDescriptionStatut(statutCommande);

                com.add(c);
            }
            rs.close();
        } finally {
            if (cnt != null) {
                cnt.close();
            }
        }
        return com;
    }

}
