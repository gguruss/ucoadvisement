/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.validation.constraints.NotNull;

/**
 *
 * @author guru
 */
@Named(value = "publishDates")
@RequestScoped
public class PublishDates implements Serializable {

    @NotNull(message = "This is required")
    private Integer duration;

    private Date fromDate;
    private Date toDate;
    private Boolean monday;
    private Boolean tuesday;
    private Boolean wednesday;
    private Boolean thursday;
    private Boolean friday;
    private Boolean saturday;
    private Boolean sunday;

    @PostConstruct
    public void init() {

    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Boolean getMonday() {
        return monday;
    }

    public void setMonday(Boolean monday) {
        this.monday = monday;
    }

    public Boolean getTuesday() {
        return tuesday;
    }

    public void setTuesday(Boolean tuesday) {
        this.tuesday = tuesday;
    }

    public Boolean getWednesday() {
        return wednesday;
    }

    public void setWednesday(Boolean wednesday) {
        this.wednesday = wednesday;
    }

    public Boolean getThursday() {
        return thursday;
    }

    public void setThursday(Boolean thursday) {
        this.thursday = thursday;
    }

    public Boolean getFriday() {
        return friday;
    }

    public void setFriday(Boolean friday) {
        this.friday = friday;
    }

    public Boolean getSaturday() {
        return saturday;
    }

    public void setSaturday(Boolean saturday) {
        this.saturday = saturday;
    }

    public Boolean getSunday() {
        return sunday;
    }

    public void setSunday(Boolean sunday) {
        this.sunday = sunday;
    }

    private Date mondayFromTime;

    public Date getMondayFromTime() {
        return mondayFromTime;
    }

    public void setMondayFromTime(Date mondayFromTime) {
        this.mondayFromTime = mondayFromTime;
    }

    public Date getTuesdayFromTime() {
        return tuesdayFromTime;
    }

    public void setTuesdayFromTime(Date tuesdayFromTime) {
        this.tuesdayFromTime = tuesdayFromTime;
    }

    public Date getWednesdayFromTime() {
        return wednesdayFromTime;
    }

    public void setWednesdayFromTime(Date wednesdayFromTime) {
        this.wednesdayFromTime = wednesdayFromTime;
    }

    public Date getThursdayFromTime() {
        return thursdayFromTime;
    }

    public void setThursdayFromTime(Date thursdayFromTime) {
        this.thursdayFromTime = thursdayFromTime;
    }

    public Date getFridayFromTime() {
        return fridayFromTime;
    }

    public void setFridayFromTime(Date fridayFromTime) {
        this.fridayFromTime = fridayFromTime;
    }

    public Date getSaturdayFromTime() {
        return saturdayFromTime;
    }

    public void setSaturdayFromTime(Date saturdayFromTime) {
        this.saturdayFromTime = saturdayFromTime;
    }

    public Date getSundayFromTime() {
        return sundayFromTime;
    }

    public void setSundayFromTime(Date sundayFromTime) {
        this.sundayFromTime = sundayFromTime;
    }

    public Date getMondayToTime() {
        return mondayToTime;
    }

    public void setMondayToTime(Date mondayToTime) {
        this.mondayToTime = mondayToTime;
    }

    public Date getTuesdayToTime() {
        return tuesdayToTime;
    }

    public void setTuesdayToTime(Date tuesdayToTime) {
        this.tuesdayToTime = tuesdayToTime;
    }

    public Date getWednesdayToTime() {
        return wednesdayToTime;
    }

    public void setWednesdayToTime(Date wednesdayToTime) {
        this.wednesdayToTime = wednesdayToTime;
    }

    public Date getThursdayToTime() {
        return thursdayToTime;
    }

    public void setThursdayToTime(Date thursdayToTime) {
        this.thursdayToTime = thursdayToTime;
    }

    public Date getFridayToTime() {
        return fridayToTime;
    }

    public void setFridayToTime(Date fridayToTime) {
        this.fridayToTime = fridayToTime;
    }

    public Date getSaturdayToTime() {
        return saturdayToTime;
    }

    public void setSaturdayToTime(Date saturdayToTime) {
        this.saturdayToTime = saturdayToTime;
    }

    public Date getSundayToTime() {
        return sundayToTime;
    }

    public void setSundayToTime(Date sundayToTime) {
        this.sundayToTime = sundayToTime;
    }
    private Date tuesdayFromTime;
    private Date wednesdayFromTime;
    private Date thursdayFromTime;
    private Date fridayFromTime;
    private Date saturdayFromTime;
    private Date sundayFromTime;
    private Date mondayToTime;
    private Date tuesdayToTime;
    private Date wednesdayToTime;
    private Date thursdayToTime;
    private Date fridayToTime;
    private Date saturdayToTime;
    private Date sundayToTime;

    public void save() {
        if (monday) {
            Date time = getMondayFromTime();
        }
    }

}
