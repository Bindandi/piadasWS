/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julio
 */
public class Conec_MySQL {
    
    private String url;
    private String usuario;
    private String senha;

    public Conec_MySQL() {
        url = "jdbc:mysql://den1.mysql6.gear.host/fippaulabindandi";
        usuario = "fippaulabindandi";
        senha = "julio1997#";
    }
    
    
    
    public Connection abre() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url,usuario, senha);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conec_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conec_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void fecha(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conec_MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
 
}
