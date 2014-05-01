package de.helper.palaver.db;

public enum TablesEnum {
	EMPLOYEE						("mitarbeiter"), 
	PERMISSION						("rollen"), 
	ARTICLE							("artikel"),
	EMPLOYEE_PERMISSION				("mitarbeiter_has_rollen"), 
	RECIPE							("rezept"),
	RECIPE_PREPARATION				("zubereitung"),
	RECIPE_TYPES					("rezeptart"),
	RECIPE_HAS_PREPARATION			("rezept_has_zubereitung"),
	RECIPE_HAS_ARTICLE				("rezept_has_artikel"),
	QUANTITY_UNIT					("mengeneinheit");
	
	private String m_table;
	public String getName() {
		return m_table;
	}
	 
	private TablesEnum(String table) {
		m_table = table;
	}
}
