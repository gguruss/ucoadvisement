/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.sql.DataSource;

/**
 *
 * @author guru
 */
@FacesValidator("studentEmailValidator")
public class StudentEmailValidator implements Validator {

    @Resource(name = "jdbc/ds_wsp")
    private DataSource ds;

    /**
     *
     * @param context
     * @param component
     * @param value
     * @throws ValidatorException
     * @throws SQLException
     */
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {
        UserDAO userDAO = new UserDAOImpl();
        String studentEmail = (String) value;
        boolean exists = true;
        
         if (studentEmail.isEmpty()) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Enter UCO Email Address", null));
        }
        if (!studentEmail.matches("^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@(?i)uco.edu")) {
             throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Please enter UCO Email Address", null));
        }
        try {
            exists = userDAO.checkIfStudentEmailRegistered(value.toString(), ds);
        } catch (SQLException ex) {
            Logger.getLogger(StudentEmailValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (exists) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "The email has already been registered.Please choose a different email", null));
        } else {
        }
    }
}
