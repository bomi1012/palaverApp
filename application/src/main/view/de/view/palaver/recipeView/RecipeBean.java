package de.view.palaver.recipeView;

import de.application.palaver.recipe.Recipe;
import de.view.palaver.layoutBean.Bean;

public class RecipeBean extends Bean{
	public RecipeBean() {
		super();
	}
	protected Recipe m_recipe;
	public Recipe getRecipe() { return m_recipe; }
	public void setRecipe(Recipe recipe) { m_recipe = recipe; }
}
