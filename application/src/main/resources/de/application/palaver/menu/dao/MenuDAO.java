package de.application.palaver.menu.dao;

import java.sql.SQLException;
import java.util.List;

import de.application.palaver.menu.Menu;
import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

public class MenuDAO implements IMenuDAO {

	@Override
	public List<Menu> findAll() throws ConnectException, DAOException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu findById(long id) throws ConnectException, DAOException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
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
