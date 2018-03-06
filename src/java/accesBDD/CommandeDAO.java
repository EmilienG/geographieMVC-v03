package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
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

    public List<Commande> selectOrderByCustomer() throws SQLException {
        String req = "SELECT IDCommande , dateCommande, ad1.nomDestinataireAdresse, ad1.prenomDestinatireAdresse, montantCommande, descriptionStatut "
            + "FROM Compte ct "
            + "JOIN Adresse ad1 "
            + "ON ct.IDCompte = ad1.IDCompteClientAdresse "
            + "JOIN Commande com "
            + "ON ad1.IDAdresse = com.IDAdresseLivraisonCommande "
            + "JOIN Adresse ad2 "
            + "ON com.IDAdresseFacturationCommande = ad2.IDAdresse "
            + "JOIN Statut sta "
            + "ON com.IDStatutCommande = sta.IDStatut "
            + "WHERE IDCompteCommande = '1' " ;
        System.out.println(req);
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();
        
        List<Commande> com = new ArrayList<>();
        try {
            ResultSet rs = stm.executeQuery(req);

                 
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
        }finally{
            if(cnt != null){
                cnt.close();
            }
        }
        return com;
    }

}
