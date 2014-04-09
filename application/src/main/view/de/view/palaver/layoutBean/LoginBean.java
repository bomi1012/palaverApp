package de.view.palaver.layoutBean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
 
 
/**
 * Simple login bean.
 * 
 * @author itcuties
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
 
    private static final long serialVersionUID = 7765876811740798583L;
 
    private String m_username;
    public String getUsername() { return m_username; } 
    public void setUsername(String username) { m_username = username; }
    
    private String m_password;
    public String getPassword() { return m_password; } 
    public void setPassword(String password) { m_password = password; }
     
    private boolean loggedIn;
    public boolean isLoggedIn() { return loggedIn; }
 
    @ManagedProperty(value="#{nav}")
    private NavigationBean navigationBean;
    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }
     
    /**
     * Login operation.
     * @return
     */
    public String doLogin() {
        // Get every user from our sample database :)
    	m_username = "test";
    	m_password = "12";
        if (m_username != null && m_password != null) {
            loggedIn = true;
            return navigationBean.redirectToWelcome();
        }

         
        // Set login ERROR
        FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
         
        // To to login page
        return navigationBean.toLogin();
         
    }
     
    /**
     * Logout operation.
     * @return
     */
    public String doLogout() {
        // Set the paremeter indicating that user is logged in to false
        loggedIn = false;
         
        // Set logout message
        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
         
        return navigationBean.toLogin();
    }
 
    // ------------------------------
    // Getters & Setters 
     
    
 
  
 

 

     
}