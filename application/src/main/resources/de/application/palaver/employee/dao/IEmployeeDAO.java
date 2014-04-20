package de.application.palaver.employee.dao;

import java.sql.SQLException;
import java.util.List;

import de.application.palaver.ICUD;
import de.application.palaver.employee.Employee;
import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

public interface IEmployeeDAO extends ICUD {
	
	String FIELD_ID = "id";
	String FIELD_LASTNAME = "name";
	String FIELD_FIRSTNAME = "vorname";
	String FIELD_NICKNAME = "benutzername";
	String FIELD_PASSWORD = "passwort";
	String FIELD_EMAIL = "email";
	
	List<Employee> findAll(boolean complete) throws ConnectException, DAOException, SQLException;
	Employee findById(long id) throws ConnectException, DAOException, SQLException;
	Employee findByNameAndPassword(String name, String password) throws ConnectException, DAOException, SQLException;
	
	
}
