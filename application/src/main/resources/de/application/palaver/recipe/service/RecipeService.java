package de.application.palaver.recipe.service;

import java.util.List;

import de.application.palaver.recipe.Preparation;
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
}
