package sql;

import getset.Variables;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class crudsql extends conexionSQL {

    java.sql.Statement st;
    ResultSet rs;
    Variables var = new Variables();

    public void insertar(String nombre, String apellido, String puesto, String correo) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "INSERT INTO empleado(nombre,apellido,puesto,correo) values('" + nombre + "', '" + apellido + "', '" + puesto + "', '" + correo + "');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void mostrar(String id){
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "SELECT * FROM empleado WHERE id=' " +id+" ' ;";
            rs = st.executeQuery(sql);
            if(rs.next() ){
                var.setId(rs.getString("id"));
                var.setNombre(rs.getString("nombre"));
                var.setApellido(rs.getString("apellido"));
                var.setPuesto(rs.getString("puesto"));
                var.setCorreo(rs.getString("correo"));
            }else {
                var.setId("");
                var.setNombre("");
                var.setApellido("");
                var.setPuesto("");
                var.setCorreo("");
                JOptionPane.showMessageDialog(null, "No se encontro registro", "Sin registro", JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el sistema de busqueda", "Error busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizar(String nombre, String apellido, String puesto, String correo, String id){
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "UPDATE empleado set nombre =' "+nombre+ " ', apellido = ' "+apellido+ " ' , puesto = ' "+puesto+ " ', correo = ' "+correo+ " ' WHERE id = ' "+id+ " '; ";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);
           st.close();
           conexion.close();
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el registro"+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminar(String id) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "DELETE FROM empleado WHERE id = '" +id+ "'; ";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro fue eliminado correctamente", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar registro"+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
