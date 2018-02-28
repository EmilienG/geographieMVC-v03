
package traitements;

import accesBDD.CommandeDAO;
import java.io.Serializable;
import javax.naming.NamingException;


public class GestionCommandes implements Serializable {
    
    private CommandeDAO cDAO;
    
    public GestionCommandes() throws NamingException{
        cDAO = new CommandeDAO();
    }
    
//    public List<String> 
    
}
