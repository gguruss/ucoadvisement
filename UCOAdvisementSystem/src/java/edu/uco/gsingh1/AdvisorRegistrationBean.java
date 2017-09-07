/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1;

import edu.uco.gsingh1.businesslayer.MajorDAO;
import edu.uco.gsingh1.businesslayer.MajorDAOImpl;
import edu.uco.gsingh1.businesslayer.UserDAO;
import edu.uco.gsingh1.businesslayer.UserDAOImpl;
import edu.uco.gsingh1.businesslayer.Utility;
import edu.uco.gsingh1.entity.Major;
import edu.uco.gsingh1.entity.User;
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
@Named(value = "advisorRegistrationBean")
@RequestScoped
public class AdvisorRegistrationBean {

    @Resource(name = "jdbc/ds_wsp")
    private DataSource ds;
    private User newAdvisor;

    public User getNewAdvisor() {
        return newAdvisor;
    }

    public void setNewAdvisor(User newAdvisor) {
        this.newAdvisor = newAdvisor;
    }

    @PostConstruct
    public void init() {
        newAdvisor = new User();
    }

    public String doSave() throws SQLException {
        UserDAO userDAO = new UserDAOImpl();
        newAdvisor.password = Utility.encrypt(newAdvisor.password);
        newAdvisor.isAdvisor = 1;
        Boolean insert = userDAO.insertUser(newAdvisor, ds);
        if (insert) {
            return "advisorhome.xhtml";
        }
        return null;
    }

}
