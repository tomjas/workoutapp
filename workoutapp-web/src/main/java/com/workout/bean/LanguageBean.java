package com.workout.bean;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="languageBean")
@SessionScoped
public class LanguageBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String language;
	private Locale locale;
	
	@PostConstruct
	public void init(){
		// getRequestLocale powoduje ustwienie locali żądanych przez przeglądarkę
//		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
		
		// Domyślne locale z ustawień faces-config.xml
		locale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
	}
	
	public void selectLanguage(String language){
		this.locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
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
