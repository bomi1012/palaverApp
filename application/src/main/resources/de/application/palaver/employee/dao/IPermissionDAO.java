package de.application.palaver.employee.dao;

import java.sql.SQLException;
import java.util.List;

import de.application.palaver.ICUD;
import de.application.palaver.employee.Permission;
import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

public interface IPermissionDAO extends ICUD {
	List<Permission> findAll() throws ConnectException, DAOException, SQLException;
	Permission findById(long id) throws ConnectException, DAOException, SQLException;
	List<Permission> findPermissionsByEmployeeId(long id) throws ConnectException, DAOException, SQLException;;
}
