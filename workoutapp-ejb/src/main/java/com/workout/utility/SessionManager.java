package com.workout.utility;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.jboss.resteasy.spi.HttpRequest;

public class SessionManager {

	public static HttpSession getSession() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return session;
	}

	public static HttpRequest getRequest() {
		HttpRequest request = (HttpRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		return request;
	}

}
