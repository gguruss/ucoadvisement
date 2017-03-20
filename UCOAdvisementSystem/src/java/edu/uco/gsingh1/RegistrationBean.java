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
import edu.uco.gsingh1.entity.User;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.sql.DataSource;

/**
 *
 * @author guru
 */
@Named(value = "registrationBean")
@RequestScoped
public class RegistrationBean implements Serializable {

    @Resource(name = "jdbc/ds_wsp")
    private DataSource ds;
    private User newUser;
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

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    @PostConstruct
    public void init() {
        newUser = new User();
        majorList = new ArrayList<>();
        MajorDAO majorDAO = new MajorDAOImpl();
        try {
            majors = majorDAO.getAllMajor(ds);
            for (Major major : majors) {
                majorList.add(new SelectItem(major.majorcode, major.major));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String doSave() throws SQLException {
        UserDAO userDAO = new UserDAOImpl();
        Boolean insert = userDAO.insertUser(newUser, ds);
        if (insert) {
            return "index";
        }
        return null;
    }
}
