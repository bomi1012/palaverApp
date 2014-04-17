package de.application.palaver.employee;

import java.util.List;

import de.application.palaver.menu.Menu;
import de.application.palaver.recipe.Recipe;

public interface IEmployee {
	
	long getId();
	void setId(long id);
	
	/////////////////////////////////////
	
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
	
	String getHandy();
	void setHandy(String handy);
	
	String getPhone();
	void setPhone(String phone);
	
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
