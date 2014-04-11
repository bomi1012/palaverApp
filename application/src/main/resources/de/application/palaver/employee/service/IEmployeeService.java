package de.application.palaver.employee.service;

import de.application.palaver.employee.Employee;


public interface IEmployeeService {

	/**
	 * Mitarbeiter in der DB bei Name und Passwort
	 * 
	 * @param username STRING
	 * @param password STRING
	 * @return {@link Employee}
	 */
	Employee findEmployee(String username, String password);
}
