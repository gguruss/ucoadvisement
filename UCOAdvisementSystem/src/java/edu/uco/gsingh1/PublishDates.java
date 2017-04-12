/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1;

import edu.uco.gsingh1.businesslayer.AdvisorDAO;
import edu.uco.gsingh1.businesslayer.AdvisorDAOImpl;
import edu.uco.gsingh1.businesslayer.DateUtil;
import edu.uco.gsingh1.businesslayer.Utility;
import edu.uco.gsingh1.entity.AdvisorSchedule;
import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author guru
 */
@Named(value = "publishDates")
@RequestScoped
public class PublishDates implements Serializable {

    @Resource(name = "jdbc/ds_wsp")
    private DataSource ds;
    @Inject
    private LoginBean loginBean;
    @NotNull(message = "This is required.")
    private Integer duration;
    @NotEmpty(message = "This is a required field.")
    private String fromDate;

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    @NotEmpty(message = "This is a required field.")
    private String toDate;
    private Boolean monday;
    private Boolean tuesday;
    private Boolean wednesday;
    private Boolean thursday;
    private Boolean friday;
    private Boolean saturday;
    private Boolean sunday;
    private ArrayList<AdvisorSchedule> advisorSchedules;
    private AdvisorSchedule advisorSchedule;

    public ArrayList<AdvisorSchedule> getAdvisorSchedules() {
        return advisorSchedules;
    }

    public void setAdvisorSchedules(ArrayList<AdvisorSchedule> advisorSchedule) {
        this.advisorSchedules = advisorSchedule;
    }

    @PostConstruct
    public void init() {
        setMonday(false);
        setTuesday(false);
        setWednesday(false);
        setThursday(false);
        setFriday(false);
        setSaturday(false);
        setSunday(false);
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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

    private String mondayFromTime;
    private String tuesdayFromTime;
    private String wednesdayFromTime;
    private String thursdayFromTime;
    private String fridayFromTime;
    private String saturdayFromTime;
    private String sundayFromTime;
    private String mondayToTime;
    private String tuesdayToTime;
    private String wednesdayToTime;
    private String thursdayToTime;
    private String fridayToTime;
    private String saturdayToTime;
    private String sundayToTime;

    public String getMondayFromTime() {
        return mondayFromTime;
    }

    public void setMondayFromTime(String mondayFromTime) {
        this.mondayFromTime = mondayFromTime;
    }

    public String getTuesdayFromTime() {
        return tuesdayFromTime;
    }

    public void setTuesdayFromTime(String tuesdayFromTime) {
        this.tuesdayFromTime = tuesdayFromTime;
    }

    public String getWednesdayFromTime() {
        return wednesdayFromTime;
    }

    public void setWednesdayFromTime(String wednesdayFromTime) {
        this.wednesdayFromTime = wednesdayFromTime;
    }

    public String getThursdayFromTime() {
        return thursdayFromTime;
    }

    public void setThursdayFromTime(String thursdayFromTime) {
        this.thursdayFromTime = thursdayFromTime;
    }

    public String getFridayFromTime() {
        return fridayFromTime;
    }

    public void setFridayFromTime(String fridayFromTime) {
        this.fridayFromTime = fridayFromTime;
    }

    public String getSaturdayFromTime() {
        return saturdayFromTime;
    }

    public void setSaturdayFromTime(String saturdayFromTime) {
        this.saturdayFromTime = saturdayFromTime;
    }

    public String getSundayFromTime() {
        return sundayFromTime;
    }

    public void setSundayFromTime(String sundayFromTime) {
        this.sundayFromTime = sundayFromTime;
    }

    public String getMondayToTime() {
        return mondayToTime;
    }

    public void setMondayToTime(String mondayToTime) {
        this.mondayToTime = mondayToTime;
    }

    public String getTuesdayToTime() {
        return tuesdayToTime;
    }

    public void setTuesdayToTime(String tuesdayToTime) {
        this.tuesdayToTime = tuesdayToTime;
    }

    public String getWednesdayToTime() {
        return wednesdayToTime;
    }

    public void setWednesdayToTime(String wednesdayToTime) {
        this.wednesdayToTime = wednesdayToTime;
    }

    public String getThursdayToTime() {
        return thursdayToTime;
    }

    public void setThursdayToTime(String thursdayToTime) {
        this.thursdayToTime = thursdayToTime;
    }

    public String getFridayToTime() {
        return fridayToTime;
    }

    public void setFridayToTime(String fridayToTime) {
        this.fridayToTime = fridayToTime;
    }

    public String getSaturdayToTime() {
        return saturdayToTime;
    }

    public void setSaturdayToTime(String saturdayToTime) {
        this.saturdayToTime = saturdayToTime;
    }

    public String getSundayToTime() {
        return sundayToTime;
    }

    public void setSundayToTime(String sundayToTime) {
        this.sundayToTime = sundayToTime;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public String save() {
        advisorSchedules = new ArrayList<>();
        if (monday) {
            advisorSchedule = new AdvisorSchedule();
            advisorSchedule.setDuration(getDuration());
            advisorSchedule.setAdvisorId(loginBean.getUser().userid);
            advisorSchedule.setAvailDay(2);
            advisorSchedule.setAvailFromDate(Utility.getDate(getFromDate()));
            advisorSchedule.setAvailToDate(Utility.getDate(getToDate()));
            advisorSchedule.setAvailFromTime(Utility.getTime(getMondayFromTime()));
            advisorSchedule.setAvailToTime(Utility.getTime(getMondayToTime()));
            advisorSchedules.add(advisorSchedule);
        }
        if (tuesday) {
            advisorSchedule = new AdvisorSchedule();
            advisorSchedule.setDuration(getDuration());
            advisorSchedule.setAdvisorId(loginBean.getUser().userid);
            advisorSchedule.setAvailDay(3);
            advisorSchedule.setAvailFromTime(Utility.getTime(getTuesdayFromTime()));
            advisorSchedule.setAvailToTime(Utility.getTime(getTuesdayToTime()));
            advisorSchedule.setAvailFromDate(Utility.getDate(getFromDate()));
            advisorSchedule.setAvailToDate(Utility.getDate(getToDate()));
            advisorSchedules.add(advisorSchedule);
        }
        if (wednesday) {
            advisorSchedule = new AdvisorSchedule();
            advisorSchedule.setDuration(getDuration());
            advisorSchedule.setAdvisorId(loginBean.getUser().userid);
            advisorSchedule.setAvailDay(4);
            advisorSchedule.setAvailFromTime(Utility.getTime(getWednesdayFromTime()));
            advisorSchedule.setAvailToTime(Utility.getTime(getWednesdayToTime()));
            advisorSchedule.setAvailFromDate(Utility.getDate(getFromDate()));
            advisorSchedule.setAvailToDate(Utility.getDate(getToDate()));
            advisorSchedules.add(advisorSchedule);
        }
        if (thursday) {
            advisorSchedule = new AdvisorSchedule();
            advisorSchedule.setDuration(getDuration());
            advisorSchedule.setAdvisorId(loginBean.getUser().userid);
            advisorSchedule.setAvailDay(5);
            advisorSchedule.setAvailFromTime(Utility.getTime(getThursdayFromTime()));
            advisorSchedule.setAvailToTime(Utility.getTime(getThursdayToTime()));
            advisorSchedule.setAvailFromDate(Utility.getDate(getFromDate()));
            advisorSchedule.setAvailToDate(Utility.getDate(getToDate()));
            advisorSchedules.add(advisorSchedule);
        }
        if (friday) {
            advisorSchedule = new AdvisorSchedule();
            advisorSchedule.setDuration(getDuration());
            advisorSchedule.setAdvisorId(loginBean.getUser().userid);
            advisorSchedule.setAvailDay(6);
            advisorSchedule.setAvailFromTime(Utility.getTime(getFridayFromTime()));
            advisorSchedule.setAvailToTime(Utility.getTime(getFridayToTime()));
            advisorSchedule.setAvailFromDate(Utility.getDate(getFromDate()));
            advisorSchedule.setAvailToDate(Utility.getDate(getToDate()));
            advisorSchedules.add(advisorSchedule);
        }
        if (saturday) {
            advisorSchedule = new AdvisorSchedule();
            advisorSchedule.setDuration(getDuration());
            advisorSchedule.setAdvisorId(loginBean.getUser().userid);
            advisorSchedule.setAvailDay(7);
            advisorSchedule.setAvailFromTime(Utility.getTime(getSaturdayFromTime()));
            advisorSchedule.setAvailToTime(Utility.getTime(getSaturdayToTime()));
            advisorSchedule.setAvailFromDate(Utility.getDate(getFromDate()));
            advisorSchedule.setAvailToDate(Utility.getDate(getToDate()));
            advisorSchedules.add(advisorSchedule);
        }
        if (sunday) {
            advisorSchedule = new AdvisorSchedule();
            advisorSchedule.setDuration(getDuration());
            advisorSchedule.setAdvisorId(loginBean.getUser().userid);
            advisorSchedule.setAvailDay(1);
            advisorSchedule.setAvailFromTime(Utility.getTime(getSundayFromTime()));
            advisorSchedule.setAvailToTime(Utility.getTime(getSundayToTime()));
            advisorSchedule.setAvailFromDate(Utility.getDate(getFromDate()));
            advisorSchedule.setAvailToDate(Utility.getDate(getToDate()));
            advisorSchedules.add(advisorSchedule);
        }

        for (AdvisorSchedule schedule : advisorSchedules) {
            AdvisorDAO advisorDAO = new AdvisorDAOImpl();
            try {
                advisorDAO.insertAdvisorSchedule(schedule, ds);
            } catch (SQLException ex) {
                Logger.getLogger(PublishDates.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "advisorhome.xhtml?faces-redirect=true";
    }

}
