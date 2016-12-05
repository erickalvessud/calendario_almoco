package com.erick.calendarioalmoco.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.erick.calendarioalmoco.dao.UserDAO;
import com.erick.calendarioalmoco.modelo.User;

@Named
@ViewScoped
public class LoginMB implements Serializable{
	private static final long serialVersionUID = 1L;

	private static final String PAGE_HOME = "";
	
	@Inject
	private UserDAO userDAO;
	
	private String email;
	private String password;

	public String doLogin(){
		if (this.email == null || this.email.isEmpty() 
				|| this.password == null || this.password.isEmpty()) {
			return null;
		}
		FacesContext context = FacesContext.getCurrentInstance();
		
		User user = userDAO.findUserByEmailAndPwd(this.email, this.password);
		if (user != null) {
			context.getExternalContext().getSessionMap().put("user", user);
            return PAGE_HOME + "?faces-redirect=true";
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR , "Unknown login, try again", null));
			reset();
            return null;
		}
	}
	
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }

	private void reset() {
		this.email = null;
		this.password = null;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
