    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jspservlet.jdbc.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author epam
 */
public abstract class DBDriverBase {

    private final int fetchSize;
    public static final int CONNECTION_VALIDATION_TIMEOUT = 5;
    private static final Logger logger = LogManager.getLogger(DBDriverBase.class);

    protected DBDriverBase() throws ClassNotFoundException {
        this.fetchSize = 20;
    }

    public abstract Connection getConnection() throws SQLException, NamingException;

    public abstract Connection restoreConnection(Database conn) throws SQLException, NamingException;

    public int getFetchSize(){
        return fetchSize;
    }
}
