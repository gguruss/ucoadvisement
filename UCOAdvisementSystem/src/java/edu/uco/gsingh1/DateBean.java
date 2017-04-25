package edu.uco.gsingh1;

/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
import edu.uco.gsingh1.CalendarBean;
import edu.uco.gsingh1.LoginBean;
import edu.uco.gsingh1.businesslayer.AdvisorDAO;
import edu.uco.gsingh1.businesslayer.AdvisorDAOImpl;
import edu.uco.gsingh1.businesslayer.UserDAO;
import edu.uco.gsingh1.businesslayer.UserDAOImpl;
import edu.uco.gsingh1.entity.AdvisorSchedule;
import edu.uco.gsingh1.entity.Breaks;
import edu.uco.gsingh1.entity.Slots;
import edu.uco.gsingh1.entity.StudentAppointments;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import org.joda.time.DateTime;

/**
 *
 * @author guru
 */
@Named(value = "dateBean")
@ViewScoped
public class DateBean implements Serializable {

    @Resource(name = "jdbc/ds_wsp")
    private DataSource ds;
    private String startDate;
    private ArrayList<Slots> slots;
    private StudentAppointments studentBooking;

    public StudentAppointments getStudentBooking() {
        return studentBooking;
    }

    public void setStudentBooking(StudentAppointments studentBooking) {
        this.studentBooking = studentBooking;
    }

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

    public void DateBean() {
        System.out.println("Date Bean reporting for duty");
    }

    @PostConstruct
    public void init() {
        studentBooking = new StudentAppointments();
        slots = new ArrayList<>();
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
            Logger.getLogger(DateBean.class.getName()).log(Level.SEVERE, null, ex);
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

    public void getStudentSlots() throws SQLException {
        slots = new ArrayList<>();
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

    }

    public String book(Slots bookedSlot) throws SQLException {
        String useremail = loginBean.getUseremail();
        boolean result = false;
        if (bookedSlot != null) {
            studentBooking.setAdvisorId(1);
            studentBooking.setAppointmentDay(bookedSlot.getSlotStartDateTime().getDayOfWeek() + 1);
            studentBooking.setAppointmentDate(bookedSlot.getSlotStartDateTime());
            studentBooking.setOutputAppointmentDate(bookedSlot.getAvailableDate());
            studentBooking.setUserId(loginBean.getUser().userid);
            studentBooking.setStartTime(bookedSlot.getSlotStartDateTime());
            studentBooking.setOutputAppointmentStartTime(bookedSlot.getOutputSlotStartDateTime());
            studentBooking.setEndTime(bookedSlot.getSlotEndDateTime());
            studentBooking.setOutputAppointmentEndTime(bookedSlot.getOutputSlotEndDateTime());
            studentBooking.setStatus(1);
            UserDAO userDAO = new UserDAOImpl();
            result = userDAO.insertAppointment(studentBooking, useremail, ds);
            if (result) {
                return "/student/profile.xhtml?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Insert Appointment Error",
                                "Could not add appointment"));
                return null;
            }
        }
        return null;
    }

}
