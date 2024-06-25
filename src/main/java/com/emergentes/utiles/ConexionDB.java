package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    static public String driver = "com.mysql.cj.jdbc.Driver";
    static public String url = "jdbc:mysql://localhost:3306/bd_consultorio";
    static public String usuario = "root";
    static public String password = "";
    
    protected Connection conn = null;
    
    public ConexionDB(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            if(conn != null){
                System.out.println("CONEXION OK:  "+ conn);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR EN EL DRIVER:  "+ ex.getMessage());
            //Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("ERROR AL REALIZAR LA CONEXION:  "+ ex.getMessage());
            //Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection Conectar(){
        return conn;
    }
    
    public void Desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("ERROR AL CERRAR LA CONEXION:  "+ ex.getMessage());
            //Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
