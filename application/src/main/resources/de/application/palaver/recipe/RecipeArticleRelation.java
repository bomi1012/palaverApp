package de.application.palaver.recipe;

import de.application.palaver.article.Article;
import de.helper.palaver.entities.Entity;

public class RecipeArticleRelation extends Entity implements IRecipeArticleRelation{

	private Article m_article;
	@Override
	public void setArticle(Article article) { m_article = article; }
	@Override
	public Article getArticle() { return m_article; }
	
	private Recipe m_recipe;
	@Override
	public Recipe getRecipe() { return m_recipe; }
	@Override
	public void setRecipe(Recipe recipe) { m_recipe = recipe; }

	private double m_quantity;
	@Override
	public double getQuantity() { return  m_quantity; }
	@Override
	public void setQuantity(double quantity) { m_quantity = quantity; }
		
	public RecipeArticleRelation() {
		super();
	}
	
	public RecipeArticleRelation(Article article, double quantity) {
		this(0, article, quantity, null);
	}
	
	public RecipeArticleRelation(long id, Article article, double quantity, Recipe recipe) {
		super(id);
		m_article = article;
		m_quantity = quantity;
		m_recipe = recipe;
	}
	
	

	
}