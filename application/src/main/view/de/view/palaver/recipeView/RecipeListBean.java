package de.view.palaver.recipeView;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import de.application.palaver.recipe.Recipe;
import de.application.palaver.recipe.service.RecipeService;

@ManagedBean(name = "recipeListBean")
@SessionScoped
public class RecipeListBean extends RecipeBean implements Serializable{
	private static final long serialVersionUID = -7356305198019047045L;
	
	private List<Recipe> m_recipeList;
	public List<Recipe> getRecipeList() { return m_recipeList; }
	public void setRecipeList(List<Recipe> recipeList) { m_recipeList = recipeList; }
	
	public RecipeListBean() {
		super();
		m_recipeList = RecipeService.getInstance().findAllRecipesForTable();
	}

}
