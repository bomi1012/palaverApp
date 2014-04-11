package de.application.palaver.employee.service;

import java.util.List;

import de.application.palaver.employee.Employee;
import de.application.palaver.employee.dao.EmployeeDAO;


public class EmployeeService implements IEmployeeService{
	private static EmployeeService m_instance = null;
	
	public EmployeeService() { }
	
	public static EmployeeService getInstance() {
        if (m_instance == null) {
            m_instance = new EmployeeService();
        }
        return m_instance;
    }

	public Employee getEmployeeById(long id) {		
		try {
			return EmployeeDAO.getInstance().getEmployeeById(id);
		} catch (Exception exp) {
			exp.printStackTrace();
		} 
		return null;
	}

	public Employee findEmployee(String username, String password) {
		try {
			return EmployeeDAO.getInstance().findEmployeeByNameAndPassword(username, password);
		} catch (Exception exp) {
			exp.printStackTrace();
		} 
		return null;
	}

	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}	
}
