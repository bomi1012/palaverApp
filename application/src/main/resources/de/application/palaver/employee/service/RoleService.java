package de.application.palaver.employee.service;

import java.util.List;

import de.application.palaver.employee.Role;

public class RoleService {
	private static RoleService m_instance = null;
	
	public RoleService() {
		super();
	}
	
	public static RoleService getInstance() {
        if (m_instance == null) {
            m_instance = new RoleService();
        }
        return m_instance;
    }
	
	public List<Role> findRolesByEmployeeId(long id) {
		return null;		
	}
}
