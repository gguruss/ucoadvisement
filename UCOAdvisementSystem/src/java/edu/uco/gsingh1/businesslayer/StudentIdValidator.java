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
@FacesValidator("studentIdValidator")
public class StudentIdValidator implements Validator {

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
        System.out.println("in validate");
        String studentId = (String) value;
        UserDAO userDAO = new UserDAOImpl();
        int exists = 1;
        if (studentId.isEmpty()) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Please Enter a Student Id", null));
        }
        if (!studentId.matches("\\*\\d{8}")) {
             throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Please enter student id in the format *20000000", null));
        }
        
        try {
            exists = userDAO.checkIfStudentIdExists(value.toString(), ds);
        } catch (SQLException ex) {
            Logger.getLogger(StudentIdValidator.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (exists == 1) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "The student id has already been registered. Please input another student id.", null));
        }
    }
}
