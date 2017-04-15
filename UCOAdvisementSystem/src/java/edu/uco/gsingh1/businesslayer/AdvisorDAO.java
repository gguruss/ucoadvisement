/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import edu.uco.gsingh1.entity.Advisor;
import edu.uco.gsingh1.entity.AdvisorSchedule;
import edu.uco.gsingh1.entity.Breaks;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

/**
 *
 * @author guru
 */
public interface AdvisorDAO {

    public boolean addAdvisor(Advisor advisor);

    public boolean insertAdvisorSchedule(AdvisorSchedule advisorschedule, DataSource ds) throws SQLException;
    
    public boolean insertAdvisorBreaks(Breaks breaks, DataSource ds) throws SQLException;
    
    public boolean deleteBreaks(Breaks breaks, DataSource ds) throws SQLException;
    
    public AdvisorSchedule getStartEndDateForAdvisor(int advisorId, DataSource ds) throws SQLException;
    
    public ArrayList<Breaks> getBreaks(int advisorId, DataSource ds) throws SQLException;
}
