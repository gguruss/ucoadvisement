/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1;

import edu.uco.gsingh1.businesslayer.MajorDAO;
import edu.uco.gsingh1.businesslayer.MajorDAOImpl;
import edu.uco.gsingh1.businesslayer.UserDAO;
import edu.uco.gsingh1.businesslayer.UserDAOImpl;
import edu.uco.gsingh1.entity.Major;
import edu.uco.gsingh1.entity.StudentAdvisementView;
import edu.uco.gsingh1.entity.UserView;
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
import javax.faces.model.SelectItem;
import javax.sql.DataSource;

/**
 *
 * @author guru
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    public void UserBean() {
        System.out.println("got it");
    }

    @Resource(name = "jdbc/ds_wsp")
    private DataSource ds;

    private ArrayList<UserView> users;

    public ArrayList<UserView> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserView> users) {
        this.users = users;
    }

    private UserView user;

    public UserView getUser() {
        return user;
    }

    public void setUser(UserView user) {
        this.user = user;
    }

    private ArrayList<SelectItem> majorList;

    public ArrayList<SelectItem> getMajorList() {
        return majorList;
    }

    public void setMajorList(ArrayList<SelectItem> majorList) {
        this.majorList = majorList;
    }
    private ArrayList<Major> majors;

    public ArrayList<Major> getMajors() {
        return majors;
    }

    public void setMajors(ArrayList<Major> majors) {
        this.majors = majors;
    }

    private ArrayList<StudentAdvisementView> studentAdvisementView;

    public ArrayList<StudentAdvisementView> getStudentAdvisementView() {
        return studentAdvisementView;
    }

    public void setStudentAdvisementView(ArrayList<StudentAdvisementView> studentAdvisementView) {
        this.studentAdvisementView = studentAdvisementView;
    }

    @PostConstruct
    public void init() {
        System.out.println("Inside init");
        bindData();
    }

    public void bindData() {
        users = new ArrayList<>();
        studentAdvisementView = new ArrayList<>();
        UserDAO userDAO = new UserDAOImpl();
        try {
            users = userDAO.getAllUsers(ds);
            studentAdvisementView = userDAO.getAllStudentAdvisementStatus(ds);
        } catch (SQLException ex) {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        majorList = new ArrayList<>();
        MajorDAO majorDAO = new MajorDAOImpl();
        try {
            majors = majorDAO.getAllMajor(ds);
            for (Major major : majors) {
                majorList.add(new SelectItem(major.majorcode, major.major));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String deleteAction(UserView user) {
        UserDAO userDAO = new UserDAOImpl();
        boolean deleted = false;
        try {
            deleted = userDAO.deleteUser(user.studentid, ds);
        } catch (SQLException ex) {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (deleted) {
            users.remove(user);
        }
        return null;
    }

    public String editAction(UserView user) {
        this.user = user;
        user.editable = true;
        return null;
    }

    public String updateValue(UserView user) {
        boolean updated = false;
        this.user = user;
        UserDAO userDAO = new UserDAOImpl();
        try {
            updated = userDAO.updateUser(this.user, ds);
        } catch (SQLException ex) {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (updated) {
            user.editable = false;
            bindData();
        }
        return null;
    }

    public String updateAction(StudentAdvisementView user) {
        boolean updated = false;
        UserDAO userDAO = new UserDAOImpl();
        try {
            updated = userDAO.updateAdvisementStatus(user.getUserId(), ds);
        } catch (SQLException ex) {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (updated) {
            bindData();
        }
        return null;
    }

}
