package de.application.palaver.recipe;

import java.util.List;

import de.application.palaver.article.Article;
import de.application.palaver.employee.Employee;
import de.application.palaver.menu.Menu;
import de.helper.palaver.entities.EntityName;

public class Recipe extends EntityName implements IRecipe{
	
	/*************************/
	/** Getters and Setters **/
	/*************************/
	
	private String m_commnet;
	@Override
	public String getComment() { return m_commnet; }
	@Override
	public void setComment(String comment) { m_commnet = comment; }

	private Employee m_employee; 
	@Override
	public Employee getEmployee() { return m_employee; }
	@Override
	public void setEmployee(Employee employee) { m_employee = employee; }
	
	private RecipeType m_recipeType;
	@Override
	public RecipeType getRecipeType() { return m_recipeType; }
	@Override
	public void setRecipeType(RecipeType recipeType) { m_recipeType = recipeType; }
	
	private List<Preparation> m_preparations;
	@Override
	public List<Preparation> getPreparationList() { return m_preparations; }
	@Override
	public void setPreparationList(List<Preparation> preparations) { m_preparations = preparations; }
	
	
	
	
	
	
	//TODO: --> M:N
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
	
	/**
	 * nur Tabelle Rezept
	 * @param id
	 * @param name
	 * @param comment
	 */
	public Recipe(long id, String name, String comment) {
		this(id, name, comment, null, null, null, null, null);
	}
	
	/**
	 * Tabelle Rezept mit andere Tabellen
	 * @param id
	 * @param name
	 * @param comment
	 * @param employee
	 * @param menus
	 * @param articles
	 * @param preparation
	 * @param recipeType
	 */
	public Recipe(long id, String name, String comment, Employee employee, List<Menu> menus,
			List<Article> articles, List<Preparation> preparations, RecipeType recipeType) {
		super(id, name);
		m_commnet = comment;
		m_employee = employee;
		m_menus = menus;
		m_articles = articles;
		m_preparations = preparations;
		m_recipeType = recipeType;
	}



}
