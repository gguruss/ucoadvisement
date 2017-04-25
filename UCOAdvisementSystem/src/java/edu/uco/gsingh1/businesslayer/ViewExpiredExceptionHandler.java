/*
 * Author: Guru Singh
 * Web Server Programming, Spring 17
 */
package edu.uco.gsingh1.businesslayer;

import java.util.Iterator;
import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.SystemEvent;

/**
 *
 * @author guru
 */
public class ViewExpiredExceptionHandler extends ExceptionHandlerWrapper {

    private ExceptionHandler wrapped;

    public ViewExpiredExceptionHandler(ExceptionHandler exceptionHandler) {
        this.wrapped = wrapped;
    }

    @Override
    public void handle() throws FacesException {
        FacesContext facesContext = FacesContext.getCurrentInstance();

        for (Iterator<ExceptionQueuedEvent> iter = getUnhandledExceptionQueuedEvents().iterator(); iter.hasNext();) {
            Throwable exception = iter.next().getContext().getException();

            if (exception instanceof ViewExpiredException) {
                facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "error");
                facesContext.renderResponse();
                iter.remove();
            }
        }

        getWrapped().handle();
    }

    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }

}
