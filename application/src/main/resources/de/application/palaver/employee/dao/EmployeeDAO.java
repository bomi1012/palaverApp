package de.application.palaver.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import de.application.abstracts.DB.AbstractDAO;
import de.application.abstracts.DB.TablesEnum;
import de.application.abstracts.DB.exceptions.ConnectException;
import de.application.abstracts.DB.exceptions.DAOException;
import de.application.palaver.employee.Employee;

public class EmployeeDAO extends AbstractDAO {

	private static EmployeeDAO m_instance = null;
	private Employee m_employee;
	private static final String GET_EMPLOYEE_BY_ID = "SELECT * FROM "
			+ TablesEnum.EMPLOYEE.getName() + " WHERE id = {0}";

	public EmployeeDAO() {
		super();
	}

	public static EmployeeDAO getInstance() {
		if (m_instance == null) {
			m_instance = new EmployeeDAO();
		}
		return m_instance;
	}

	public Employee getEmployeeById(long id) throws ConnectException, DAOException, SQLException {
		m_employee = new Employee();
		m_resultSet = getManaged(MessageFormat.format(GET_EMPLOYEE_BY_ID, id));
		while (m_resultSet.next()) {
			m_employee = setEm(m_resultSet);
		}
		return m_employee;
	}

	private Employee setEm(ResultSet resultSet) throws SQLException {
		return new Employee(resultSet.getLong("id"),
				resultSet.getString("name"), resultSet.getString("vorname"),
				resultSet.getString("benutzername"), null);
	}
}
