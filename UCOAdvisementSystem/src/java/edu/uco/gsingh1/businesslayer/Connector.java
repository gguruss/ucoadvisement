/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 *
 * @author guru
 */
public class Connector {
    
    @Resource(name = "jdbc/ds_wsp")
    private DataSource ds;
    
    
    
}
