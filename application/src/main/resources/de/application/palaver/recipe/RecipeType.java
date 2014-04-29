package de.application.palaver.recipe;

import java.io.Serializable;

import de.helper.palaver.entities.EntityName;

public class RecipeType extends EntityName implements Serializable {
	private static final long serialVersionUID = -2158094114697986835L;

	public RecipeType() {
		super();
	}

	public RecipeType(long id, String name) {
		super(id, name);
	}

}
