/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1;

import edu.uco.gsingh1.businesslayer.AdvisorDAO;
import edu.uco.gsingh1.businesslayer.AdvisorDAOImpl;
import edu.uco.gsingh1.businesslayer.UserDAO;
import edu.uco.gsingh1.businesslayer.UserDAOImpl;
import edu.uco.gsingh1.entity.AdvisorSchedule;
import edu.uco.gsingh1.entity.Slots;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import org.joda.time.DateTime;

/**
 *
 * @author guru
 */
@Named(value = "calendarBean")
@RequestScoped
public class CalendarBean implements Serializable {

    @Resource(name = "jdbc/ds_wsp")
    private DataSource ds;
    private String startDate;
    private ArrayList<Slots> slots;

    public ArrayList<Slots> getSlots() {
        return slots;
    }

    public void setSlots(ArrayList<Slots> slots) {
        this.slots = slots;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    private String endDate;

    @Inject
    private LoginBean loginBean;

    /**
     * Creates a new instance of CalendarBean
     */
    @PostConstruct
    public void init() {
        this.slots = new ArrayList<>();
        AdvisorSchedule scheduledDate = new AdvisorSchedule();
        AdvisorDAO advisorDAO = new AdvisorDAOImpl();
        try {
            if ("advisor".equals(loginBean.getUser().usertype)) {
                scheduledDate = advisorDAO.getStartEndDateForAdvisor(loginBean.getUser().userid, ds);
            } else {
                scheduledDate = advisorDAO.getStartEndDateForAdvisor(1, ds);
            }

            if (scheduledDate.getAvailFromDate() != null && scheduledDate.getAvailToDate() != null) {
                setStartDate(scheduledDate.getAvailFromDate().toString());
                setEndDate(scheduledDate.getAvailToDate().toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CalendarBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String selectedDate;

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    public void getAdvisorSlots() {
        String dateSelected = selectedDate;
    }

    public String getStudentSlots() throws SQLException {
        String dateSelected = selectedDate;
        if (dateSelected != null) {
            UserDAO userDAO = new UserDAOImpl();
            slots = userDAO.getStudentSlots(new DateTime(dateSelected), 1, ds);
            setSlots(slots);
        }
        AdvisorSchedule scheduledDate = new AdvisorSchedule();
        AdvisorDAO advisorDAO = new AdvisorDAOImpl();
        try {
            if ("advisor".equals(loginBean.getUser().usertype)) {
                scheduledDate = advisorDAO.getStartEndDateForAdvisor(loginBean.getUser().userid, ds);
            } else {
                scheduledDate = advisorDAO.getStartEndDateForAdvisor(1, ds);
            }

            if (scheduledDate.getAvailFromDate() != null && scheduledDate.getAvailToDate() != null) {
                setStartDate(scheduledDate.getAvailFromDate().toString());
                setEndDate(scheduledDate.getAvailToDate().toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CalendarBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
