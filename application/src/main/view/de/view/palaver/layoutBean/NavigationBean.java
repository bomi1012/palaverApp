package de.view.palaver.layoutBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "nav")
@SessionScoped
public class NavigationBean {
	
	private static final String PATH = "/pages/";
	private FacesContext m_facesContext;
	private HttpServletRequest m_request;
	
	public NavigationBean() {
		super();
	}

	public String getIncludedPage() { 
		String uri = getApplicationUri();
		if (uri.contains("/index.xhtml")) {
			return PATH + "dashboard.xhtml";
		} else if (uri.contains("/employee.xhtml")) {
			return PATH + "employeeList.xhtml";
		} else if (uri.contains("/login.xhtml")) {
			return PATH + "loginForm.xhtml";
		} 
		return PATH + "dashboard.xhtml";
	}
	
	private String getApplicationUri() {
		m_facesContext = FacesContext.getCurrentInstance();
		m_request = (HttpServletRequest) m_facesContext.getExternalContext().getRequest();
		return  m_request.getRequestURI();
	}

	  /**
     * Redirect to login page.
     * @return Login page name.
     */
    public String redirectToLogin() {
        return "/index.xhtml?faces-redirect=true";
    }
     
    /**
     * Go to login page.
     * @return Login page name.
     */
    public String toLogin() {
        return "/index.xhtml";
    }
     
    /**
     * Redirect to info page.
     * @return Info page name.
     */
    public String redirectToInfo() {
        return "/info.xhtml?faces-redirect=true";
    }
     
//    /**
//     * Go to info page.
//     * @return Info page name.
//     */
//    public String toInfo() {
//        return "/info.xhtml";
//    }
     
    /**
     * Redirect to welcome page.
     * @return Welcome page name.
     */
    public String redirectToWelcome() {
        return "/employee.xhtml?faces-redirect=true";
    }
     
//    /**
//     * Go to welcome page.
//     * @return Welcome page name.
//     */
//    public String toWelcome() {
//        return "/welcome.xhtml";
//    }
}
