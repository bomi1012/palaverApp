package de.helper.palaver.db;

import java.sql.Connection;
import java.sql.Statement;

import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

public interface IConnectionManager {
	Statement getStatement();
	Connection getConnection();
	
	void openConnection()  throws ConnectException;	
	void closeConnection()  throws ConnectException, DAOException;
}
