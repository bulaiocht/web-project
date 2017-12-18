/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jspservlet.jdbc.dao;


import jspservlet.jdbc.connection.Database;

/**
 *
 * @author epam
 */
public class UsersviewDaoFactory {

    public static UsersviewDao create(Database db) {
        return new UsersviewDaoImpl(db);
    }

}
