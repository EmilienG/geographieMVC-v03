/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitements;

import accesBDD.ClientDAO;
import java.io.Serializable;
import java.sql.SQLException;
import javax.naming.NamingException;
import obj.Client;

/**
 *
 * @author badri
 */
public class GestionLogin implements Serializable{
      private  ClientDAO cDAO;

    public GestionLogin() throws NamingException {
        cDAO= new ClientDAO();
    }
    
    
    public boolean check(String pseudo, String password) {
        try {
            Client c;
            String monID = cDAO.selectIDClientByName(pseudo);
            c = cDAO.selectLoginByID(monID);            
            if( pseudo==null) return false;
            if( password==null) return false;
            if( pseudo.trim().isEmpty()) return false;
            if( password.trim().isEmpty()) return false;            
            if( pseudo.equals(c.getPseudo()))
                if( password.equals(c.getMDP()))
                    return true;            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }    
	
}
