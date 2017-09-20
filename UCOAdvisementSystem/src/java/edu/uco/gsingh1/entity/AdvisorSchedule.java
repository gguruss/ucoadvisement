/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.entity;

import java.sql.Time;
import org.joda.time.DateTime;


/**
 *
 * @author guru
 */
public class AdvisorSchedule {

    private int advisorScheduleId;
    private int advisorId;
    private Integer availDay;
    private DateTime availFromDate;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public DateTime getAvailFromDate() {
        return availFromDate;
    }

    public void setAvailFromDate(DateTime availFromDate) {
        this.availFromDate = availFromDate;
    }

    public DateTime getAvailToDate() {
        return availToDate;
    }

    public void setAvailToDate(DateTime availToDate) {
        this.availToDate = availToDate;
    }
    private DateTime availToDate;
    private DateTime availFromTime;
    private DateTime availToTime;
    private Integer duration;

    public int getAdvisorScheduleId() {
        return advisorScheduleId;
    }

    public void setAdvisorScheduleId(int advisorScheduleId) {
        this.advisorScheduleId = advisorScheduleId;
    }

    public int getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(int advisorId) {
        this.advisorId = advisorId;
    }

    public Integer getAvailDay() {
        return availDay;
    }

    public void setAvailDay(Integer availDay) {
        this.availDay = availDay;
    }

    public DateTime getAvailFromTime() {
        return availFromTime;
    }

    public void setAvailFromTime(DateTime availFromTime) {
        this.availFromTime = availFromTime;
    }

    public DateTime getAvailToTime() {
        return availToTime;
    }

    public void setAvailToTime(DateTime availToTime) {
        this.availToTime = availToTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

}
