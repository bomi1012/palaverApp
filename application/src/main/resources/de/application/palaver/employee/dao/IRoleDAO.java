package de.application.palaver.employee.dao;

import java.sql.SQLException;
import java.util.List;

import de.application.palaver.ICUD;
import de.application.palaver.employee.Role;
import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

public interface IRoleDAO extends ICUD {
	List<Role> findAll() throws ConnectException, DAOException, SQLException;
	Role findById(long id) throws ConnectException, DAOException, SQLException;
}
