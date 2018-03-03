package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MaConnexion implements Serializable{
    private DataSource ds;

    private DataSource ds1;


    public MaConnexion() throws NamingException {
//        System.out.println(">>>>MaConnexion");
        InitialContext context = new InitialContext();
        ds = (DataSource) context.lookup("jdbc/librairie");
        ds1 = (DataSource) context.lookup("jdbc/maBase");

    }
    
    public Connection getConnection() throws SQLException{
        Connection cnt = ds.getConnection();
        return cnt;

    }    
    public Connection getConnection2() throws SQLException{
        Connection cnt = ds1.getConnection();
        return cnt;

    }
    
    
}
