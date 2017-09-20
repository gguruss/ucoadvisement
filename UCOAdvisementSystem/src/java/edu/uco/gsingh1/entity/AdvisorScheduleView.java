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
public class AdvisorScheduleView {

    private int dayNum;
    private String dayName;
    private int advisorId;
    private DateTime availFromTime;
    private DateTime availToTime;
    private Integer duration;
    private String outputStartTime;

    public String getOutputStartTime() {
        return outputStartTime;
    }

    public void setOutputStartTime(String outputStartTime) {
        this.outputStartTime = outputStartTime;
    }

    public String getOutputEndTime() {
        return outputEndTime;
    }

    public void setOutputEndTime(String outputEndTime) {
        this.outputEndTime = outputEndTime;
    }
    private String outputEndTime;

   
    public int getDayNum() {
        return dayNum;
    }

    public void setDayNum(int dayNum) {
        this.dayNum = dayNum;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public int getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(int advisorId) {
        this.advisorId = advisorId;
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
