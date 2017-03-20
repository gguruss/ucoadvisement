/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.entity;

/**
 *
 * @author guru
 */
public class Major {

    public int getMajorcode() {
        return majorcode;
    }

    public void setMajorcode(int majorcode) {
        this.majorcode = majorcode;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int majorcode;
    public String major;
    public String program;
    public String degree;

}
