package bibliotecaes2;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class Conexao {
    
    
    
    public static Connection con(){
        Properties p = new Properties();
        try {
            
            p.load(new FileInputStream("conn.properties"));
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(p);
        String url = p.getProperty("url");
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, p);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
}
