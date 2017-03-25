/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import edu.uco.gsingh1.entity.User;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

/**
 *
 * @author guru
 */
public interface UserDAO {

    public ArrayList<User> getAllUsers(DataSource ds) throws SQLException;

    public boolean insertUser(User user, DataSource ds) throws SQLException;

    public boolean updateUser(User user, DataSource ds) throws SQLException;

    public boolean deleteUser(User user, DataSource ds) throws SQLException;

    public User getUser(User user, DataSource ds) throws SQLException;

    public User verifyUser(String username, String password, DataSource ds) throws SQLException;

    public boolean checkIfStudentEmailRegistered(String username, DataSource ds) throws SQLException;

    public String getVerificationCode(String email, DataSource ds) throws SQLException;

    public Integer checkIfEmailExists(String email, DataSource ds) throws SQLException;

    public Integer checkIfStudentIdExists(String studentId, DataSource ds) throws SQLException;
}
