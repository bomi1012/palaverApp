package de.view.palaver.layoutBean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "layout")
public class LayoutBean {
	
	private static final String PATH = "/pages/";
	private FacesContext m_facesContext;
	private HttpServletRequest m_request;
	
	public LayoutBean() {
		super();
	}

	public String getIncludedPage() { 
		String uri = getApplicationUri();
		if (uri.contains("/index.xhtml")) {
			return PATH + "dashboard.xhtml";
		} else if (uri.contains("/employee.xhtml")) {
			return PATH + "employeeList.xhtml";
		} 
		return PATH + "dashboard.xhtml";
	}
	
	private String getApplicationUri() {
		m_facesContext = FacesContext.getCurrentInstance();
		m_request = (HttpServletRequest) m_facesContext.getExternalContext().getRequest();
		return  m_request.getRequestURI();
	}
}
