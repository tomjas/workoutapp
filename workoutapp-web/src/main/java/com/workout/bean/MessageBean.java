package com.workout.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.workout.utility.Messages;

@ManagedBean
@RequestScoped
public class MessageBean {

	public String getMessageTranslated(String key){
		Messages messages = new Messages();
		String message = messages.getString(key);
		if (message != null) {
			return message;
		}
		
		return key;
	}
	 
}
