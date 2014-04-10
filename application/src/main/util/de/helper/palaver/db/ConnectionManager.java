package de.helper.palaver.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

import de.helper.palaver.constants.IConnectString;
import de.helper.palaver.constants.IDBDictionary;
import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

public class ConnectionManager implements IConnectionManager, IDBDictionary {
	
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
			m_connection = new Driver().connect(IConnectString.DB_CONNECTION_URL, new Properties());
			m_statement = m_connection.createStatement();
		} catch (SQLException e) {
			throw new ConnectException(DB_CONNECTION_FAILED);
		}
	}

	private void disconnect() throws ConnectException {
		try {
			m_statement.close();
			m_connection.close();
		} catch (Exception e) {
			throw new ConnectException(DB_CONNECTION_CLOSE_FAILAD);
		}
	}
	

}