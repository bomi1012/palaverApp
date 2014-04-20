package de.helper.palaver.db;

public enum TablesEnum {
	EMPLOYEE("mitarbeiter"), 
	PERMISSION("rollen"), 
	EMPLOYEE_PERMISSION("mitarbeiter_has_rollen"), 
	PREPARATION("rollen"),
	RECIPE("test");
	
	private String m_table;
	 
	private TablesEnum(String table) {
		m_table = table;
	}
 
	public String getName() {
		return m_table;
	}
}
