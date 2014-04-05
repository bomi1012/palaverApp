package de.application.palaver.employee;

import java.util.List;

import de.application.palaver.recipe.Recipe;

public interface IEmployee {
	
	long getId();
	void setId(long id);
	
	String getFirstname();
	void setFirstname(String firstname);
	
	String getLastname();
	void setLastname(String lastname);
	
	String getNickname();
	void setNickmane(String nickname);
	
	List<Recipe> getRecipeList();
	void setRecipeList(List<Recipe> recipes);
}
