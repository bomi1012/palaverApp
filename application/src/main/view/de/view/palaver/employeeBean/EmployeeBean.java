package de.view.palaver.employeeBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import de.application.palaver.employee.Employee;
import de.application.palaver.employee.service.EmployeeService;

@ManagedBean(name = "employeeBean")
@SessionScoped
public class EmployeeBean implements Serializable {
	private static final long serialVersionUID = 7379721634367240970L;

	private List<Employee> m_employeeList;

	public List<Employee> getEmployeeList() {
		return m_employeeList;
	}

	private List<Employee> m_filterList;

	public List<Employee> getFilter() {
		return m_filterList;
	}

	public void setFilter(List<Employee> list) {
		m_filterList = list;
	}

	private Employee m_selectedEmployee;

	public Employee getSelectedEmployee() {
		return m_selectedEmployee;
	}

	public void setSelectedEmployee(Employee selectedEmployee) {
		m_selectedEmployee = selectedEmployee;
	}

	public void onRowSelect(SelectEvent event) {
		setVisibleInfoBlock(true);
		System.out.println(" 1 "
				+ ((Employee) event.getObject()).getFirstname());

	}

	private boolean m_visibleInfoBlock;

	public boolean isVisibleInfoBlock() {
		return m_visibleInfoBlock;
	}

	public void setVisibleInfoBlock(boolean visibleInfoBlock) {
		m_visibleInfoBlock = visibleInfoBlock;
	}

	public EmployeeBean() {
		super();
		m_employeeList = EmployeeService.getInstance().getAllOnlyTable();
		m_visibleInfoBlock = false;
	}

}
