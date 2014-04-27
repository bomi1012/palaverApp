package de.application.palaver.article;

import java.util.List;

import de.application.palaver.recipe.RecipeArticleRelation;
import de.helper.palaver.entities.EntityName;

public class Article extends EntityName implements IArticle {
	
	private String m_number;
	@Override
	public String getNumber() { return m_number; }
	@Override
	public void setNumber(String number) { m_number = number; }

	private List<RecipeArticleRelation> m_recipeArticleRelationList;
	@Override
	public List<RecipeArticleRelation> getRecipeArticleRelationList() { return m_recipeArticleRelationList; }
	@Override
	public void setRecipeArticleRelationList(List<RecipeArticleRelation> recipeArticleRelations) { 
		m_recipeArticleRelationList = recipeArticleRelations; 
	}
	
	private QuantityUnit m_quantityUnit;	
	@Override
	public QuantityUnit getQuantityUnit() { return m_quantityUnit; }
	@Override
	public void setQuantityUnit(QuantityUnit quantityUnit) { m_quantityUnit = quantityUnit; }
	
	public Article() {
		super();
	}
	
	public Article(long id, String name, String number) {
		super(id, name);
		m_number = number;
	}


	
}
