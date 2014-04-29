package de.view.palaver.recipeView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.event.DragDropEvent;
import org.primefaces.model.DualListModel;

import de.application.palaver.article.Article;
import de.application.palaver.articleService.ArticleService;
import de.application.palaver.articleService.QuantityUnitService;
import de.application.palaver.employee.Employee;
import de.application.palaver.employee.service.EmployeeService;
import de.application.palaver.recipe.Preparation;
import de.application.palaver.recipe.Recipe;
import de.application.palaver.recipe.RecipeArticleRelation;
import de.application.palaver.recipe.RecipeType;
import de.application.palaver.recipe.service.RecipeService;
import de.helper.palaver.constants.IBeanDictionary;

@ManagedBean
@SessionScoped
public class RecipeBean implements Serializable {
	private static final long serialVersionUID = -2786447515450216664L;
	
	private Recipe m_recipe;
	public Recipe getRecipe() { return m_recipe; }
	public void setRecipe(Recipe recipe) { m_recipe = recipe; }
	
	private RecipeType m_selectedType;
	public RecipeType getSelectedType() { return m_selectedType; }
	public void setSelectedType(RecipeType selectedType) { m_selectedType = selectedType; }
	
	private DualListModel<Preparation> m_preparationList;
	public DualListModel<Preparation> getPreparationList() { return m_preparationList; }
	public void setPreparationList(DualListModel<Preparation> preparationList) { m_preparationList = preparationList; }
	
	private List<RecipeType> m_recipeTypeList;
	public List<RecipeType> getRecipeTypeList() { return m_recipeTypeList;  }
	public void setRecipeTypeList(List<RecipeType> recipeTypeList) { m_recipeTypeList = recipeTypeList; }  

	private List<Employee> m_employeeList;
	public List<Employee> getEmployeeList() { return m_employeeList; }
	public void setEmployeeList(List<Employee> employeeList) { m_employeeList = employeeList; }
	
	private Employee m_currentEmployee;
	public Employee getCurrentEmployee() { return m_currentEmployee; }
	
	private List<RecipeArticleRelation> m_recipeItemList;
	public List<RecipeArticleRelation> getRecipeItemList() { return m_recipeItemList; }
	
	private List<Article> m_availableArticles;	
	public List<Article> getAvailableArticles() { return m_availableArticles; }
	
	public RecipeBean() {
		super();	
		m_recipe = new Recipe();
		List<Preparation> source = RecipeService.getInstance().findAllPreparations();
		List<Preparation> target = new ArrayList<Preparation>();
 		m_preparationList = new DualListModel<Preparation>(source, target);  
 		m_availableArticles = ArticleService.getInstance().findFoods();
 		m_recipeItemList = new ArrayList<RecipeArticleRelation>();
 		m_employeeList = EmployeeService.getInstance().getAllOnlyTable();
 		m_currentEmployee = (Employee) FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(IBeanDictionary.AUTHORIZED_USER);
 		m_recipeTypeList = RecipeService.getInstance().findAllTypes();
 		
		FacesContext.getCurrentInstance()
		.getExternalContext()
		.getSessionMap()
		.put(IBeanDictionary.RECIPE_TYPE_LIST, m_recipeTypeList);	
	}


    public void testButtonActionListener(ActionEvent event) {
        System.out.println("testButtonActionListener invoked: " + m_selectedType.getName());
        
        //m_recipe.setRecipeType(m_selectedType);
        m_recipe.setEmployee((Employee)FacesContext.getCurrentInstance().getExternalContext()
		.getSessionMap().get(IBeanDictionary.AUTHORIZED_USER));
    }
    


	 public void onDrop(DragDropEvent ddEvent) {  		 
		 	System.out.println("onDrop Start");		 
	        Article article = ((Article) ddEvent.getData());  	  
	        m_availableArticles.remove(article);  
	        article.setQuantityUnit(QuantityUnitService.getInstance().findByArticleId(article.getId()));
	        
	        m_recipeItemList.add(new RecipeArticleRelation(article, 0.0));
	        
	        System.out.println("onDrop Finish");	
	    }
	 
	 
	 public void s(ValueChangeEvent e){
			System.out.print(e.getNewValue());
		}
}
