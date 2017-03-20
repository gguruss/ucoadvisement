/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guru
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthFilter implements Filter {

    public AuthFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {

            // check whether session variable is set
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession ses = req.getSession(false);
            //  allow user to proccede if url is login.xhtml or user logged in or user is accessing any page in //public folder
            String reqURI = req.getRequestURI();
            if (reqURI.contains("/login.xhtml") || (ses != null && ses.getAttribute("userid") != null)
                    && (ses.getAttribute("userrole") == "advisor") && reqURI.contains("/advisor/") && reqURI.contains("javax.faces.resource")) {
                chain.doFilter(request, response);
            } else if (reqURI.contains("/login.xhtml") || (ses != null && ses.getAttribute("userid") != null)
                    && (ses.getAttribute("userrole") == "student") && reqURI.contains("/student/") && reqURI.contains("javax.faces.resource")) {
                chain.doFilter(request, response);
            } else // user didn't log in but asking for a page that is not allowed so take user to login page
            {
                res.sendRedirect(req.getContextPath() + "/login.xhtml");  // Anonymous user. Redirect to login page
            }
        } catch (IOException | ServletException t) {
            System.out.println(t.getMessage());
        }
    } //doFilter

    public void destroy() {

    }

    @Override
    public boolean isLoggable(LogRecord record) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
