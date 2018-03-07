package accesBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;
import obj.Client;

public class CompteDAO {

    private MaConnexion mc;

    public CompteDAO() throws NamingException {
        mc = new MaConnexion();
    }

    public Client ajoutClient(String nom, String prenom, String pseudo, String mdp, String email) throws SQLException {
        String req = "insert into Compte(IDPermissionCompte, nomCompte,prenomCompte,pseudoCompte,"
                + "MdPCompte,emailCompte,telephoneCompte,dateCreationCompte,"
                + "IDStatutCompte)Values(3,?,?,?,?,?,'',GETDATE(),3)";

        Client c = null;
        try (Connection cnt = mc.getConnection();
                PreparedStatement pstm = cnt.prepareStatement(req);) {

            pstm.setString(1, nom);
            pstm.setString(2, prenom);
            pstm.setString(3, pseudo);
            pstm.setString(4, mdp);
            pstm.setString(5, email);

            pstm.executeUpdate();
        }
        return c;
    }

    //Mettre PREPARE STATEMENT !!!!!
    public void modifClient(String IDcompte, String nom, String prenom, String pseudo, String email, String telephone, String password) throws SQLException {
        String req = "UPDATE compte"
                + " SET nomCompte = '" + nom + "'"
                + " SET prenomCompte = '" + prenom + "'"
                + " SET emailCompte = '" + email + "'"
                + " SET telephoneCompte = '" + telephone + "'"
                + " SET passwordCompte = '" + password + "'"
                + " WHERE IDCompte = '" + IDcompte + "'";
        System.out.println(req);
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
//            stm.setString(1, nom);
//            stm.setString(1, prenom);
//            stm.setString(1, email);
//            stm.setString(1, telephone);
//            stm.setString(1, password);
//            stm.executeQuery(req);
            stm.executeUpdate(req);
        }
    }
}
