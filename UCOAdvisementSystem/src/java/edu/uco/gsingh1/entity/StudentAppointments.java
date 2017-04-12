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
public class StudentAppointments {
    private int advisorId;
    private int userId;
    private int appointmentDay;
    private DateTime appointmentDate;
    private DateTime startTime;
    private DateTime endTime;
    private int status;
    private String cancelledByUserType;

    public String getCancelledByUserType() {
        return cancelledByUserType;
    }

    public void setCancelledByUserType(String cancelledByUserType) {
        this.cancelledByUserType = cancelledByUserType;
    }

    public int getCancelledByUserId() {
        return cancelledByUserId;
    }

    public void setCancelledByUserId(int cancelledByUserId) {
        this.cancelledByUserId = cancelledByUserId;
    }
    private int cancelledByUserId;

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
    
}
