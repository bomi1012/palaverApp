package de.view.palaver.layoutBean;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import de.application.palaver.employee.Employee;
import de.application.palaver.employee.Permission;
import de.helper.palaver.constants.IBeanDictionary;

@ManagedBean(name = "permission")
@SessionScoped
public class PermissionManager implements Serializable {
	private static final long serialVersionUID = -7576630426942407720L;
	private static final String PROPERTIES_PATH = "lang/messages.properties";
	private Properties m_properties;
	private InputStream m_input;
	private Employee m_employee;

	public PermissionManager() {
		super();
		m_properties = new Properties();
		m_input = PermissionManager.class.getClassLoader().getResourceAsStream(
				PROPERTIES_PATH);
		m_employee = (Employee) FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(IBeanDictionary.AUTHORIZED_USER);
	}

	
	public boolean checkPermissions(String permission) {
		if (m_input == null) { 
			System.out.println("### " + PROPERTIES_PATH + " not found!");
			return false; 
		}
		try {			 
			if (m_employee.getPermissionList().size() != 0) {
				m_properties.load(m_input);
				for (Permission permissionFromEmployee : m_employee.getPermissionList()) {
					if (permission.equalsIgnoreCase(permissionFromEmployee.getName()) || 
							permissionFromEmployee.getName().equalsIgnoreCase(m_properties.getProperty("permissionadmin"))) {
						return true;
					}
				} 
			}
		} catch (IOException exp) {
			exp.printStackTrace();
		}
		return false;
	}
}
