package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import obj.Commande;

public class CommandeDAO implements Serializable {

    private MaConnexion mc;

    public CommandeDAO() throws NamingException {
        mc = new MaConnexion();
    }

    public List<Commande> selectAllOrder() throws SQLException {
        String req = "select c.IDCommande, c.IDAdresseFacturationCommande,c.IDAdresseLivraisonCommande,c.IDCompteCommande from Commande c order by c.IDCommande";
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();
        List<Commande> com = new ArrayList<>();
        try {
            ResultSet rs = stm.executeQuery(req);

            while (rs.next()) {
                String commande = rs.getString("IDCommande");
                String adresseFacturationCommande = rs.getString("IDAdresseFacturationCommande");
                String adresseLivraisonCommande = rs.getString("IDAdresseLivraisonCommande");
                String compteCommande = rs.getString("IDCompteCommande");
//                Commande c = new Commande(commande, adresseFacturationCommande, adresseLivraisonCommande, compteCommande);
//                com.add(c);
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
