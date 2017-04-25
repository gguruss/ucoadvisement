/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1;

import edu.uco.gsingh1.businesslayer.AdvisorDAO;
import edu.uco.gsingh1.businesslayer.AdvisorDAOImpl;
import edu.uco.gsingh1.businesslayer.UserDAO;
import edu.uco.gsingh1.businesslayer.UserDAOImpl;
import edu.uco.gsingh1.entity.AdvisorAppointmentView;
import edu.uco.gsingh1.entity.AppointmentView;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;

/**
 *
 * @author guru
 */
@Named(value = "advisorBean")
@RequestScoped
public class AdvisorBean implements Serializable {

    /**
     * Creates a new instance of AdvisorBean
     */
    public AdvisorBean() {
    }

    @Resource(name = "jdbc/ds_wsp")
    private DataSource ds;

    private ArrayList<AdvisorAppointmentView> advisorAppointmentsView;

    public ArrayList<AdvisorAppointmentView> getAdvisorAppointmentsView() {
        return advisorAppointmentsView;
    }

    public void setAdvisorAppointmentsView(ArrayList<AdvisorAppointmentView> advisorAppointmentsView) {
        this.advisorAppointmentsView = advisorAppointmentsView;
    }

    public String getAdvisorSelectedDate() {
        return advisorSelectedDate;
    }

    public void setAdvisorSelectedDate(String advisorSelectedDate) {
        this.advisorSelectedDate = advisorSelectedDate;
    }
    private String advisorSelectedDate;

    @PostConstruct
    public void init() {
        advisorAppointmentsView = new ArrayList<>();
        AdvisorDAO advisorDAO = new AdvisorDAOImpl();
        if (advisorSelectedDate == null) {
            setAdvisorSelectedDate("");
        }
        try {
            advisorAppointmentsView = advisorDAO.getAppointments(advisorSelectedDate, ds);
        } catch (SQLException ex) {
            Logger.getLogger(AdvisorBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String cancelBookingByAdvisor(AdvisorAppointmentView booking) throws UnsupportedEncodingException {
        AdvisorDAO advisorDAO = new AdvisorDAOImpl();
        boolean updated = false;
        try {
            updated = advisorDAO.cancelAppointmentByAdvisor(booking, 1, ds);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (updated) {
            return "/advisor/browsestudentappointments.xhtml?faces-redirect=true";
        }
        return null;
    }

    public void getAppointmentAtSelectedDate(String date) {
        if (advisorSelectedDate != null) {
            AdvisorDAO advisorDAO = new AdvisorDAOImpl();
            try {
                advisorAppointmentsView = advisorDAO.getAppointments(advisorSelectedDate, ds);
            } catch (SQLException ex) {
                Logger.getLogger(AdvisorBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
