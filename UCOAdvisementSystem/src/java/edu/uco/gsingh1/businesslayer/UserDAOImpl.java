/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import edu.uco.gsingh1.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

/**
 *
 * @author guru
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public ArrayList<User> getAllUsers(DataSource ds) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertUser(User user, DataSource ds) throws SQLException {
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            PreparedStatement insertQuery = conn.prepareStatement(
                    "INSERT INTO usertable(firstname,middleinitial,lastname,ucoemail,password,usertype,studentid,majorid,phone) VALUES(?,?,?,?,?,?,?,?,?)");
            insertQuery.setString(1, user.firstname);
            insertQuery.setString(2, user.middleinitial);
            insertQuery.setString(3, user.lastname);
            insertQuery.setString(4, user.ucoemail);
            insertQuery.setString(5, user.password);
            insertQuery.setString(6, "student");
            insertQuery.setString(7, user.studentid);
            insertQuery.setInt(8, user.majorid);
            insertQuery.setString(9, user.phone);
            int result = insertQuery.executeUpdate();
            if (result == 1) {
                return true;
            }

        } finally {
            conn.close();
        }
        return false;
    }

    @Override
    public boolean updateUser(User user, DataSource ds) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteUser(User user, DataSource ds) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUser(User user, DataSource ds) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User verifyUser(String ucoemail, String password, DataSource ds) throws SQLException {
        User user = new User();
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            PreparedStatement selectQuery = conn.prepareStatement(
                    "SELECT * FROM usertable WHERE ucoemail=? AND password=?");
            selectQuery.setString(1, ucoemail);
            selectQuery.setString(2, password);

            ResultSet result = selectQuery.executeQuery();
            while (result.next()) {
                user.setUserid(result.getInt("userid"));
                user.setFirstname(result.getString("firstname"));
                user.setLastname(result.getString("lastname"));
                user.setStudentid(result.getString("studentid"));
                user.setMajorid(result.getInt("majorid"));
                user.setUsertype(result.getString("usertype"));
            }

        } finally {
            conn.close();
        }
        return user;
    }

    @Override
    public boolean checkIfStudentEmailRegistered(String ucoemail, DataSource ds) throws SQLException {
        User user = new User();
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            PreparedStatement selectQuery = conn.prepareStatement(
                    "SELECT count(*) FROM usertable WHERE ucoemail=?");
            selectQuery.setString(1, ucoemail);

            ResultSet result = selectQuery.executeQuery();
            while (result.next()) {
                int numberofRows = result.getInt(1);
                if (numberofRows > 0) {
                    return true; //will return true if there exists a student with the same email
                }
            }

        } finally {
            conn.close();
        }
        return false;
    }
}
