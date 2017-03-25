/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import edu.uco.gsingh1.entity.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
                    "INSERT INTO usertable(firstname,middleinitial,lastname,username,password,usertype,studentid,majorid,phone,randomcode) VALUES(?,?,?,?,?,?,?,?,?,?)");
            insertQuery.setString(1, user.firstname);
            insertQuery.setString(2, user.middleinitial);
            insertQuery.setString(3, user.lastname);
            insertQuery.setString(4, user.username);
            insertQuery.setString(5, user.password);
            insertQuery.setString(6, "student");
            insertQuery.setString(7, user.studentid);
            insertQuery.setInt(8, user.majorid);
            insertQuery.setString(9, user.phone);
            insertQuery.setString(10, user.randomcode);
            int result = insertQuery.executeUpdate();
            if (result == 1) {
                String verifCode = getVerificationCode(user.username, ds);
                if (verifCode.length() > 0) {
                    EmailHandler.sendEmail(user.username, verifCode);
                }
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
    public User verifyUser(String username, String password, DataSource ds) throws SQLException {
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
                    "SELECT * FROM usertable WHERE username=? AND password=?");
            selectQuery.setString(1, username);
            selectQuery.setString(2, password);

            ResultSet result = selectQuery.executeQuery();
            while (result.next()) {
                user.setUserid(result.getInt("userid"));
                user.setFirstname(result.getString("firstname"));
                user.setLastname(result.getString("lastname"));
                user.setStudentid(result.getString("studentid"));
                user.setMajorid(result.getInt("majorid"));
                user.setUsertype(result.getString("usertype"));
                user.setIsuserverified(result.getInt("isverified"));
            }

        } finally {
            conn.close();
        }
        return user;
    }

    @Override
    public boolean checkIfStudentEmailRegistered(String username, DataSource ds) throws SQLException {
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            PreparedStatement selectQuery = conn.prepareStatement(
                    "SELECT count(*) FROM usertable WHERE username=?");
            selectQuery.setString(1, username);

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

    @Override
    public String getVerificationCode(String email, DataSource ds) throws SQLException {
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            CallableStatement getVerificationCodeQuery = conn.prepareCall("{ ? = CALL getVerCode(?)}");
            getVerificationCodeQuery.registerOutParameter(1, Types.VARCHAR);
            getVerificationCodeQuery.setString(2, email);
            getVerificationCodeQuery.execute();
            String verificationCode = getVerificationCodeQuery.getString(1);
            return verificationCode;

        } finally {
            conn.close();
        }
    }
}
