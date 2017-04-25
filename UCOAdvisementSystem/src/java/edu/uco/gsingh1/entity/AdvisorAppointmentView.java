/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.entity;

import org.joda.time.DateTime;

/**
 *
 * @author guru
 */
public class AdvisorAppointmentView {

    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public DateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(DateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public int getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(int bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getBookingStatusDescription() {
        return bookingStatusDescription;
    }

    public void setBookingStatusDescription(String bookingStatusDescription) {
        this.bookingStatusDescription = bookingStatusDescription;
    }

    public String getCancelledByUserType() {
        return cancelledByUserType;
    }

    public void setCancelledByUserType(String cancelledByUserType) {
        this.cancelledByUserType = cancelledByUserType;
    }

    public String getOutputAppointmentDate() {
        return outputAppointmentDate;
    }

    public void setOutputAppointmentDate(String outputAppointmentDate) {
        this.outputAppointmentDate = outputAppointmentDate;
    }

    public String getOutputAppointmentStartTime() {
        return outputAppointmentStartTime;
    }

    public void setOutputAppointmentStartTime(String outputAppointmentStartTime) {
        this.outputAppointmentStartTime = outputAppointmentStartTime;
    }

    public String getOutputAppointmentEndTime() {
        return outputAppointmentEndTime;
    }

    public void setOutputAppointmentEndTime(String outputAppointmentEndTime) {
        this.outputAppointmentEndTime = outputAppointmentEndTime;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getMajorid() {
        return majorid;
    }

    public void setMajorid(int majorid) {
        this.majorid = majorid;
    }
    private DateTime appointmentDate;
    private DateTime startTime;
    private DateTime endTime;
    private int bookingStatus;
    private String bookingStatusDescription;
    private String cancelledByUserType;
    private String outputAppointmentDate;
    private String outputAppointmentStartTime;
    private String outputAppointmentEndTime;
    private String statusDescription;
    private int appointmentId;
    private String firstname;
    private String lastname;
    private int majorid;
    private String studentId;
    private String studentEmail;

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentemail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

}
