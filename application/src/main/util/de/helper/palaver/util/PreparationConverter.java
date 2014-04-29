package de.helper.palaver.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

import de.application.palaver.recipe.Preparation;

@SuppressWarnings("rawtypes")
@FacesConverter(forClass = Preparation.class, value = "preparationConverter")
public class PreparationConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Object returnObject = null;
		if (component instanceof PickList) {
			DualListModel dl = (DualListModel) ((PickList) component).getValue();
			for (Object object : dl.getSource()) {
				if (value.equals(((Preparation) object).getName())) {
					returnObject = object;
					break;
				}
			}
			if (returnObject == null)
				for (Object object : dl.getTarget()) {
					if (value.equals(((Preparation) object).getName())) {
						returnObject = object;
						break;
					}
				}
		}
		return returnObject;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		 if (value instanceof Preparation) {
			 return ((Preparation) value).getName();
		 }
		 return "";
	}
}
