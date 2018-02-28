
package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import obj.LigneCommande;


public class LigneCommandeDAO implements Serializable{
    
    private MaConnexion mc;
    
    public LigneCommandeDAO() throws NamingException{
        mc = new MaConnexion();
    }
    
    public List<LigneCommande> selectAllOrderLine() throws SQLException{
        String req = "select * from LigneCommande ordey by IDLigneCommande";
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();
        String numCommande = null;
        String numLigneCommande = null;
        String livreLC = null;  
        Integer quantiteLC = null;
        Float tva = null;
        Float prixHT = null;
        
        List<LigneCommande> lcom = new ArrayList<>();
        try {
            ResultSet rs = stm.executeQuery(req);

            while (rs.next()) {
                LigneCommande lc = new LigneCommande();
                numCommande = rs.getString("IDCompteLigneCommande");
                lc.setIDCommandeLigneCommande(numCommande);
                numLigneCommande = rs.getString("IDLigneCommande");
                lc.setIDLigneCommande(numLigneCommande);
                livreLC = rs.getString("IDLivreLigneCommande");
                lc.setIDLivreLigneCommande(livreLC);
                quantiteLC = rs.getInt("quantiteLigneComande");
                lc.setQuantiteLigneCommande(quantiteLC);
                tva = rs.getFloat("TVALigneCommande");
                lc.setTVALigneCommande(tva);
                prixHT = rs.getFloat("prixHTLigneCommande");
                lc.setPrixHTLivreLigneCommande(prixHT);
                
                lcom.add(lc);
            }
            rs.close();
        }finally{
            if(cnt != null){
                cnt.close();
            }
        }
        return lcom;
        
    }
}
