
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;



public class conexionSQL {
    Connection conn = null;
    String url = "jdbc:postgresql://localhost/CRUD";
    String user = "postgres";
    String pass = "poki2320";
    
    public Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }
}
