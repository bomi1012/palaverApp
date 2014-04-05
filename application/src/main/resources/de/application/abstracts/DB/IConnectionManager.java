package de.application.abstracts.DB;

import java.sql.Connection;
import java.sql.Statement;

import de.application.abstracts.DB.exceptions.ConnectException;
import de.application.abstracts.DB.exceptions.DAOException;

public interface IConnectionManager {
	Statement getStatement();
	Connection getConnection();
	
	void openConnection()  throws ConnectException;	
	void closeConnection()  throws ConnectException, DAOException;
}
