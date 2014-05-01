package de.application.palaver.recipe.service;

import java.util.List;

import de.application.palaver.recipe.Preparation;
import de.application.palaver.recipe.Recipe;
import de.application.palaver.recipe.RecipeArticleRelation;
import de.application.palaver.recipe.RecipeType;
import de.application.palaver.recipe.dao.RecipeDAO;


public class RecipeService {
private static RecipeService m_instance = null;
	
	public static RecipeService getInstance() {
        if (m_instance == null) {
            m_instance = new RecipeService();
        }
        return m_instance;
    }

	public RecipeService() {
		super();
	}

	public List<Preparation> findAllPreparations() {
		try {
			return RecipeDAO.getInstance().findAllPreparations();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; 
	}

	public List<RecipeType> findAllTypes() {
		try {
			return RecipeDAO.getInstance().findAllRecipeTypes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; 
	}

	public boolean createNewRecipe(Recipe recipe) {
		try {
			long recipeId = RecipeDAO.getInstance().create(recipe);
			if(recipe.getPreparationList() != null &&
					recipe.getPreparationList().size() > 0) {
				for (Preparation preparation : recipe.getPreparationList()) {
					RecipeDAO.getInstance().addRelationsForRecipe(recipeId, preparation);
				}	
			}
			if(recipe.getRecipeArticleRelationList() != null &&
					recipe.getRecipeArticleRelationList().size() > 0) {
				for (RecipeArticleRelation recipeArticleRelation : recipe.getRecipeArticleRelationList()) {
					RecipeDAO.getInstance().addRelationsForRecipe(recipeId, recipeArticleRelation);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} 	
		return false;
	}
}
