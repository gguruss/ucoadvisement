/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1;

import edu.uco.gsingh1.businesslayer.MajorDAO;
import edu.uco.gsingh1.businesslayer.MajorDAOImpl;
import edu.uco.gsingh1.businesslayer.UserDAO;
import edu.uco.gsingh1.businesslayer.UserDAOImpl;
import edu.uco.gsingh1.entity.MajorCourses;
import edu.uco.gsingh1.entity.StudentCourses;
import edu.uco.gsingh1.entity.UserView;
import java.security.Principal;
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
import javax.faces.context.FacesContext;
import javax.inject.Inject;
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
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (deleted) {
            studentCourses.remove(studentcourse);
        }
        return null;
    }
}
