package de.application.palaver.recipe;

import de.application.palaver.article.Article;
import de.application.palaver.article.Unit;
import de.helper.palaver.entities.IEntity;

public interface IRecipeArticleRelation extends IEntity {

	Article getArticle();
	void setArticle(Article article);
	
	double getQuantity();
	void setQuantity(double quantity);
	
	Unit getUnit();
	void setUnit(Unit unit);
	
	Recipe getRecipe();
	void setRecipe(Recipe recipe);
}
