package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MaConnexion implements Serializable{
    private DataSource ds;

    public MaConnexion() throws NamingException {
        InitialContext context = new InitialContext();
        ds = (DataSource) context.lookup("jdbc/librairie");
    }
    
    public Connection getConnection() throws SQLException{
        Connection cnt = ds.getConnection();
        return cnt;
    }
    
    
}
