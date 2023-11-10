/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_1_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author Josep
 */
public class EVA3_1_MYSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Connection connection = null;
        
        
        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sakila";
            
            connection = DriverManager.getConnection(url, "root", "johervaz0799");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EVA3_1_MYSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EVA3_1_MYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            // Consulta

//            Statement statement = connection.createStatement();
//          ResultSet resu; 
//            resu = statement.executeQuery("SELECT actor_id, first_name, last_name" + " FROM actor LIMIT 10;");
//          

            String consulta = ("SELECT actor_id, first_name, last_name " + 
                    "FROM actor WHERE last_name LIKE concat(?, '%');" );
            
            System.out.println(consulta);
            
            PreparedStatement pState = connection.prepareStatement(consulta);
            
            pState.setString(1,"K");
            
            ResultSet resu;
            resu = pState.executeQuery();
            
            
            int actorId;
            String firstName;
            String lastName;
            
           while(resu.next()){
            actorId = resu.getInt("actor_id");
            firstName = resu.getString("first_name");
            lastName = resu.getString("last_name");
            System.out.println("Id del actor: " + actorId);
            System.out.println("Nombre del actor: " + firstName);
            System.out.println("Apellido del actor: " + lastName);
            System.out.println("----------------------------");
        }
          // Insertar valores  
//           String insertar = "INSERT INTO actor(first_name, last_name) " +
//                   "values(?,?);";
//           
//           PreparedStatement pSInsert = connection.prepareStatement(insertar);
//           
//           pSInsert.setString(1, "VLADIMIR");
//           pSInsert.setString(2, "GUILLE");
//           pSInsert.execute();
//           

            // Actualizar valores
//            String actualizar = "UPDATE actor SET first_name = ?, last_name = ? " +
//                   "WHERE actor_id = ?;";
//           
//           PreparedStatement pSUpdate = connection.prepareStatement(actualizar);
//           
//           pSUpdate.setString(1, "PIMWILLY");
//           pSUpdate.setString(2, "REGIL");
//           pSUpdate.setInt(3, 201);
//           pSUpdate.execute();
                
            String borrar = "DELETE FROM actor " +
                   "WHERE actor_id = ?;";
           
           PreparedStatement pSUpdate = connection.prepareStatement(borrar);
           
           pSUpdate.setInt(1, 201);
           pSUpdate.execute();

           
        } catch (SQLException ex) {
            Logger.getLogger(EVA3_1_MYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
