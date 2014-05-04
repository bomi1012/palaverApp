package de.view.palaver.layoutBean;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import de.application.palaver.employee.Employee;
import de.helper.palaver.constants.IBeanDictionary;

public class Bean {
	
	public Bean() {}
	
	protected void getMessage(String id, Severity facesMessage, String name, String message) {
    	FacesContext.getCurrentInstance().addMessage(id, new FacesMessage(facesMessage, name, message));
	}
	
	protected Employee m_employee = (Employee) FacesContext.getCurrentInstance().getExternalContext()
			.getSessionMap().get(IBeanDictionary.AUTHORIZED_USER);
}
