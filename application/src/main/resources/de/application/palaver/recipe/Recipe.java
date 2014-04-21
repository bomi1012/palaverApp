package de.application.palaver.recipe;

import java.util.List;

import de.application.palaver.article.Article;
import de.application.palaver.employee.Employee;
import de.application.palaver.menu.Menu;
import de.helper.palaver.entities.EntityName;

public class Recipe extends EntityName implements IRecipe{
	
	/************************/
	/** Getters and Setters */
	/************************/

	private Employee m_employee; 
	@Override
	public Employee getEmployee() { return m_employee; }
	@Override
	public void setEmployee(Employee employee) { m_employee = employee; }
	
	private List<Menu> m_menus;
	@Override
	public List<Menu> getMenuList() { return m_menus; }
	@Override
	public void setMenuList(List<Menu> menus) { m_menus = menus; }
	
	private List<Article> m_articles;
	@Override
	public List<Article> getArticleList() { return m_articles; }
	@Override
	public void setArticleList(List<Article> articles) { m_articles = articles; }
	
	private Preparation m_preparation;
	@Override
	public Preparation getPreparation() { return m_preparation; }
	@Override
	public void setPreparation(Preparation preparation) { m_preparation = preparation; }
	
	private RecipeType m_recipeType;
	@Override
	public RecipeType getRecipeType() { return m_recipeType; }
	@Override
	public void setRecipeType(RecipeType recipeType) { m_recipeType = recipeType; }
	
	private List<RecipeArticleRelation> m_recipeArticleRelationList;
	@Override
	public List<RecipeArticleRelation> getRecipeArticleRelationList() { return m_recipeArticleRelationList; }
	@Override
	public void setRecipeArticleRelationList(List<RecipeArticleRelation> recipeArticleRelations) { 
		m_recipeArticleRelationList = recipeArticleRelations; 
	}
	
	/*****************/
	/** Constructors */
	/*****************/
	
	public Recipe() {
		super();
	}
	
	public Recipe(long id, String name, Employee employee, List<Menu> menus,
			List<Article> articles, Preparation preparation, RecipeType recipeType) {
		super(id, name);
		m_employee = employee;
		m_menus = menus;
		m_articles = articles;
		m_preparation = preparation;
		m_recipeType = recipeType;
	}

}
