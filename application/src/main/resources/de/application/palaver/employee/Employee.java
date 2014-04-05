package de.application.palaver.employee;

import java.util.Date;
import java.util.List;

import de.application.abstracts.entities.EntityInfo;
import de.application.palaver.menu.Menu;
import de.application.palaver.recipe.Recipe;

public class Employee extends EntityInfo implements IEmployee {
	
	/************************/
	/** Getters and Setters */
	/************************/

	private String m_firstname;
	@Override
	public String getFirstname() { return m_firstname; }
	@Override
	public void setFirstname(String firstname) { m_firstname = firstname; }

	private String m_lastname;
	@Override
	public String getLastname() { return m_lastname; }
	@Override
	public void setLastname(String lastname) { m_lastname = lastname; }
	
	private String m_nickname;
	@Override
	public String getNickname() { return m_nickname; }
	@Override
	public void setNickmane(String nickname) { m_nickname = nickname; }	
	
	private List<Recipe> m_recipes;
	@Override
	public List<Recipe> getRecipeList() { return m_recipes; 	}
	@Override
	public void setRecipeList(List<Recipe> recipes) { m_recipes = recipes; }
	
	private List<Menu> m_menus;
	@Override
	public List<Menu> getMenuList() {return m_menus; }
	@Override
	public void setMenuList(List<Menu> menus) { m_menus = menus; }
	
	/*****************/
	/** Constructors */
	/*****************/
	
	public Employee() {
		super();
	}

	public Employee(
			long id, String firstname, String lastname,	String nickname,
			List<Recipe> recipes, List<Menu> menus,
			Date createItem, Date updateItem, boolean active) {
		super(id, createItem, updateItem, active);
		m_firstname = firstname;
		m_lastname = lastname;
		m_nickname = nickname;
		m_recipes = recipes;
		m_menus = menus;
	}
}
