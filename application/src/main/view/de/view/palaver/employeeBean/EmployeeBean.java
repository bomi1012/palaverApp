package de.view.palaver.employeeBean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import de.application.palaver.employee.Employee;
import de.application.palaver.employee.service.EmployeeService;

@ManagedBean(name = "employeeBean")
@ApplicationScoped
public class EmployeeBean implements Serializable{
	private static final long serialVersionUID = 7379721634367240970L;

	private List<Employee> m_employeeList;
	public List<Employee> getEmployeeList() { return m_employeeList; }
	
	private List<Employee> m_filterList;
	public List<Employee> getFilter() { return m_filterList; }	
	public void setFilter(List<Employee> list) { m_filterList = list; }
		
	private Employee m_selectedEmployee;
	public Employee getSelectedEmployee() {  return m_selectedEmployee; }
	public void setSelectedEmployee(Employee selectedEmployee) {  m_selectedEmployee = selectedEmployee; }
	
	private String m_val;
	public String getVal() {
		return m_val;
	}
	public void setVal(String val) {
		m_val = val;
	}

	
	
	public void onRowSelect(SelectEvent event) {  
		System.out.println(" 1 " + ((Employee) event.getObject()).getFirstname());
		m_val = ((Employee) event.getObject()).getFirstname();
    }  
	
	public EmployeeBean() {
		super();
		m_employeeList = EmployeeService.getInstance().getAllOnlyTable();
	}

	
}
