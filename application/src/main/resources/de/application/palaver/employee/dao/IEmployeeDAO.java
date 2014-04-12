package de.application.palaver.employee.dao;

import java.sql.SQLException;
import java.util.List;

import de.application.palaver.ICUD;
import de.application.palaver.employee.Employee;
import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

public interface IEmployeeDAO extends ICUD {
	List<Employee> findAll() throws ConnectException, DAOException, SQLException;
	Employee findById(long id) throws ConnectException, DAOException, SQLException;
	Employee findByNameAndPassword(String name, String password) throws ConnectException, DAOException, SQLException;
}
