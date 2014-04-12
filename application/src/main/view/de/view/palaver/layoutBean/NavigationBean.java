package de.view.palaver.layoutBean;

import java.io.IOException;
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
				.getSessionMap().get(IBeanDictionary.AUTHORIZED_USER) != null) {
			
			System.out.print(FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(IBeanDictionary.AUTHORIZED_USER));
			
			String uri = getApplicationUri();
			if (uri.contains("/index.xhtml")) {
				page =  PATH + "dashboard.xhtml";
			} else if (uri.contains("/employee.xhtml")) {
				page =  PATH + "employeeList.xhtml";
			} else if (uri.contains("/login.xhtml")) {
				page =  PATH + "dashboard.xhtml";
			} 
			return page;
		} else {
			page =  PATH + "loginForm.xhtml";
		}
		return page;
	}
	
    public void redirectToLogin() {
    	try {
			FacesContext.getCurrentInstance()
			.getExternalContext().redirect("login.xhtml");
		} catch (IOException exp) {
			exp.printStackTrace();
		}	
    }

    public void redirectToIndex() {
    	try {
			FacesContext.getCurrentInstance()
			.getExternalContext().redirect("index.xhtml");
		} catch (IOException exp) {
			exp.printStackTrace();
		}		
    }
	
	private String getApplicationUri() {
		m_facesContext = FacesContext.getCurrentInstance();
		m_request = (HttpServletRequest) m_facesContext.getExternalContext().getRequest();
		return  m_request.getRequestURI();
	}

}
