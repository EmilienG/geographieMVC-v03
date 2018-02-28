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

    public List<Commande> selectAllOrder() throws SQLException {
        String req = "select * from Commande ordey by IDCommande";
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();
        String compteCommande = null;
        String numCommande = null;
        Date dateCommande = null;  
        Float montantCommande = null;
        
        List<Commande> com = new ArrayList<>();
        try {
            ResultSet rs = stm.executeQuery(req);

            while (rs.next()) {
                Commande c = new Commande();
                compteCommande = rs.getString("IDCompteCommande");
                c.setIDCompteCommande(compteCommande);
                numCommande = rs.getString("IDCommande");
                c.setIDCommande(numCommande);
                dateCommande = rs.getDate("dateCommande");
                c.setDateCommande(dateCommande);
                montantCommande = rs.getFloat("montantComande");
                c.setMontantCommande(montantCommande);
                
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
