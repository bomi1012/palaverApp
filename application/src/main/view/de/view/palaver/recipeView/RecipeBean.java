package de.view.palaver.recipeView;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import de.application.palaver.employee.Employee;
import de.application.palaver.recipe.Recipe;
import de.helper.palaver.constants.IBeanDictionary;

public class RecipeBean {
	public RecipeBean() {
		super();
	}
	protected Recipe m_recipe;
	public Recipe getRecipe() { return m_recipe; }
	public void setRecipe(Recipe recipe) { m_recipe = recipe; }

	
	protected Employee m_employee = (Employee) FacesContext.getCurrentInstance().getExternalContext()
			.getSessionMap().get(IBeanDictionary.AUTHORIZED_USER);
	
	
	protected void getMessage(String id, Severity facesMessage, String name, String message) {
    	FacesContext.getCurrentInstance().addMessage(id, new FacesMessage(facesMessage, name, message));
	}
}
