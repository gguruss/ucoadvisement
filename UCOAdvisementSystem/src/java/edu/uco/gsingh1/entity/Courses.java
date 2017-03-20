 /*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.entity;

/**
 *
 * @author guru
 */
public class Courses {
    public String courseprefix;
    public int coursenumber;
    public String coursetitle;
    public int credithrs;
    public String course;

    public String getCourseprefix() {
        return courseprefix;
    }

    public void setCourseprefix(String courseprefix) {
        this.courseprefix = courseprefix;
    }

    public int getCoursenumber() {
        return coursenumber;
    }

    public void setCoursenumber(int coursenumber) {
        this.coursenumber = coursenumber;
    }

    public String getCoursetitle() {
        return coursetitle;
    }

    public void setCoursetitle(String coursetitle) {
        this.coursetitle = coursetitle;
    }

    public int getCredithrs() {
        return credithrs;
    }

    public void setCredithrs(int credithrs) {
        this.credithrs = credithrs;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
