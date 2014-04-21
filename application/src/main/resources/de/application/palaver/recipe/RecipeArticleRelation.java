package de.application.palaver.recipe;

import de.application.palaver.article.Article;
import de.application.palaver.article.Unit;
import de.helper.palaver.entities.Entity;

public class RecipeArticleRelation extends Entity implements IRecipeArticleRelation{

	private Article m_article;
	@Override
	public void setArticle(Article article) { m_article = article; }
	@Override
	public Article getArticle() { return m_article; }

	private double m_quantity;
	@Override
	public double getQuantity() { return m_quantity; }
	@Override
	public void setQuantity(double quantity) { m_quantity = quantity; }
	
	private Unit m_unit; 
	@Override
	public Unit getUnit() { return m_unit; }
	@Override
	public void setUnit(Unit unit) { m_unit = unit; }
	
	private Recipe m_recipe;
	@Override
	public Recipe getRecipe() { return m_recipe; }
	@Override
	public void setRecipe(Recipe recipe) { m_recipe = recipe; }
	
	public RecipeArticleRelation() {
		super();
	}
	
	public RecipeArticleRelation(long id, Article article, double quantity, Unit unit, Recipe recipe) {
		super(id);
		m_article = article;
		m_quantity = quantity;
		m_unit = unit;
		m_recipe = recipe;
	}
	

	
}