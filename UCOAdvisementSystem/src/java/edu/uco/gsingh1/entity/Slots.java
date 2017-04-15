/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.entity;

import java.sql.Time;
import java.sql.Timestamp;
import org.joda.time.DateTime;

/**
 *
 * @author guru
 */
public class Slots {

    private DateTime slotStartDateTime;

    public DateTime getSlotStartDateTime() {
        return slotStartDateTime;
    }

    public void setSlotStartDateTime(DateTime slotStartDateTime) {
        this.slotStartDateTime = slotStartDateTime;
    }

    public DateTime getSlotEndDateTime() {
        return slotEndDateTime;
    }

    public void setSlotEndDateTime(DateTime slotEndDateTime) {
        this.slotEndDateTime = slotEndDateTime;
    }
    private DateTime slotEndDateTime;

    private String outputSlotStartDateTime;

    public String getOutputSlotStartDateTime() {
        return outputSlotStartDateTime;
    }

    public void setOutputSlotStartDateTime(String outputSlotStartDateTime) {
        this.outputSlotStartDateTime = outputSlotStartDateTime;
    }

    public String getOutputSlotEndDateTime() {
        return outputSlotEndDateTime;
    }

    public void setOutputSlotEndDateTime(String outputSlotEndDateTime) {
        this.outputSlotEndDateTime = outputSlotEndDateTime;
    }
    private String outputSlotEndDateTime;
    
    private String availableDate;

    public String getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(String availableDate) {
        this.availableDate = availableDate;
    }
    
    private String testDate;

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }
}
