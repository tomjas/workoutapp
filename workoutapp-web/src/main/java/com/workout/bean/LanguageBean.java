package com.workout.bean;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name="languageBean")
@SessionScoped
public class LanguageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String language;
	private Locale locale;
	
	public String selectLanguage(String language){
		this.language = language;
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		return "";
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}


}
