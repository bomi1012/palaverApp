package de.application.palaver.employee.service;

import java.util.List;

import de.application.palaver.employee.Permission;
import de.application.palaver.employee.dao.PermissionDAO;

public class PermissionService {
	private static PermissionService m_instance = null;
	
	public PermissionService() {
		super();
	}
	
	public static PermissionService getInstance() {
        if (m_instance == null) {
            m_instance = new PermissionService();
        }
        return m_instance;
    }
	
	public List<Permission> findPermissionsByEmployeeId(long id) {
		try {
			return PermissionDAO.getInstance().findPermissionsByEmployeeId(id);
		} catch (Exception exp) {
			exp.printStackTrace();
		} 
		return null;
	}
}
