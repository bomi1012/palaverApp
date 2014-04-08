package de.design.palaver.templates;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean(name = "def")
public class LayoutDefaultView {

	private String m_includedPage = "/pages/dashboard.xhtml";
	public String getIncludedPage() { return m_includedPage; }
	public void setIncludedPage(String includedPage) { m_includedPage = includedPage; }
	
	public LayoutDefaultView() {
		super();
	}

public String action(){
    	
    	FacesContext context = FacesContext.getCurrentInstance();
    	String selectedPageViewId =
    	context.getExternalContext().getRequestParameterMap().get("pageViewId");
    	if (selectedPageViewId.equalsIgnoreCase("page1")) {
    	m_includedPage = "../pages/employee.xhtml";
    	}
    	return "";
    }
}
