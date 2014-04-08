package de.view.palaver.employeeBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import de.application.palaver.employee.Employee;

@ManagedBean(name = "emp")
public class EmployeeBean {

	private List<Employee> m_employeeList;
	public List<Employee> getFilter() { return m_employeeList; }	
	public void setFilter(List<Employee> list) { m_employeeList = list; }
	
	public EmployeeBean() {
	}

	public List<Employee> getDataGrid() {
		
		List<Employee> e = new ArrayList<Employee>();
		
		e.add(new Employee(1, "Mischa", "Boehm", null, null, null, null, null, true));
		e.add(new Employee(2, "Wiolla", "DatenBank", null, null, null, null, null, true));
		e.add(new Employee(3, "Silas", "Hallo", null, null, null, null, null, true));
		e.add(new Employee(4, "Paul", "Muster", null, null, null, null, null, true));
		e.add(new Employee(1, "Mischa", "Boehm", null, null, null, null, null, true));
		e.add(new Employee(2, "Wiolla", "DatenBank", null, null, null, null, null, true));
		e.add(new Employee(3, "Silas", "Hallo", null, null, null, null, null, true));
		e.add(new Employee(4, "Paul", "Muster", null, null, null, null, null, true));
		e.add(new Employee(1, "Mischa", "Boehm", null, null, null, null, null, true));
		e.add(new Employee(2, "Wiolla", "DatenBank", null, null, null, null, null, true));
		e.add(new Employee(3, "Silas", "Hallo", null, null, null, null, null, true));
		e.add(new Employee(4, "Paul", "Muster", null, null, null, null, null, true));
		
		return e;
		
	}
	

}
