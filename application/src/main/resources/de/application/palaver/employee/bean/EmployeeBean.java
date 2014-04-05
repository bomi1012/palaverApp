package de.application.palaver.employee.bean;

import javax.faces.bean.ManagedBean;

import de.application.palaver.employee.service.EmployeeService;

@ManagedBean(name = "emp")
public class EmployeeBean {

	public EmployeeBean() {
		super();
	}
	
	public String getEmployeeInfo() {
		return EmployeeService.getInstance().getEmployeeById(1L).getNickname();
	}
}
