/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author guru
 */
public class User {

    @NotNull
    public int userid;
    @NotEmpty(message = "Enter Firstname")
    public String firstname;
    public String middleinitial;
    @NotEmpty(message = "Enter Lastname")
    public String lastname;
    @NotNull(message = "Enter Email")
    @Pattern(regexp = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@uco.edu", message = "enter uco email")
    public String ucoemail;
    @NotNull(message = "Enter password")
    @NotEmpty(message = "Enter password")
    public String password;
    public String usertype;
    @NotNull(message = "Enter Student Id")
    public String studentid;
    @NotNull(message = "Enter Major Code")
    public int majorid;
    public String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddleinitial() {
        return middleinitial;
    }

    public void setMiddleinitial(String middleinitial) {
        this.middleinitial = middleinitial;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUcoemail() {
        return ucoemail;
    }

    public void setUcoemail(String ucoemail) {
        this.ucoemail = ucoemail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public int getMajorid() {
        return majorid;
    }

    public void setMajorid(int majorid) {
        this.majorid = majorid;
    }

}
