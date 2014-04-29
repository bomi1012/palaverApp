package de.helper.palaver.util;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import de.application.palaver.employee.Employee;
import de.helper.palaver.constants.IBeanDictionary;
@SuppressWarnings("unchecked")
@FacesConverter(forClass = Employee.class, value = "employeeConverter")
public class EmployeeConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
	
		for (Employee employee : (List<Employee>) FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(IBeanDictionary.EMPLOYEE_LIST)) {
			if(Long.valueOf(value) == employee.getId()) {
				return employee;
			}
		}
		return "no_found";
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return String.valueOf(((Employee) value).getId());
	}
}
