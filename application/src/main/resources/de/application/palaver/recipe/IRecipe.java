package de.application.palaver.recipe;

import de.application.palaver.employee.Employee;

public interface IRecipe {
	long getId();
	void setId(long id);
	
	String getName();
	void setName(String name);
	
	Employee getEmploee();
	void setEmploee(Employee emploee);
}
