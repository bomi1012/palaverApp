package de.application.palaver.recipe;

import java.io.Serializable;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import de.helper.palaver.constants.IBeanDictionary;
import de.helper.palaver.entities.EntityName;

@FacesConverter(forClass = RecipeType.class, value = "convert")
public class RecipeType extends EntityName implements Serializable, Converter {
	private static final long serialVersionUID = -2158094114697986835L;

	public RecipeType() {
		super();
	}

	public RecipeType(long id, String name) {
		super(id, name);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		List<RecipeType> list = (List<RecipeType>) FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(IBeanDictionary.RECIPE_TYPE_LIST);
		
		for (RecipeType recipeType : list) {
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
