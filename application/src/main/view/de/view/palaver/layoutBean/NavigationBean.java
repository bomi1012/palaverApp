package de.view.palaver.layoutBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import de.helper.palaver.constants.IBeanDictionary;

@SuppressWarnings("serial")
@ManagedBean(name = "navBean")
@SessionScoped
public class NavigationBean implements Serializable{
	
	private static final String PATH = "/pages/";
	private FacesContext m_facesContext;
	private HttpServletRequest m_request;
	
	public NavigationBean() {
		super();
	}

	public String getIncludedPage() { 
		String page = PATH + "dashboard.xhtml";
		if(FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(IBeanDictionary.LOGIN_IN_SESSION) != null) {
			String uri = getApplicationUri();
			if (uri.contains("/index.xhtml")) {
				page =  PATH + "dashboard.xhtml";
			} else if (uri.contains("/employee.xhtml")) {
				page =  PATH + "employeeList.xhtml";
			} else if (uri.contains("/login.xhtml")) {
				page =  PATH + "loginForm.xhtml";
			} 
			return page;
		} else {
			page =  PATH + "loginForm.xhtml";
		}
		return page;
	}
	
    public String redirectToLogin() {
        return "/login.xhtml?faces-redirect=true";
    }

    public String redirectToIndex() {
        return "/index.xhtml?faces-redirect=true";
    }
	
	private String getApplicationUri() {
		m_facesContext = FacesContext.getCurrentInstance();
		m_request = (HttpServletRequest) m_facesContext.getExternalContext().getRequest();
		return  m_request.getRequestURI();
	}

}
