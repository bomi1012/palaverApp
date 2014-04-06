package de.helper.palaver.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

import de.helper.palaver.constants.IDataBaseDic;
import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

@SuppressWarnings("restriction")
abstract public class AbstractDAO implements IDataBaseDic{
	
	private ConnectionManager m_connector;	
	protected ResultSet m_resultSet;
	private CachedRowSet m_cache;
	protected long m_lastId;	
	
	public AbstractDAO() {
		super();
		m_resultSet = null;
		m_connector = new ConnectionManager();
	}
	
	protected synchronized ResultSet getManaged(String query) throws ConnectException, DAOException, SQLException  {
		m_connector.openConnection();
		m_cache = new CachedRowSetImpl();
		try  {
			m_resultSet = m_connector.getStatement().executeQuery(query);
			m_cache.populate(m_resultSet);	
		} 
		catch (Exception e) {
			throw new DAOException(String.format(DB_STATEMENT_ERROR, query, e.toString()));
		}
		finally {
			m_connector.closeConnection();
			if (m_resultSet != null) {
				m_resultSet.close();
			}	
		}
		return m_cache.getOriginal();
	}
	
	protected synchronized Long putManaged(String query) throws ConnectException, DAOException  {
		m_connector.openConnection();
		try  {
			m_connector.getStatement().executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			m_resultSet = m_connector.getStatement().getGeneratedKeys();
			m_resultSet.next();
			m_lastId = m_resultSet.getLong(1);
		} 
		catch (Exception e)  {
			throw new DAOException(String.format(DB_STATEMENT_ERROR, query, e.toString()));
		}
		finally {
			m_connector.closeConnection();	
		}
		return m_lastId;
	}
}
