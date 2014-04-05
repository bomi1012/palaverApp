package de.application.abstracts.DB;

public enum TablesEnum {
	EMPLOYEE("mitarbeiter"), 
	RECIPE("test");
	
	private String table;
	 
	private TablesEnum(String s) {
		table = s;
	}
 
	public String getName() {
		return table;
	}
}
