/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class sql {
    
    
    public int id_incrementable(){
    int id =1;
    PreparedStatement ps =null;
    ResultSet rs =null; 
    Conexion db = new Conexion();
    
    try{
        ps=db.getConnection().prepareStatement("SELECT MAX(id_usuario) FROM usuario");
        rs=ps.executeQuery();
        while(rs.next()){
         id =rs.getInt(1)+1;
        }
            
    }catch(Exception e){
     System.out.println("Error"+e.getMessage());
    }
    finally{
        try{
            ps.close();
            rs.close();
            db.desconectar();
        }catch(Exception e){
        }
        }
    return id;
    }
    
}
