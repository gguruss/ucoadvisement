/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import edu.uco.gsingh1.entity.Major;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

/**
 *
 * @author guru
 */
public interface MajorDAO {

    public ArrayList<Major> getAllMajor(DataSource ds) throws SQLException;
}
