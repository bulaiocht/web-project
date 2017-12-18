/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jspservlet.jdbc;

import jspservlet.jdbc.connection.DBDriverBase;
import jspservlet.jdbc.connection.Database;
import jspservlet.jdbc.core.Query;
import jspservlet.jdbc.connection.DBDriverFactory;
import jspservlet.jdbc.connection.DBTypes;

import java.sql.ResultSet;
/**
 *
 * @author epam
 */
public class TestConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        DBDriverBase dbDriver = DBDriverFactory.createDriver(DBTypes.MYSQL);
        Database jdbcConn = new Database(dbDriver, "jdbc:mysql://localhost:3306/epam_test", "root", "root");
        jdbcConn.connect();
        if (jdbcConn.validate()) {
            Query query = new Query(jdbcConn);
            ResultSet rs = query.executeQuery("select * from usersview");
            if (rs != null) {
                while (rs.next()) {
                    System.out.println("Login=" + rs.getString(2) + "; AccountStatus=" + rs.getString(3) + ";");
                }
            }
        } else {
            System.out.println("Database connection error. See log file for more info.");
        }
    }

}
