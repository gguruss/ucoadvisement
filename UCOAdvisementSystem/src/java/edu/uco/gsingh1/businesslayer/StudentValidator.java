/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
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
@FacesValidator("edu.uco.gsingh1.StudentEmailValidator")
public class StudentValidator implements Validator {
    
    @Resource(name = "jdbc/ds_wsp")
    private DataSource ds;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        final String email = (String) value;
        UserDAO checkDAO = new UserDAOImpl();
        
        try {
            if (checkDAO.checkIfStudentEmailRegistered(email, ds)) {
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
