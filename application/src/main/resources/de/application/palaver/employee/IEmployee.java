package de.application.palaver.employee;

import java.util.List;

import de.application.palaver.menu.Menu;
import de.application.palaver.recipe.Recipe;
import de.helper.palaver.entities.IEntity;

public interface IEmployee extends IEntity {
	
	String getFirstname();
	void setFirstname(String firstname);
	
	String getLastname();
	void setLastname(String lastname);
	
	String getNickname();
	void setNickmane(String nickname);
	
	String getPassword();
	void setPassword(String password);
	
	String getEmail();
	void setEmail(String email);
	
	///
	/// Relations
	///
	
	List<Recipe> getRecipeList();
	void setRecipeList(List<Recipe> recipes);
	
	List<Menu> getMenuList();
	void setMenuList(List<Menu> menus);
	
	List<Permission> getPermissionList();
	void setPermissionList(List<Permission> permissions);
	

}
