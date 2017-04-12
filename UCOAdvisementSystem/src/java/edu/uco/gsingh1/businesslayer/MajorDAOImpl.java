/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import edu.uco.gsingh1.entity.Major;
import edu.uco.gsingh1.entity.MajorCourses;
import java.sql.CallableStatement;
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
public class MajorDAOImpl implements MajorDAO {

    @Override
    public ArrayList<Major> getAllMajor(DataSource ds) throws SQLException {
        ArrayList<Major> majors = new ArrayList<>();
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            PreparedStatement selectMajor = conn.prepareStatement(
                    "SELECT * FROM major");

            ResultSet result = selectMajor.executeQuery();
            while (result.next()) {
                Major major = new Major();
                major.setMajorcode(result.getInt("majorcode"));
                major.setMajor(result.getString("major"));
                major.setProgram(result.getString("program"));
                major.setDegree(result.getString("degree"));
                majors.add(major);
            }
        } finally {
            conn.close();
        }
        return majors;
    }

    @Override
    public ArrayList<MajorCourses> getMajorCourses(Integer majorid, DataSource ds) throws SQLException {
        ArrayList<MajorCourses> majorCourses = new ArrayList<>();
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            CallableStatement majorCourseView = conn.prepareCall("{CALL getMajorCourses(?)}");
            majorCourseView.setInt(1, majorid);
            boolean exists = majorCourseView.execute();
            if (exists) {
                ResultSet result = majorCourseView.getResultSet();
                while (result.next()) {
                    MajorCourses majorCourse = new MajorCourses();
                    majorCourse.setCourse(result.getString("majorprereqcourse"));
                    majorCourse.setCoursename(result.getString("coursetitle"));
                    majorCourses.add(majorCourse);
                }
            }

        } finally {
            conn.close();
        }
        return majorCourses;
    }

    @Override
    public ArrayList<MajorCourses> getMajorCoursesTakenByStudent(Integer majorid, Integer userid, DataSource ds) throws SQLException {
        ArrayList<MajorCourses> majorCourses = new ArrayList<>();
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            CallableStatement majorCourseView = conn.prepareCall("{CALL getMajorCoursesLeftToBeTaken(?,?)}");
            majorCourseView.setInt(1, majorid);
            majorCourseView.setInt(2, userid);
            boolean exists = majorCourseView.execute();
            if (exists) {
                ResultSet result = majorCourseView.getResultSet();
                while (result.next()) {
                    MajorCourses majorCourse = new MajorCourses();
                    majorCourse.setCourse(result.getString("majorprereqcourse"));
                    majorCourse.setCoursename(result.getString("coursetitle"));
                    majorCourses.add(majorCourse);
                }
            }

        } finally {
            conn.close();
        }
        return majorCourses;
    }
}
