/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import edu.uco.gsingh1.entity.StudentCourses;
import edu.uco.gsingh1.entity.User;
import edu.uco.gsingh1.entity.UserView;
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
    public ArrayList<UserView> getAllUsers(DataSource ds) throws SQLException {
        ArrayList<UserView> users = new ArrayList<>();
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            PreparedStatement selectQuery = conn.prepareStatement(
                    "SELECT * FROM userview");
            ResultSet result = selectQuery.executeQuery();
            while (result.next()) {
                UserView user = new UserView();
                user.setUserid(result.getInt("userid"));
                user.setFirstname(result.getString("firstname"));
                user.setLastname(result.getString("lastname"));
                user.setStudentid(result.getString("studentid"));
                user.setMajor(result.getString("major"));
                user.setDegree(result.getString("degree"));
                user.setPhone(result.getString("phone"));
                user.setEditable(false);
                users.add(user);
            }

        } finally {
            conn.close();
        }
        return users;
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
            insertQuery.setString(1, user.firstname.toLowerCase().trim());
            insertQuery.setString(2, user.middleinitial.toLowerCase().trim());
            insertQuery.setString(3, user.lastname.toLowerCase().trim());
            insertQuery.setString(4, user.username.toLowerCase().trim());
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
    public boolean updateUser(UserView user, DataSource ds) throws SQLException {
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            PreparedStatement updateQuery = conn.prepareStatement(
                    "UPDATE usertable SET studentid=?, majorid=?,phone=?, firstname=?, lastname=? WHERE userid=?");
            updateQuery.setString(1, user.studentid);
            updateQuery.setInt(2, user.majorcode);
            updateQuery.setString(3, user.phone);
            updateQuery.setString(4, user.firstname);
            updateQuery.setString(5, user.lastname);
            updateQuery.setInt(6, user.userid);
            int updated = updateQuery.executeUpdate();
            if (updated == -1) {
                return false;
            }
        } finally {
            conn.close();
        }
        return true;
    }

    @Override
    public boolean deleteUser(String studentId, DataSource ds) throws SQLException {
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            PreparedStatement deleteQuery = conn.prepareStatement(
                    "DELETE FROM usertable WHERE studentid=?");
            deleteQuery.setString(1, studentId);
            int deleted = deleteQuery.executeUpdate();
            if (deleted == -1) {
                return false;
            }
        } finally {
            conn.close();
        }
        return true;
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
            selectQuery.setString(1, username.toLowerCase().trim());
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
            selectQuery.setString(1, username.toLowerCase().trim());

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

    @Override
    public Integer checkIfEmailExists(String email, DataSource ds) throws SQLException {
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            CallableStatement verifyEmail = conn.prepareCall("{ ? = CALL checkIfEmailExists(?)}");
            verifyEmail.registerOutParameter(1, Types.SMALLINT);
            verifyEmail.setString(2, email);
            verifyEmail.execute();
            Integer exists = verifyEmail.getInt(1);
            return exists;

        } finally {
            conn.close();
        }
    }

    @Override
    public Integer checkIfStudentIdExists(String studentId, DataSource ds) throws SQLException {
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            CallableStatement verifyStudentId = conn.prepareCall("{ ? = CALL checkIfStudentIdExists(?)}");
            verifyStudentId.registerOutParameter(1, Types.SMALLINT);
            verifyStudentId.setString(2, studentId);
            verifyStudentId.execute();
            Integer exists = verifyStudentId.getInt(1);
            return exists;

        } finally {
            conn.close();
        }
    }

    @Override
    public Integer doCodeCheck(String username, String code, DataSource ds) throws SQLException {
        Integer verified = 0;
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            CallableStatement verifyCodeForUser = conn.prepareCall("{ ? = CALL checkVerificationCodeForUser(?,?)}");
            verifyCodeForUser.registerOutParameter(1, Types.SMALLINT);
            verifyCodeForUser.setString(2, username);
            verifyCodeForUser.setString(3, code);
            verifyCodeForUser.execute();
            verified = verifyCodeForUser.getInt(1);
            return verified;

        } finally {
            conn.close();
        }
    }

    @Override
    public UserView getUserView(String useremail, DataSource ds) throws SQLException {
        UserView user = new UserView();
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            CallableStatement userView = conn.prepareCall("{CALL getUserDetail(?)}");
            userView.setString(1, useremail);
            boolean exists = userView.execute();
            if (exists) {
                ResultSet result = userView.getResultSet();
                while (result.next()) {
                    user.setUserid(result.getInt("userid"));
                    user.setFirstname(result.getString("firstname"));
                    user.setMiddleinitial(result.getString("middleinitial"));
                    user.setLastname(result.getString("lastname"));
                    user.setStudentid(result.getString("studentid"));
                    user.setMajorcode(result.getInt("majorcode"));
                    user.setMajor(result.getString("major"));
                    user.setDegree(result.getString("degree"));
                }
            }

        } finally {
            conn.close();
        }
        return user;
    }

    @Override
    public boolean verifyStudent(String useremail, DataSource ds) throws SQLException {
        User user = new User();
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            PreparedStatement updateQuery = conn.prepareStatement(
                    "UPDATE usertable SET isverified=1 WHERE username=?");
            updateQuery.setString(1, useremail.toLowerCase().trim());

            int result = updateQuery.executeUpdate();
            if (result == 1) {
                return true;
            }

        } finally {
            conn.close();
        }
        return false;

    }

    @Override
    public ArrayList<StudentCourses> getStudentCourses(String useremail, DataSource ds) throws SQLException {
        ArrayList<StudentCourses> studentCourses = new ArrayList<>();
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            CallableStatement studentCourseView = conn.prepareCall("{CALL getCoursesTakenByStudents(?)}");
            studentCourseView.setString(1, useremail);
            boolean exists = studentCourseView.execute();
            if (exists) {
                ResultSet result = studentCourseView.getResultSet();
                while (result.next()) {
                    StudentCourses studentCourse = new StudentCourses();
                    studentCourse.setCourse(result.getString("scourse"));
                    studentCourse.setCoursename(result.getString("coursetitle"));
                    studentCourses.add(studentCourse);
                }
            }

        } finally {
            conn.close();
        }
        return studentCourses;
    }

    @Override
    public boolean addCoursesTakenByStudents(Integer userId, String useremail, String courseTaken, DataSource ds) throws SQLException {
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            PreparedStatement insertQuery = conn.prepareStatement(
                    "INSERT INTO studentcourses(suid,scourse,susername) VALUES(?,?,?)");
            insertQuery.setInt(1, userId);
            insertQuery.setString(2, courseTaken);
            insertQuery.setString(3, useremail);

            int result = insertQuery.executeUpdate();
            if (result == 1) {
                return true;
            }

        } finally {
            conn.close();
        }
        return false;
    }
}
