/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1;

import edu.uco.gsingh1.businesslayer.UserDAO;
import edu.uco.gsingh1.businesslayer.UserDAOImpl;
import edu.uco.gsingh1.entity.User;
import java.io.Serializable;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.sql.DataSource;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author guru
 */
@Named(value = "verificationBean")
@RequestScoped
public class VerificationBean {

    @Inject
    private LoginBean loginBean;

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    @Resource(name = "jdbc/ds_wsp")
    private DataSource ds;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @NotEmpty(message = "enter verification code")
    private String verificationCode;

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @PostConstruct
    public void init() {
        user = new User();
    }

    public String doCodeCheck() throws SQLException {
        UserDAO userDAO = new UserDAOImpl();
        user.username = loginBean.getUseremail();
        if (user.username.length() <= 0) {
            return "login";
        }
        Integer verified = userDAO.doCodeCheck(user.username, verificationCode, ds);
        if (verified == 1) {
            userDAO.verifyStudent(user.username, ds);
            return "student/profile";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Code Verification Failed",
                            "The code entered is incorrect. Please reenter using correct details"));
            return null;
        }
    }

}
