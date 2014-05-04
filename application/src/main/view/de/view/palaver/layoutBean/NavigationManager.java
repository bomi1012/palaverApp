package de.view.palaver.layoutBean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import de.helper.palaver.constants.IBeanDictionary;

@SuppressWarnings("serial")
@ManagedBean(name = "navigationMan")
@SessionScoped
public class NavigationManager implements Serializable{
	
	private static final String PATH = "/pages/";
	private FacesContext m_facesContext;
	private HttpServletRequest m_request;
	
	public NavigationManager() {
		super();
	}

	public String getIncludedPage() { 
		String page = PATH + "dashboard.xhtml";
		if(FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(IBeanDictionary.AUTHORIZED_USER) != null) {	
			String uri = getApplicationUri();
			if (uri.contains("/index.xhtml")) {
				page =  PATH + "dashboard.xhtml";
			} else if (uri.contains("/employee.xhtml")) {
				page =  PATH + "employeeList.xhtml";
			} else if (uri.contains("/login.xhtml")) {
				page =  PATH + "dashboard.xhtml";
			} else if (uri.contains("/recipe.xhtml")){
				page = PATH + "recipe-actions.xhtml";
			} else if (uri.contains("/recipe-create.xhtml")){
				page = PATH + "recipe-create.xhtml";
			} else if (uri.contains("/recipe-list.xhtml")){
				page = PATH + "recipe-list.xhtml";
			}
			return page;
		} else {
			page =  PATH + "loginForm.xhtml";
		}
		return page;
	}
	
	
    public void redirectTo(String page) {
    	try {
			FacesContext.getCurrentInstance()
			.getExternalContext().redirect(page);
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
