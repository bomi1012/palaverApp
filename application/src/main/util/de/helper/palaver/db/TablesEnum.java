package de.helper.palaver.db;

public enum TablesEnum {
	EMPLOYEE("mitarbeiter"), 
	PERMISSION("rollen"), 
	ARTICLE("artikel"),
	EMPLOYEE_PERMISSION("mitarbeiter_has_rollen"), 
	RECIPE("rezepte"),
	RECIPE_PREPARATION("zubereitung"),
	RECIPE_TYPES("rezeptart"),
	QUANTITY_UNIT("mengeneinheit");
	
	private String m_table;
	 
	private TablesEnum(String table) {
		m_table = table;
	}
 
	public String getName() {
		return m_table;
	}
}
