package de.application.palaver.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;

import de.application.palaver.employee.Employee;
import de.helper.palaver.db.AbstractDAO;
import de.helper.palaver.db.TablesEnum;
import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

@SuppressWarnings("serial")
public class EmployeeDAO extends AbstractDAO implements IEmployeeDAO {

	private static EmployeeDAO m_instance = null;
	private Employee m_employee;
	private static final String GET_EMPLOYEE_BY_ID = "SELECT * FROM "
			+ TablesEnum.EMPLOYEE.getName() + " WHERE id = {0}";
	private static final String 	GET_EMPLOYEE_BY_NAME_AND_PASSWORD = "SELECT * FROM "
			+ TablesEnum.EMPLOYEE.getName() + " WHERE benutzername = \"{0}\" ORDER BY id";

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
	public List<Employee> findAll() throws ConnectException, DAOException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
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
	
	@Override
	public long create() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
	////// PRIVATE METHODE ////////
	
	private Employee setEmployee(ResultSet resultSet) throws SQLException {
		return new Employee(
				resultSet.getLong("id"),
				resultSet.getString("firstname"), 
				resultSet.getString("lastname"),
				resultSet.getString("password"));
	}

	
}
