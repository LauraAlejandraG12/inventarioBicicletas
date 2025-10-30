package db;

import java.sql.Connection;  /*Representa la conexion de la base de datos */
import java.sql.DriverManager; /* Se encarga de crear la conexion */
import java.sql.SQLException;  /*Se encarga de manejar errorer de la base de datos */



public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/inventariob";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    /* Método para obetener la conexcion de la base de datos */
     
    /**
     * @return  
     * @throws SQLException controla errores de conectividad
     */
      
   /*Ese tipo de comentario sirve para */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
