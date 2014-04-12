package de.application.palaver.employee.dao;

import java.sql.SQLException;
import java.util.List;

import de.application.palaver.employee.Role;
import de.helper.palaver.db.AbstractDAO;
import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

public class RoleDAO extends AbstractDAO implements IRoleDAO {

	@Override
	public List<Role> findAll() throws ConnectException, DAOException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findById(long id) throws ConnectException, DAOException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
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
}
