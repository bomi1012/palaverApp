package de.application.palaver.menu;

import java.util.Date;
import java.util.List;

import de.application.palaver.employee.Employee;
import de.application.palaver.recipe.Recipe;
import de.helper.palaver.entities.EntityName;

public class Menu extends EntityName implements IMenu {

	/************************/
	/** Getters and Setters */
	/************************/

	private Employee m_employee; 
	@Override
	public Employee getEmployee() { return m_employee; }
	@Override
	public void setEmployee(Employee employee) { m_employee = employee; }

	private List<Recipe> m_recipes;
	@Override
	public List<Recipe> getRecipeList() { return m_recipes; 	}
	@Override
	public void setRecipeList(List<Recipe> recipes) { m_recipes = recipes; }
	
	
	public Menu() {
		super();
	}

	public Menu(long id, String name, Employee employee, List<Recipe> recipes, 
			Date createItem) {
		super(id, name);
		m_employee = employee;
		m_recipes = recipes;
	}

}
