package com.erick.calendarioalmoco.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class BaseMB implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Show a message on the page.
	 * @param severity
	 * @param summary 
	 * @param detail
	 */
	protected void showMessage(Severity severity, String summary, String detail){
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(severity, summary, detail));
	}
}
