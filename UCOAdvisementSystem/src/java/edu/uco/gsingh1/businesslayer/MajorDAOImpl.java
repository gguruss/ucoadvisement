/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import edu.uco.gsingh1.entity.Major;
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

  
}
