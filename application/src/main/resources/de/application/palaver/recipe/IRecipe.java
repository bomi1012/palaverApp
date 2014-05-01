package de.application.palaver.recipe;

import java.util.List;

import de.application.palaver.article.Article;
import de.application.palaver.employee.Employee;
import de.application.palaver.menu.Menu;
import de.helper.palaver.entities.IEntityName;

public interface IRecipe extends IEntityName{
	
	String getComment();
	void setComment(String comment);
	
	/***************/
	/** Relations **/
	/***************/
	
	Employee getEmployee();
	void setEmployee(Employee employee);
	
	RecipeType getRecipeType();
	void setRecipeType(RecipeType recipeType);	
	
	List<Preparation> getPreparationList();
	void setPreparationList(List<Preparation> preparations);
	
	
	
	
	
	List<Menu> getMenuList();
	void setMenuList(List<Menu> menus);
	
	List<Article> getArticleList();
	void setArticleList(List<Article> articles);
	
	List<RecipeArticleRelation> getRecipeArticleRelationList();
	void setRecipeArticleRelationList(List<RecipeArticleRelation> recipeArticleRelations);
}
