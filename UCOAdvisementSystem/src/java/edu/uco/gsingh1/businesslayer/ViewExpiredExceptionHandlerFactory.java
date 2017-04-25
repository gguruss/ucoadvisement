/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 *
 * @author guru
 */
public class ViewExpiredExceptionHandlerFactory extends ExceptionHandlerFactory  {
    
    private ExceptionHandlerFactory parent;

    public ViewExpiredExceptionHandlerFactory(ExceptionHandlerFactory parent) {
        this.parent = parent;
    }


    @Override
    public ExceptionHandler getExceptionHandler() {
         return new ViewExpiredExceptionHandler(parent.getExceptionHandler());
    }
    
}
