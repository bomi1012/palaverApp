package de.application.palaver.employee;

import java.io.Serializable;
import java.util.List;

import de.application.palaver.menu.Menu;
import de.application.palaver.recipe.Recipe;
import de.helper.palaver.entities.Entity;

public class Employee extends Entity implements IEmployee, Serializable {

	private static final long serialVersionUID = 5027557548240061499L;
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
	
	//Fullname
	public String getFullname() { return m_firstname + " " + m_lastname; }
	
	private String m_nickname;
	@Override
	public String getNickname() { return m_nickname; }
	@Override
	public void setNickmane(String nickname) { m_nickname = nickname; }	
	
	private String m_password;
	@Override
	public String getPassword() { return m_password; }
	@Override
	public void setPassword(String password) { m_password = password; }
	
	private String m_email;
	@Override
	public String getEmail() { return m_email; }
	@Override
	public void setEmail(String email) { m_email = email; }

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
	
	private List<Permission> m_permissions; 
	@Override
	public List<Permission> getPermissionList() { return m_permissions; }
	@Override
	public void setPermissionList(List<Permission> permissions) { m_permissions = permissions; }
	
	/*****************/
	/** Constructors */
	/*****************/
	
	public Employee() {
		super();
	}

	/**
	 * @author bomi
	 * 
	 * @param id employeeId LONG
	 * @param firstname vorname STRING 
	 * @param lastname nachmane STRING
	 * @param nickname spitzname STRING
	 * @param password passwort STRING
	 * @param email email STRING
	 * @param recipes rezepte LIST<{@link Recipe}>
	 * @param menus menus LIST<{@link Menu}>
	 * @param permissions rolle LIST<{@link Permission}>
	 * @param createItem erstellDatum DATE 
	 */
	public Employee(
			long id, String firstname, String lastname,	String nickname,
			String password, String email, List<Recipe> recipes, 
			List<Menu> menus, List<Permission> permissions) {
		super(id);
		m_firstname = firstname;
		m_lastname = lastname;
		m_nickname = nickname;
		m_password = password;
		m_email = email;
		m_recipes = recipes;
		m_menus = menus;
		m_permissions = permissions;
	}
	
	/**
	 * @author bomi
	 * @category Alle Daten nur aus der Tabelle. 
	 * 
	 * @param id employeeId LONG
	 * @param firstname vorname STRING 
	 * @param lastname nachmane STRING
	 * @param nickname spitzname STRING
	 * @param password passwort STRING
	 * @param phone telefon STRING
	 * @param createItem erstellDatum DATE 
	 */ 
	public Employee(long id, String firstname, String lastname,	String nickname,
			String password, String email) {
		super(id);
		m_firstname = firstname;
		m_lastname = lastname;
		m_nickname = nickname;
		m_password = password;
		m_email = email;
	}
}
