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
public class AppointmentView {

    private int advisorId;
    private int userId;
    private int appointmentDay;
    private DateTime appointmentDate;
    private DateTime startTime;
    private DateTime endTime;
    private int status;
    private String cancelledByUserType;
    private String outputAppointmentDate;
    private String outputAppointmentStartTime;
    private String outputAppointmentEndTime;
    private String statusDescription;
    private String dayDescription;
    private int appointmentId;

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
    
    public int getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(int advisorId) {
        this.advisorId = advisorId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAppointmentDay() {
        return appointmentDay;
    }

    public void setAppointmentDay(int appointmentDay) {
        this.appointmentDay = appointmentDay;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getDayDescription() {
        return dayDescription;
    }

    public void setDayDescription(String dayDescription) {
        this.dayDescription = dayDescription;
    }

}
