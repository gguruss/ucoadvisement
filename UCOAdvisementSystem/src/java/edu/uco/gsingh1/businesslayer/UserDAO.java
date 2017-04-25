/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import edu.uco.gsingh1.entity.AppointmentView;
import edu.uco.gsingh1.entity.FileInfo;
import edu.uco.gsingh1.entity.Slots;
import edu.uco.gsingh1.entity.StudentAdvisementView;
import edu.uco.gsingh1.entity.StudentAppointments;
import edu.uco.gsingh1.entity.StudentCourses;
import edu.uco.gsingh1.entity.User;
import edu.uco.gsingh1.entity.UserView;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.joda.time.DateTime;

/**
 *
 * @author guru
 */
public interface UserDAO {

    public ArrayList<UserView> getAllUsers(DataSource ds) throws SQLException;

    public boolean insertUser(User user, DataSource ds) throws SQLException;

    public boolean updateUser(UserView user, DataSource ds) throws SQLException;

    public boolean deleteUser(String studentid, DataSource ds) throws SQLException;

    public User getUser(User user, DataSource ds) throws SQLException;

    public User verifyUser(String username, String password, DataSource ds) throws SQLException;

    public boolean checkIfStudentEmailRegistered(String username, DataSource ds) throws SQLException;

    public String getVerificationCode(String email, DataSource ds) throws SQLException;

    public Integer checkIfEmailExists(String email, DataSource ds) throws SQLException;

    public Integer checkIfStudentIdExists(String studentId, DataSource ds) throws SQLException;

    public UserView getUserView(String useremail, DataSource ds) throws SQLException;

    public Integer doCodeCheck(String username, String code, DataSource ds) throws SQLException;

    public boolean verifyStudent(String useremail, DataSource ds) throws SQLException;

    public ArrayList<StudentCourses> getStudentCourses(String useremail, DataSource ds) throws SQLException;

    public boolean addCoursesTakenByStudents(Integer userId, String useremail, String courseTaken, DataSource ds) throws SQLException;

    public boolean removeCourseTakenByStudent(Integer userId, String useremail, String courseToRemove, DataSource ds) throws SQLException;

    public ArrayList<Slots> getStudentSlots(DateTime userselectedDate, int advisorId, DataSource ds) throws SQLException;

    public boolean insertAppointment(StudentAppointments appointment, String useremail, DataSource ds) throws SQLException;

    public ArrayList<AppointmentView> getAppointments(String useremail, DataSource ds) throws SQLException;

    public boolean cancelAppointmentByStudent(Integer appointmentId, Integer userId, DataSource ds) throws SQLException;

    public FileInfo loadFileInfo(String userEmail, DataSource ds) throws SQLException;
    
     public ArrayList<StudentAdvisementView> getAllStudentAdvisementStatus(DataSource ds) throws SQLException;

    public boolean updateAdvisementStatus(int userId, DataSource ds) throws SQLException;
}
