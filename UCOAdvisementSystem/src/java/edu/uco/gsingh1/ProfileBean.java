/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1;

import edu.uco.gsingh1.businesslayer.MajorDAO;
import edu.uco.gsingh1.businesslayer.MajorDAOImpl;
import edu.uco.gsingh1.businesslayer.UserDAO;
import edu.uco.gsingh1.businesslayer.UserDAOImpl;
import edu.uco.gsingh1.entity.AppointmentView;
import edu.uco.gsingh1.entity.FileInfo;
import edu.uco.gsingh1.entity.MajorCourses;
import edu.uco.gsingh1.entity.StudentCourses;
import edu.uco.gsingh1.entity.UserView;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.servlet.http.Part;
import javax.sql.DataSource;

/**
 *
 * @author guru
 */
@Named(value = "profileBean")
@RequestScoped
public class ProfileBean {

    private UserView userview;
    @Resource(name = "jdbc/ds_wsp")
    private DataSource ds;
    private ArrayList<MajorCourses> majorCourses;
    private Map<String, Boolean> checked = new HashMap<>();
    private ArrayList<AppointmentView> appointmentView;
    private Part part;

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
    private FileInfo fileinfo;

    public FileInfo getFileinfo() {
        return fileinfo;
    }

    public void setFileinfo(FileInfo fileinfo) {
        this.fileinfo = fileinfo;
    }

    public ArrayList<AppointmentView> getAppointmentView() {
        return appointmentView;
    }

    public void setAppointmentView(ArrayList<AppointmentView> appointmentView) {
        this.appointmentView = appointmentView;
    }

    public Map<String, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<String, Boolean> checked) {
        this.checked = checked;
    }
    private List<MajorCourses> items;

    public List<MajorCourses> getItems() {
        return items;
    }

    public void setItems(List<MajorCourses> items) {
        this.items = items;
    }

    public ArrayList<MajorCourses> getMajorCourses() {
        return majorCourses;
    }

    public void setMajorCourses(ArrayList<MajorCourses> majorCourses) {
        this.majorCourses = majorCourses;
    }

    private ArrayList<StudentCourses> studentCourses;

    public ArrayList<StudentCourses> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(ArrayList<StudentCourses> studentCourses) {
        this.studentCourses = studentCourses;
    }

    public UserView getUserview() {
        return userview;
    }

    public void setUserview(UserView userview) {
        this.userview = userview;
    }

    public void updateFileInfo() throws SQLException {
        System.out.println("========= updateFileInfo() ===");
        try {
            UserDAO userDAO = new UserDAOImpl();
            fileinfo = userDAO.loadFileInfo(loginBean.getUseremail(), ds);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Inject
    private LoginBean loginBean;

    @PostConstruct
    public void init() {
        studentCourses = new ArrayList<>();
        majorCourses = new ArrayList<>();
        UserDAO userDAO = new UserDAOImpl();
        MajorDAO majorDAO = new MajorDAOImpl();
        if (loginBean.getUseremail().length() > 0) {
            try {
                userview = userDAO.getUserView(loginBean.getUseremail(), ds);
                studentCourses = userDAO.getStudentCourses(loginBean.getUseremail(), ds);
                majorCourses = majorDAO.getMajorCoursesTakenByStudent(userview.majorcode, userview.userid, ds);
                appointmentView = userDAO.getAppointments(loginBean.getUseremail(), ds);
                fileinfo = userDAO.loadFileInfo(loginBean.getUseremail(), ds);
            } catch (SQLException ex) {
                Logger.getLogger(ProfileBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String saveCourses() throws SQLException {
        UserDAO userDAO = new UserDAOImpl();
        for (MajorCourses course : majorCourses) {
            if (checked.get(course.getCourse())) {
                userDAO.addCoursesTakenByStudents(userview.userid, loginBean.getUseremail(), course.getCourse(), ds);
            }
        }
        checked.clear();
        return "profile.xhtml?faces-redirect=true";
    }

    public String deleteAction(StudentCourses studentcourse) {
        UserDAO userDAO = new UserDAOImpl();
        boolean deleted = false;
        try {
            deleted = userDAO.removeCourseTakenByStudent(userview.userid, loginBean.getUseremail(), studentcourse.getCourse(), ds);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (deleted) {
            studentCourses.remove(studentcourse);
        }
        return null;
    }

    public String cancelBookingByStudent(AppointmentView booking) {
        UserDAO userDAO = new UserDAOImpl();
        boolean updated = false;
        try {
            updated = userDAO.cancelAppointmentByStudent(booking.getAppointmentId(), userview.userid, ds);
        } catch (SQLException ex) {
            Logger.getLogger(ProfileBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (updated) {
            return "/student/editappointment.xhtml?faces-redirect=true";
        }
        return null;
    }

    public String uploadFile() throws IOException, SQLException {

        FacesContext facesContext = FacesContext.getCurrentInstance();

        Connection conn = ds.getConnection();
        Integer userid = loginBean.getUser().getUserid();

        InputStream inputStream;
        inputStream = null;
        try {
            inputStream = part.getInputStream();
            PreparedStatement insertQuery = conn.prepareStatement(
                    "INSERT INTO userimage (userid, useremail, filename, filetype,filesize,filecontents) "
                    + "VALUES (?,?,?,?,?,?)");
            insertQuery.setInt(1, loginBean.getUser().userid);
            insertQuery.setString(2, loginBean.getUseremail());
            insertQuery.setString(3, part.getSubmittedFileName());
            insertQuery.setString(4, part.getContentType());
            insertQuery.setLong(5, part.getSize());
            insertQuery.setBinaryStream(6, inputStream);

            int result = insertQuery.executeUpdate();
            if (result == 1) {
                facesContext.addMessage("uploadForm:upload",
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                part.getSubmittedFileName()
                                + ": uploaded successfuly !!", null));
            } else {
                // if not 1, it must be an error.
                facesContext.addMessage("uploadForm:upload",
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                result + " file uploaded", null));
            }
        } catch (IOException e) {
            facesContext.addMessage("uploadForm:upload",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "File upload failed !!", null));
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return "/student/profile.xhtml?faces-redirect=true";
    }

    public void validateFile(FacesContext ctx, UIComponent comp, Object value) {
        if (value == null) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Select a file to upload", null));
        }
        Part file = (Part) value;
        long size = file.getSize();
        if (size <= 0) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "the file is empty", null));
        }
        if (size > 1024 * 1024 * 10) { // 10 MB limit
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            size + "bytes: file too big (limit 10MB)", null));
        }
    }

}
