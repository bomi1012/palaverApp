package de.application.palaver.menu.dao;

import java.sql.SQLException;
import java.util.List;

import de.application.palaver.ICUD;
import de.application.palaver.menu.Menu;
import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

public interface IMenuDAO extends ICUD {
	List<Menu> findAll() throws ConnectException, DAOException, SQLException;
	Menu findById(long id) throws ConnectException, DAOException, SQLException;
}
