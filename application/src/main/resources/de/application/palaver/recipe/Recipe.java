package de.application.palaver.recipe;

import java.util.Date;
import java.util.List;

import de.application.palaver.employee.Employee;
import de.application.palaver.menu.Menu;
import de.helper.palaver.entities.EntityName;

public class Recipe extends EntityName implements IRecipe{
	
	/************************/
	/** Getters and Setters */
	/************************/

	private Employee m_employee; 
	@Override
	public Employee getEmployee() { return m_employee; }
	@Override
	public void setEmployee(Employee employee) { m_employee = employee; }
	
	private List<Menu> m_menus;
	@Override
	public List<Menu> getMenuList() { return m_menus; }
	@Override
	public void setMenuList(List<Menu> menus) { m_menus = menus; }
	
	/*****************/
	/** Constructors */
	/*****************/
	
	public Recipe() {
		super();
	}
	
	public Recipe(long id, String name, Employee employee, List<Menu> menus,
			Date createItem, Date updateItem, boolean active) {
		super(id, name, createItem);
		m_employee = employee;
		m_menus = menus;
	}

}
