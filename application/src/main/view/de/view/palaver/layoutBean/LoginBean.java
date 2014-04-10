package de.view.palaver.layoutBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import de.helper.palaver.constants.IBeanDictionary;
 
 
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
     
    protected boolean m_loggedIn = false;
    public boolean isLoggedIn() { return m_loggedIn; }
 
    @ManagedProperty(value="#{navBean}")
    private NavigationBean navigationBean;
    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }
     
    public LoginBean() {
    	super();    	
    }
    
    /**
     * Login operation.
     * @return
     */
    public String onLogin() {
    	m_username = "test";
    	m_password = "12";
        if (m_username != null && m_password != null) {
            m_loggedIn = true;
            saveResultToSessionMap();            
            return navigationBean.redirectToIndex();
        }
        return navigationBean.redirectToLogin();         
    }
    
	private void saveResultToSessionMap() {
		FacesContext.getCurrentInstance()
			.getExternalContext()
			.getSessionMap()
			.put(IBeanDictionary.LOGIN_IN_SESSION, m_loggedIn);		
	}
     
//    /**
//     * Logout operation.
//     * @return
//     */
//    public String doLogout() {
//        // Set the paremeter indicating that user is logged in to false
//        loggedIn = false;
//         
//        // Set logout message
//        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
//        msg.setSeverity(FacesMessage.SEVERITY_INFO);
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//         
//        return navigationBean.toLogin();
//    }    
}