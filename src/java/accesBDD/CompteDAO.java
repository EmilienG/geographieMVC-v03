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

    public Client ajoutClient(String nom, String prenom, String mdp, String email) throws SQLException {
        String req = "insert into Compte(IDPermissionCompte, nomCompte,prenomCompte,pseudoCompte,"
                + "MdPCompte,emailCompte,telephoneCompte,dateCreationCompte,"
                + "IDStatutCompte)Values(3,?,?,'',?,?,'',GETDATE(),3)";

        Client c = null;
        try (Connection cnt = mc.getConnection2();
                PreparedStatement pstm = cnt.prepareStatement(req);) {

            pstm.setString(1, nom);
            pstm.setString(2, prenom);
            pstm.setString(3, mdp);
            pstm.setString(4, email);

            pstm.executeUpdate();
        }
        return c;
    }
}
