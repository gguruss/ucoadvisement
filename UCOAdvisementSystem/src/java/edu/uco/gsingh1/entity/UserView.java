/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.entity;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author guru
 */
public class UserView {

    public int userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    @NotEmpty(message = "Enter Firstname")
    public String firstname;
    public String studentid;

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getMajorcode() {
        return majorcode;
    }

    public void setMajorcode(Integer majorcode) {
        this.majorcode = majorcode;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
    public String middleinitial;
    @NotEmpty(message = "Enter Lastname")
    public String lastname;
    public String username;
    public Integer majorcode;
    public String major;
    public String degree;
    public String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public boolean editable;

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
}
