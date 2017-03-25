/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    //@Pattern(regexp = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[uco.eduUCO.EDU]", message = "Enter UCO Email") removed to support custom validator for ajax
    public String username;
   
    @Size(max = 20, min = 8, message = "Password should be between 8-10 characters")
    public String password;
    public String usertype;
//    @Pattern(regexp = "\\*\\d{8}", message = " ") removed to support custom validator for ajax
    public String studentid;
    @NotNull(message = "Select major code")
    public int majorid;
    public String phone;
    public int isuserverified;
    public String randomcode;    

    public String getRandomcode() {
        return randomcode;
    }

    public void setRandomcode(String randomcode) {
        this.randomcode = randomcode;
    }

    public int getIsuserverified() {
        return isuserverified;
    }

    public void setIsuserverified(int isuserverified) {
        this.isuserverified = isuserverified;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
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
