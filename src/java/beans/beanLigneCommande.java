
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import obj.LigneCommande;


public class beanLigneCommande implements Serializable {
    
    List<LigneCommande> lc;
    
    public beanLigneCommande(){
        this.lc = new ArrayList<>();
    }
    
    public void viewOrderLine(){
        
    }
}
