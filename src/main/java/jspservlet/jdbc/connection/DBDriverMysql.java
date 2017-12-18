/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jspservlet.jdbc.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import jspservlet.manager.ConfigurationManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author epam
 */
public class DBDriverMysql extends DBDriverBase{
    private static final String DRIVER_CLASS = "org.gjt.mm.mysql.Driver";
    private static final Logger logger = LogManager.getLogger(DBDriverMysql.class);

    public DBDriverMysql() throws ClassNotFoundException {
        super();
    }

    @Override
    public Connection getConnection() throws SQLException, NamingException {
        Context ctx = new InitialContext();
        DataSource dataSource = (DataSource) ctx.lookup(ConfigurationManager
                .getInstance()
                .getProperty(ConfigurationManager.DATABASE_MYSQL_NAMING_PATH));
        return dataSource.getConnection();
    }

    @Override
    public Connection restoreConnection(Database conn) throws SQLException, NamingException {
        if (conn.validate()) {
            return conn.getConnection();
        }
        return getConnection();
    }

}
