package de.application.palaver.employee.bean;

import javax.faces.bean.ManagedBean;

import de.application.palaver.employee.Employee;
import de.application.palaver.employee.service.EmployeeService;

@ManagedBean(name = "emp")
public class EmployeeBean {

	public EmployeeBean() {
		super();
	}
	
	public String getEmployeeInfo() {
		Employee e = EmployeeService.getInstance().getEmployeeById(1L); 
				return e.getFirstname() + " " + e.getLastname();
	}
}
