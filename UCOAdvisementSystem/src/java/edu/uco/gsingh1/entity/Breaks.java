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
public class Breaks {
    private int advisorId;
    private int breakday;
    private DateTime breakFromTime;
    private DateTime breakToTime;
    private int breakId;
    private String outputBreakFromTime;
    private String breakWeekDay;

    public String getBreakWeekDay() {
        return breakWeekDay;
    }

    public void setBreakWeekDay(String breakWeekDay) {
        this.breakWeekDay = breakWeekDay;
    }

    public String getOutputBreakFromTime() {
        return outputBreakFromTime;
    }

    public void setOutputBreakFromTime(String outputBreakFromTime) {
        this.outputBreakFromTime = outputBreakFromTime;
    }

    public String getOutputBreakToTime() {
        return outputBreakToTime;
    }

    public void setOutputBreakToTime(String outputBreakToTime) {
        this.outputBreakToTime = outputBreakToTime;
    }
    private String outputBreakToTime;

    public int getBreakId() {
        return breakId;
    }

    public void setBreakId(int breakId) {
        this.breakId = breakId;
    }

    public int getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(int advisorId) {
        this.advisorId = advisorId;
    }

    public int getBreakday() {
        return breakday;
    }

    public void setBreakday(int breakday) {
        this.breakday = breakday;
    }

    public DateTime getBreakFromTime() {
        return breakFromTime;
    }

    public void setBreakFromTime(DateTime breakFromTime) {
        this.breakFromTime = breakFromTime;
    }

    public DateTime getBreakToTime() {
        return breakToTime;
    }

    public void setBreakToTime(DateTime breakToTime) {
        this.breakToTime = breakToTime;
    }
    
    
}
