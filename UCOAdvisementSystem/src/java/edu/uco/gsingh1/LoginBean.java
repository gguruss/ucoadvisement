/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1;

import static com.sun.faces.facelets.util.Path.context;
import edu.uco.gsingh1.businesslayer.UserDAO;
import edu.uco.gsingh1.businesslayer.UserDAOImpl;
import edu.uco.gsingh1.businesslayer.Utility;
import edu.uco.gsingh1.entity.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.security.Principal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author guru
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    @Resource(name = "jdbc/ds_wsp")
    private DataSource ds;
    @NotEmpty(message = "enter uco user email")
    private String useremail;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    @NotEmpty(message = "enter uco user password")
    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
    private String userpassword;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @PostConstruct
    public void init() {
        user = new User();
        FacesContext fc = FacesContext.getCurrentInstance();
        Principal p = fc.getExternalContext().getUserPrincipal();
        if (p != null) {
            username = p.getName();
            try {
                doLogin();
            } catch (SQLException ex) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public String doLogin() throws SQLException {

        UserDAO userDAO = new UserDAOImpl();
        String hashedPassword = Utility.encrypt(userpassword);
        user = userDAO.verifyUser(useremail, hashedPassword, ds);
        if (user.userid > 0) {

            if (user.usertype.equals("advisor")) {
                return "advisor/advisorhome.xhtml?faces-redirect=true";
            } else if ((user.usertype.equals("student")) && (user.isuserverified == 1)) {
                return "student/profile.xhtml?faces-redirect=true";
            } else {
                return "verificationpage.xhtml?faces-redirect=true";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Password",
                            "Please enter correct username and Password"));
            return null;
        }
    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();

        session.invalidate();
        return "/faces/index.xhtml?faces-redirect=true";
    }
}
