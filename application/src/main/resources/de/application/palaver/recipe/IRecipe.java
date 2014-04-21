package de.application.palaver.recipe;

import java.util.List;

import de.application.palaver.article.Article;
import de.application.palaver.employee.Employee;
import de.application.palaver.menu.Menu;
import de.helper.palaver.entities.IEntityName;

public interface IRecipe extends IEntityName{
	
	Preparation getPreparation();
	void setPreparation(Preparation preparation);
	
	RecipeType getRecipeType();
	void setRecipeType(RecipeType recipeType);
	
	Employee getEmployee();
	void setEmployee(Employee employee);
	
	List<Menu> getMenuList();
	void setMenuList(List<Menu> menus);
	
	List<Article> getArticleList();
	void setArticleList(List<Article> articles);
	
	List<RecipeArticleRelation> getRecipeArticleRelationList();
	void setRecipeArticleRelationList(List<RecipeArticleRelation> recipeArticleRelations);
}
