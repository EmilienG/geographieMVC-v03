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

    public List<Commande> selectOrderByCustomer(String IDCompte) throws SQLException {
        String req = "SELECT IDCompteCommande, IDCommande , dateCommande, ad1.nomDestinataireAdresse, ad1.prenomDestinataireAdresse, montantCommande, descriptionStatut "
            + "FROM Compte ct "
            + "JOIN Adresse ad1 "
            + "ON ct.IDCompte = ad1.IDCompteClientAdresse "
            + "JOIN Commande com "
            + "ON ad1.IDAdresse = com.IDAdresseLivraisonCommande "
            + "JOIN Adresse ad2 "
            + "ON com.IDAdresseFacturationCommande = ad2.IDAdresse "
            + "JOIN Statut sta "
            + "ON com.IDStatutCommande = sta.IDStatut "
            + "WHERE IDCompteCommande = ? and IDStatutCommande !=3" ;
        System.out.println(req);
        Connection cnt = mc.getConnection();
//        Statement stm = cnt.createStatement();
        PreparedStatement pstm = cnt.prepareStatement(req);
        pstm.setString(1, IDCompte);
//        
        List<Commande> com = new ArrayList<>();
        try {
            ResultSet rs = pstm.executeQuery(req);

                 
            while (rs.next()) {              
                
                String numCommande = rs.getString("IDCommande");
//                c.setIDCommande(numCommande);
                Date dateCommande = rs.getDate("dateCommande");
//                c.setDateCommande(dateCommande);
                Float montantCommande = rs.getFloat("montantCommande");
//                c.setMontantCommande(montantCommande);
                String statutCommande = rs.getString("descriptionStatut");
//                c.setDescriptionStatut(statutCommande);
                IDCompte = rs.getString("IDCompteCommande");  
                
                Commande c = new Commande(numCommande, dateCommande, montantCommande, statutCommande);
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
