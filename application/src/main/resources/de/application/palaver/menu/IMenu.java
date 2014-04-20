package de.application.palaver.menu;

import java.util.List;

import de.application.palaver.employee.Employee;
import de.application.palaver.recipe.Recipe;
import de.helper.palaver.entities.IEntityName;

public interface IMenu extends IEntityName {

	Employee getEmployee();
	void setEmployee(Employee employee);
	
	List<Recipe> getRecipeList();
	void setRecipeList(List<Recipe> recipes);
}
