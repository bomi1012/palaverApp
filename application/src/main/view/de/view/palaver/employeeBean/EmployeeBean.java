package de.view.palaver.employeeBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import de.application.palaver.employee.Employee;
import de.application.palaver.employee.service.EmployeeService;

@ManagedBean(name = "empBean")
public class EmployeeBean implements Serializable{
	private static final long serialVersionUID = 7379721634367240970L;

	private List<Employee> m_employeeList;
	public List<Employee> getEmployeeList() { return m_employeeList; }
	
	private List<Employee> m_filterList;
	public List<Employee> getFilter() { return m_filterList; }	
	public void setFilter(List<Employee> list) { m_filterList = list; }
	
	public EmployeeBean() {
		super();
		m_employeeList = EmployeeService.getInstance().getAllOnlyTable();
	}
}
