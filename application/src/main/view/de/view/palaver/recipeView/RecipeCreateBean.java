package de.view.palaver.recipeView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.DragDropEvent;
import org.primefaces.model.DualListModel;

import de.application.palaver.article.Article;
import de.application.palaver.articleService.ArticleService;
import de.application.palaver.articleService.QuantityUnitService;
import de.application.palaver.recipe.Preparation;
import de.application.palaver.recipe.Recipe;
import de.application.palaver.recipe.RecipeArticleRelation;
import de.application.palaver.recipe.RecipeType;
import de.application.palaver.recipe.service.RecipeService;
import de.helper.palaver.constants.IBeanDictionary;

@ManagedBean(name = "recipeCreateBean")
@SessionScoped
public class RecipeCreateBean extends RecipeBean implements Serializable {
	private static final long serialVersionUID = -2786447515450216664L;
	
	/*RecipeType*/
	private List<RecipeType> m_recipeTypeList;
	public List<RecipeType> getRecipeTypeList() { return m_recipeTypeList;  }
	public void setRecipeTypeList(List<RecipeType> recipeTypeList) { m_recipeTypeList = recipeTypeList; } 
	
	private RecipeType m_selectedType;
	public RecipeType getSelectedType() { return m_selectedType; }
	public void setSelectedType(RecipeType selectedType) { m_selectedType = selectedType; }
	
	/*PreparationList (getSource and getTarget)*/	
	private DualListModel<Preparation> m_preparationList;
	public DualListModel<Preparation> getPreparationList() { return m_preparationList; }
	public void setPreparationList(DualListModel<Preparation> preparationList) { m_preparationList = preparationList; }
	
 	/*RecipeArticleRelation*/
	private List<RecipeArticleRelation> m_recipeItemList;
	public List<RecipeArticleRelation> getRecipeItemList() { return m_recipeItemList; }
	
	private List<Article> m_availableArticles;	
	public List<Article> getAvailableArticles() { return m_availableArticles; }
	
	/*Filter*/
	private List<Article> m_filterList;
	public List<Article> getFilter() { return m_filterList; }
	public void setFilter(List<Article> list) { m_filterList = list; }
	
	public RecipeCreateBean() {
		super();
		m_recipe = new Recipe();
		List<Preparation> source = RecipeService.getInstance().findAllPreparations();
		List<Preparation> target = new ArrayList<Preparation>();
 		m_preparationList = new DualListModel<Preparation>(source, target);  
 		m_availableArticles = ArticleService.getInstance().findFoods();
 		m_recipeItemList = new ArrayList<RecipeArticleRelation>();	
 		m_recipeTypeList = RecipeService.getInstance().findAllTypes(); 		
 		
 		/*********************/
 		
		FacesContext.getCurrentInstance()
		.getExternalContext()
		.getSessionMap()
		.put(IBeanDictionary.RECIPE_TYPE_LIST, m_recipeTypeList);	
	}

    public void createButtonActionListener(ActionEvent event) {
        m_recipe.setRecipeType(m_selectedType);
        m_recipe.setEmployee(m_employee);
        m_recipe.setPreparationList(m_preparationList.getTarget());
        m_recipe.setRecipeArticleRelationList(m_recipeItemList);
        boolean isCreated = RecipeService.getInstance().createNewRecipe(m_recipe);
        
        if(isCreated) {
        	getMessage("growl", FacesMessage.SEVERITY_INFO, "Erfolgreich", 
        			"Den Rezept wurde erfolgreich hinzugefügt!");
        } else {
        	getMessage("growl", FacesMessage.SEVERITY_ERROR, "Fehlemeldung", 
        			"Den Rezept wurde wegen eine unbekannte Fehlermeldung nicht hinzugefügt!");
        }
    }
      
    public void onDrop(DragDropEvent ddEvent) {  	 
	        Article article = ((Article) ddEvent.getData());  	  
	        m_availableArticles.remove(article);  
	        article.setQuantityUnit(QuantityUnitService.getInstance().findByArticleId(article.getId()));        
	        m_recipeItemList.add(new RecipeArticleRelation(article, 0.0));
    }	 
}
