package de.application.palaver.employee;

import java.util.List;

import de.application.abstracts.entities.EntityId;
import de.application.palaver.recipe.Recipe;

public class Employee extends EntityId implements IEmployee {
	
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
	
	/*****************/
	/** Constructors */
	/*****************/
	
	public Employee() {
		super();
	}

	public Employee(
			long id, String firstname, String lastname,	String nickname,
			List<Recipe> recipes) {
		super(id);
		m_firstname = firstname;
		m_lastname = lastname;
		m_nickname = nickname;
		m_recipes = recipes;
	}
}
