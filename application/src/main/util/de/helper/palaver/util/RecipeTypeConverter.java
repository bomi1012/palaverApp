package de.helper.palaver.util;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import de.application.palaver.recipe.RecipeType;
import de.helper.palaver.constants.IBeanDictionary;

@SuppressWarnings("unchecked")
@FacesConverter(forClass = RecipeType.class, value = "recipeTypeConverter")
public class RecipeTypeConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
	
		for (RecipeType recipeType : (List<RecipeType>) FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(IBeanDictionary.RECIPE_TYPE_LIST)) {
			if(Long.valueOf(value) == recipeType.getId()) {
				return recipeType;
			}
		}
		return "no_found";
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return String.valueOf(((RecipeType) value).getId());
	}
}
