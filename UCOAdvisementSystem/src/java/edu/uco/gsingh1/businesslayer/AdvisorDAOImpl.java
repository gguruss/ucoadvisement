/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import edu.uco.gsingh1.entity.Advisor;
import edu.uco.gsingh1.entity.AdvisorAppointmentView;
import edu.uco.gsingh1.entity.AdvisorSchedule;
import edu.uco.gsingh1.entity.AppointmentView;
import edu.uco.gsingh1.entity.Breaks;
import java.io.UnsupportedEncodingException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author guru
 */
public class AdvisorDAOImpl implements AdvisorDAO {

    @Resource(name = "jdbc/ds_wsp")
    private DataSource ds;

    @Override
    public boolean addAdvisor(Advisor advisor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertAdvisorSchedule(AdvisorSchedule advisorschedule, DataSource ds) throws SQLException {
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            PreparedStatement insertQuery = conn.prepareStatement(
                    "INSERT INTO advisorschedule"
                    + "(advisorid,availday,availfromtime,availtotime,duration,availFrom,availTo) "
                    + "VALUES(?,?,?,?,?,?,?)");
            insertQuery.setInt(1, advisorschedule.getAdvisorId());
            insertQuery.setInt(2, advisorschedule.getAvailDay());
            insertQuery.setTime(3, new java.sql.Time(advisorschedule.getAvailFromTime().toDate().getTime()));
            insertQuery.setTime(4, new java.sql.Time(advisorschedule.getAvailToTime().toDate().getTime()));
            insertQuery.setInt(5, advisorschedule.getDuration());
            insertQuery.setDate(6, new java.sql.Date(advisorschedule.getAvailFromDate().toDate().getTime()));
            insertQuery.setDate(7, new java.sql.Date(advisorschedule.getAvailToDate().toDate().getTime()));
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
    public AdvisorSchedule getStartEndDateForAdvisor(int advisorId, DataSource ds) throws SQLException {
        AdvisorSchedule dates = new AdvisorSchedule();
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            PreparedStatement selectQuery = conn.prepareStatement(
                    "SELECT availFrom,availTo FROM advisorschedule WHERE advisorid=?");
            selectQuery.setInt(1, advisorId);

            ResultSet result = selectQuery.executeQuery();
            while (result.next()) {
                dates.setAvailFromDate(new DateTime(result.getDate("availFrom")));
                dates.setAvailToDate(new DateTime(result.getDate("availTo")));
            }

        } finally {
            conn.close();
        }
        return dates;
    }

    @Override
    public boolean insertAdvisorBreaks(Breaks breaks, DataSource ds) throws SQLException {
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            PreparedStatement insertQuery = conn.prepareStatement(
                    "INSERT INTO breaks"
                    + "(advisorid,breakday,start_time,end_time) "
                    + "VALUES(?,?,?,?)");
            insertQuery.setInt(1, breaks.getAdvisorId());
            insertQuery.setInt(2, breaks.getBreakday());
            insertQuery.setTime(3, new java.sql.Time(breaks.getBreakFromTime().toDate().getTime()));
            insertQuery.setTime(4, new java.sql.Time(breaks.getBreakToTime().toDate().getTime()));

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
    public ArrayList<Breaks> getBreaks(int advisorId, DataSource ds) throws SQLException {
        ArrayList<Breaks> advisorBreaks = new ArrayList<>();
        DateTimeFormatter fmtTime = DateTimeFormat.forPattern("HH:mm a");
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            PreparedStatement selectQuery = conn.prepareStatement(
                    "SELECT * FROM breakview WHERE advisorid=?");
            selectQuery.setInt(1, advisorId);

            ResultSet result = selectQuery.executeQuery();
            while (result.next()) {
                Breaks advisorBreak = new Breaks();
                advisorBreak.setBreakId(result.getInt("breakid"));
                advisorBreak.setBreakday(result.getInt("breakday"));
                advisorBreak.setBreakWeekDay(result.getString("dayname"));
                advisorBreak.setOutputBreakFromTime(fmtTime.print(new DateTime(result.getTimestamp("start_time"))));
                advisorBreak.setOutputBreakToTime(fmtTime.print(new DateTime(result.getTimestamp("end_time"))));
                advisorBreaks.add(advisorBreak);
            }

        } finally {
            conn.close();
        }
        return advisorBreaks;
    }

    @Override
    public boolean deleteBreaks(Breaks breaks, DataSource ds) throws SQLException {
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            PreparedStatement deleteQuery = conn.prepareStatement(
                    "DELETE FROM breaks WHERE breakid=?");
            deleteQuery.setInt(1, breaks.getBreakId());
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
    public ArrayList<AdvisorAppointmentView> getAppointments(String date, DataSource ds) throws SQLException {
        String selectedDate="";
        ArrayList<AdvisorAppointmentView> appointments = new ArrayList<>();
        DateTimeFormatter fmtDate = DateTimeFormat.forPattern("yyyy-MM-dd");
        if (!date.isEmpty()) {
            selectedDate = fmtDate.print(new DateTime(date));
        }
        DateTimeFormatter fmtTime = DateTimeFormat.forPattern("HH:mm a");
        DateTimeFormatter fmtDateTime = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        PreparedStatement selectQuery;
        try {
            if (date.isEmpty()) {
                selectQuery = conn.prepareStatement(
                        "SELECT * FROM advisorappointmentview");
            } else {
                selectQuery = conn.prepareStatement(
                        "SELECT * FROM advisorappointmentview WHERE appointmentdate=?");
                selectQuery.setDate(1, new java.sql.Date(new DateTime(selectedDate).toDate().getTime()));
            }

            ResultSet result = selectQuery.executeQuery();
            while (result.next()) {
                AdvisorAppointmentView appointment = new AdvisorAppointmentView();
                appointment.setAppointmentId(result.getInt("appointmentid"));
                appointment.setBookingStatusDescription(result.getString("bookingstatus"));
                appointment.setBookingStatus(result.getInt("status"));
                appointment.setUserId(result.getInt("userid"));
                appointment.setOutputAppointmentDate(fmtDate.print(new DateTime(result.getDate("appointmentdate"))));
                appointment.setOutputAppointmentStartTime(fmtTime.print(new DateTime(result.getTimestamp("starttime"))));
                appointment.setOutputAppointmentEndTime(fmtTime.print(new DateTime(result.getTimestamp("endtime"))));
                appointment.setFirstname(result.getString("firstname"));
                appointment.setLastname(result.getString("lastname"));
                appointment.setMajorid(result.getInt("majorid"));
                appointment.setStudentId(result.getString("studentid"));
                appointment.setStudentemail(result.getString("username"));
                appointments.add(appointment);
            }
        } finally {
            conn.close();
        }
        return appointments;
    }

    @Override
    public boolean cancelAppointmentByAdvisor(AdvisorAppointmentView appointment, Integer userid, DataSource ds) throws SQLException, UnsupportedEncodingException {
        if (ds == null) {
            throw new SQLException("Cannot get DataSource");
        }
        Connection conn = ds.getConnection();
        if (conn == null) {
            throw new SQLException("Cannot get connection");
        }
        try {
            PreparedStatement updateAppointmentStatus = conn.prepareStatement(
                    "UPDATE appointments SET status=?, cancelledbyuserid=? WHERE appointmentid=?");
            updateAppointmentStatus.setInt(1, -1);
            updateAppointmentStatus.setInt(2, userid);
            updateAppointmentStatus.setInt(3, appointment.getAppointmentId());
            int updated = updateAppointmentStatus.executeUpdate();
            if (updated == -1) {
                return false;
            }
        } finally {
            conn.close();
        }
        EmailHandler.sendAppointmentCancellation(appointment.getStudentEmail(), appointment.getOutputAppointmentDate(), appointment.getOutputAppointmentStartTime(), appointment.getOutputAppointmentEndTime());
        return true;
    }

}
