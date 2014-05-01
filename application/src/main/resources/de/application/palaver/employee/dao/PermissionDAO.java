package de.application.palaver.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import de.application.palaver.employee.Permission;
import de.helper.palaver.db.AbstractDAO;
import de.helper.palaver.db.TablesEnum;
import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

public class PermissionDAO extends AbstractDAO implements IPermissionDAO {
	private static final long serialVersionUID = -7130365626978455313L;
	private static PermissionDAO m_instance = null;
	
	private static final String GET_PERMISSIONS_BY_EMPLOYEE = "SELECT * FROM "
			+ TablesEnum.PERMISSION.getName() + " p JOIN " 
			+ TablesEnum.EMPLOYEE_PERMISSION.getName() + " ep " 
			+ "ON p." + FIELD_ID + " = ep." + FIELD_PERMISSION_FK + " JOIN " 
			+ TablesEnum.EMPLOYEE.getName() + " e " 
			+ "ON e." + FIELD_ID + " = ep." + FIELD_EMPLOYEE_FK + " WHERE " 
			+ " e." + FIELD_ID + " = {0}";
	
	private List<Permission> m_permissionList;
	
	public PermissionDAO() {
		super();
	}

	public static PermissionDAO getInstance() {
		if (m_instance == null) {
			m_instance = new PermissionDAO();
		}
		return m_instance;
	}
	
	@Override
	public List<Permission> findAll() throws ConnectException, DAOException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Permission findById(long id) throws ConnectException, DAOException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Permission> findPermissionsByEmployeeId(long id) throws ConnectException, DAOException, SQLException {
		m_permissionList = new ArrayList<Permission>();
		m_resultSet = getManaged(MessageFormat.format(GET_PERMISSIONS_BY_EMPLOYEE, id));
		while (m_resultSet.next()) {
			m_permissionList.add(setPermission(m_resultSet));
		}
		return m_permissionList;
	}
	
	
	
	
//////PRIVATE METHODE ////////	
	private Permission setPermission(ResultSet resultSet) throws SQLException {
		return new Permission(
				resultSet.getLong(FIELD_ID),
				resultSet.getString(FIELD_NAME));
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
