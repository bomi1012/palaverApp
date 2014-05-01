package de.application.palaver.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import de.application.palaver.employee.Employee;
import de.helper.palaver.db.AbstractDAO;
import de.helper.palaver.db.TablesEnum;
import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

public class EmployeeDAO extends AbstractDAO implements IEmployeeDAO {
	private static final long serialVersionUID = -3440079515745827748L;
	private static EmployeeDAO m_instance = null;
	private Employee m_employee;
	private List<Employee> m_employeeList;
	
	private static final String GET_ALL_EMPLOYEES = "SELECT * FROM "
			+ TablesEnum.EMPLOYEE.getName();
	private static final String GET_EMPLOYEE_BY_ID = "SELECT * FROM "
			+ TablesEnum.EMPLOYEE.getName() + " WHERE " + FIELD_ID + " = {0}";
	private static final String 	GET_EMPLOYEE_BY_NAME_AND_PASSWORD = "SELECT * FROM "
			+ TablesEnum.EMPLOYEE.getName() + " WHERE " + FIELD_NICKNAME + " = \"{0}\" ORDER BY " + FIELD_ID;

	public EmployeeDAO() {
		super();
	}

	public static EmployeeDAO getInstance() {
		if (m_instance == null) {
			m_instance = new EmployeeDAO();
		}
		return m_instance;
	}

	@Override
	public Employee findById(long id) throws ConnectException, DAOException, SQLException {
		m_employee = new Employee();
		m_resultSet = getManaged(MessageFormat.format(GET_EMPLOYEE_BY_ID, id));
		while (m_resultSet.next()) {
			m_employee = setEmployee(m_resultSet);
		}
		return m_employee;
	}

	@Override
	public List<Employee> findAll(boolean complete) throws ConnectException, DAOException,
			SQLException {
		m_employeeList = new ArrayList<Employee>();
		m_resultSet = getManaged(GET_ALL_EMPLOYEES);
		while (m_resultSet.next()) {
			if(!complete) {
				m_employeeList.add(setEmployee(m_resultSet));
			} else {
				m_employeeList.add(setEmployeeComplete(m_resultSet));
			}
		}
		return m_employeeList;
	}
	
	@Override
	public Employee findByNameAndPassword(String username,
			String password) throws ConnectException, DAOException, SQLException {
		m_employee = new Employee();
		m_resultSet = getManaged(MessageFormat.format(GET_EMPLOYEE_BY_NAME_AND_PASSWORD, username.toString()));
		while (m_resultSet.next()) {
			m_employee = setEmployee(m_resultSet);
		}
		return m_employee;
	}

	
	////// PRIVATE METHODE ////////	
	private Employee setEmployee(ResultSet resultSet) throws SQLException {
		return new Employee(
				resultSet.getLong(FIELD_ID),
				resultSet.getString(FIELD_FIRSTNAME), 
				resultSet.getString(FIELD_LASTNAME),
				resultSet.getString(FIELD_NICKNAME),
				resultSet.getString(FIELD_PASSWORD), 
				resultSet.getString(FIELD_EMAIL));
	}


	private Employee setEmployeeComplete(ResultSet resultSet) throws SQLException {
		return new Employee(
				resultSet.getLong(FIELD_ID),
				resultSet.getString(FIELD_FIRSTNAME), 
				resultSet.getString(FIELD_LASTNAME),
				resultSet.getString(FIELD_NICKNAME),
				resultSet.getString(FIELD_PASSWORD), 
				resultSet.getString(FIELD_EMAIL), null, null, null);
	}

	@Override
	public long create(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		
	}


	
}
