/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class DBManager {
    
    public DBManager() {}
    private Connection connection = null;
    private Statement statement = null;
    private boolean flag_connect = false;
    
    public Connection getConnection() {
        return connection;
    }

    public void createConnection(String url, String name, String password) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url, name, password);
        statement = connection.createStatement();
        flag_connect = true;
    }

    /**
     * @return the flag_connect
     */
    public boolean isFlag_connect() {
        return flag_connect;
    }

    public void closeConnection() throws SQLException{
        connection.close();
        flag_connect = false;
    }
}
