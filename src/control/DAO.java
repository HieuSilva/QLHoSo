/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HIEU
 */
public class DAO {
    private Connection conn;
    private String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
    private String dbURL = "jdbc:sqlserver://localhost\\EVALUATION_2:1433; databasename=HTTTQL; username=sa; password=12345678";
    
    public DAO() {
        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean checkLogin(String username, String password) {
        int check = 0;
        try {
            CallableStatement call = conn.prepareCall("{call login(?,?,?)}");
            call.setString(1, username);
            call.setString(2, password);
            call.registerOutParameter(3, Types.INTEGER);
            call.executeUpdate();
            check = call.getInt(3);
            return (check == 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error!");
            e.printStackTrace();
            return false;
        }
    }
}
