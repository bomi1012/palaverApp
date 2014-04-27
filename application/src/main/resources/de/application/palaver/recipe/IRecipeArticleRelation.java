package de.application.palaver.recipe;

import de.application.palaver.article.Article;
import de.helper.palaver.entities.IEntity;

public interface IRecipeArticleRelation extends IEntity {

	Article getArticle();
	void setArticle(Article article);
	
	double getQuantity();
	void setQuantity(double quantity);
	
	Recipe getRecipe();
	void setRecipe(Recipe recipe);
}
