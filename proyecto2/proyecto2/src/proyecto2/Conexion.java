/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
public class Conexion {
    
    Connection con = null;
    
    public Connection getConnection(){
 try{
     
     Class.forName("org.apache.derby.jdbc.ClientDriver");
     con = DriverManager.getConnection("jdbc:derby://localhost:1527/dato", "sebas", "1234");
     JOptionPane.showMessageDialog(null, "conexion realizada ");
 }catch(HeadlessException | ClassNotFoundException | SQLException e){
     JOptionPane.showMessageDialog(null, "Conexion  Fallida"+e.getMessage());
     
 } 
 return con;
}
    
    public ResultSet consulta(String consulta){
ResultSet rs = null;

try{
PreparedStatement ps= con.prepareStatement(consulta);
rs= ps.executeQuery();

}catch(Exception e){
JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
}
return rs;
}

 public void desconectar(){
     try{
         con.close();
     }catch(Exception e){
     }
     }
    
    
    
}
