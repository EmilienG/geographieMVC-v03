
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import obj.Commande;


public class beanCommande implements Serializable {
    
    List<Commande> c;
    
    public beanCommande(){
        this.c = new ArrayList<>();
    }
    
    public void viewOrder(){
    
}
}
