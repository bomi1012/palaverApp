package de.application.palaver.recipe;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

import de.helper.palaver.entities.EntityName;

@FacesConverter(forClass = Preparation.class, value = "con")
public class Preparation extends EntityName implements Serializable, Converter {
	private static final long serialVersionUID = -1776398426725392291L;

	public Preparation() {
		super();
	}

	public Preparation(long id, String name) {
		super(id, name);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Object ret = null;
		if (component instanceof PickList) {
			Object dualList = ((PickList) component).getValue();
			DualListModel dl = (DualListModel) dualList;
			for (Object o : dl.getSource()) {
				String name = "" + ((Preparation) o).getName();
				if (value.equals(name)) {
					ret = o;
					break;
				}
			}
			if (ret == null)
				for (Object o : dl.getTarget()) {
					String name = "" + ((Preparation) o).getName();
					if (value.equals(name)) {
						ret = o;
						break;
					}
				}
		}
		return ret;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		 String str = "";
		 if (value instanceof Preparation) {
		 str = "" + ((Preparation) value).getName();
		 }
		 return str;
	}
}
