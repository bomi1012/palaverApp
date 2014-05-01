package de.application.palaver.recipe.dao;

import de.application.palaver.ICUD;

public interface IRecipeDAO extends ICUD {
	String FIELD_ID = "id";
	String FIELD_NAME = "name";
	String FIELD_COMMENT = "kommentar";
	String FIELD_QUANTITY = "menge";
	
	String FIELD_RECIPE_TYPE_FK = "rezeptart_fk";
	String FIELD_EMPLOYEE_FK = "mitarbeiter_fk";
	String FIELD_RECIPE_FK = "rezept_fk";
	String FIELD_PREPARATION_FK = "zubereitung_fk";
	String FIELD_ARTICLE_FK = "artikel_fk";
}
