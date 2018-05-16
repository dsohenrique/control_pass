
package br.com.controlpass.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class AbstractDAO {
     
    private Connection connection;
    
    public Connection getConnection() throws SQLException {
        
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionFactory().getConnection();
        }
        
        return connection;
    }
    
    public void closeConnection() {
        try {
            connection.close();
        } catch (Exception ex) {
        }
    }
    
    public void closeStatement(Statement stmt){
        try {
             stmt.close();
        } catch (Exception ex) {
        }
    }
    public void closeResultSet(ResultSet rs){
        try {
             rs.close();
        } catch (Exception ex) {
        }
    }
}
