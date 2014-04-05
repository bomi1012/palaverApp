package de.application.palaver.menu;

import java.util.List;

import de.application.palaver.employee.Employee;
import de.application.palaver.recipe.Recipe;

public interface IMenu {
	long getId();
	void setId(long id);
	
	String getName();
	void setName(String name);
	
	Employee getEmployee();
	void setEmployee(Employee employee);
	
	List<Recipe> getRecipeList();
	void setRecipeList(List<Recipe> recipes);
}
