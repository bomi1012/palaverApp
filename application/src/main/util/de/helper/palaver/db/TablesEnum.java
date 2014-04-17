package de.helper.palaver.db;

public enum TablesEnum {
	EMPLOYEE("employee"), 
	PERMISSION("permission"), 
	EMPLOYEE_PERMISSION("employee_has_permission"), 
	RECIPE("test");
	
	private String m_table;
	 
	private TablesEnum(String table) {
		m_table = table;
	}
 
	public String getName() {
		return m_table;
	}
}
