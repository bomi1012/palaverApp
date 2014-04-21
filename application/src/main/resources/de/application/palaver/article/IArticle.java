package de.application.palaver.article;

import java.util.List;

import de.application.palaver.recipe.RecipeArticleRelation;
import de.helper.palaver.entities.IEntityName;

public interface IArticle extends IEntityName {

	String getNumber();
	void setNumber(String number);
	
	List<RecipeArticleRelation> getRecipeArticleRelationList();
	void setRecipeArticleRelationList(List<RecipeArticleRelation> recipeArticleRelations);
}
