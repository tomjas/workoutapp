package com.workout.utility;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.jboss.resteasy.spi.HttpRequest;

public class SessionManager {

	private static HttpSession getSession() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return session;
	}

	private static HttpRequest getRequest() {
		HttpRequest request = (HttpRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		return request;
	}
	
	public static void setSessionAttribute(String attribute, String value){
		getSession().setAttribute(attribute, value);
	}
	
	public static void invalidateSession(){
		getSession().invalidate();
	}

}
