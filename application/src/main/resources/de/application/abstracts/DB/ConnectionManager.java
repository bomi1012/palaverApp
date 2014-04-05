package de.application.abstracts.DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

import de.application.abstracts.DB.exceptions.ConnectException;
import de.application.abstracts.DB.exceptions.DAOException;
import de.application.abstracts.util.IConstants;

public class ConnectionManager implements IConnectionManager {
	
	private Statement m_statement;
	private Connection m_connection;

	public ConnectionManager() {
		super();
	}

	@Override
	public Statement getStatement() { return m_statement; }	
	@Override
	public Connection getConnection() { return m_connection; }
	
	@Override
	public void openConnection() throws ConnectException {
		connect();
		m_statement = getStatement();
	}
	
	@Override
	public void closeConnection() throws ConnectException, DAOException {
		disconnect();
		try {
			m_statement.close();
		}
		catch (SQLException e) {
			throw new DAOException(e.toString());
		}
	}
	

	private void connect() throws ConnectException {
		try {
			m_connection = new Driver().connect(IConstants.DB_CONNECTION_URL, new Properties());
			m_statement = m_connection.createStatement();
		} catch (SQLException e) {
			throw new ConnectException(IConstants.DB_CONNECTION_FAILED);
		}
	}

	private void disconnect() throws ConnectException {
		try {
			m_statement.close();
			m_connection.close();
		} catch (Exception e) {
			throw new ConnectException(IConstants.DB_CONNECTION_CLOSE_FAILAD);
		}
	}
	

}