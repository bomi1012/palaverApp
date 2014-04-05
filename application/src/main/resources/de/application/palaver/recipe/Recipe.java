package de.application.palaver.recipe;

import de.application.abstracts.entities.EntityName;
import de.application.palaver.employee.Employee;

public class Recipe extends EntityName implements IRecipe{
	
	/************************/
	/** Getters and Setters */
	/************************/

	private Employee m_employee; 
	@Override
	public Employee getEmploee() { return m_employee; }
	@Override
	public void setEmploee(Employee emploee) { m_employee = emploee; }
	
	
	/*****************/
	/** Constructors */
	/*****************/
	
	public Recipe() {
		super();
	}
	
	public Recipe(long id, String name, Employee employee) {
		super(id, name);
		m_employee = employee;
	}
}
