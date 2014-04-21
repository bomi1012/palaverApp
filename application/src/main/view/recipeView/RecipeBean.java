package recipeView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.DragDropEvent;
import org.primefaces.model.DualListModel;

import de.application.palaver.article.Article;
import de.application.palaver.articleService.ArticleService;
import de.application.palaver.recipe.Preparation;
import de.application.palaver.recipe.RecipeArticleRelation;
import de.application.palaver.recipe.service.RecipeService;

@ManagedBean
@SessionScoped
public class RecipeBean implements Serializable {
	private static final long serialVersionUID = -2786447515450216664L;

	private DualListModel<Preparation> m_preparationList;
	public DualListModel<Preparation> getPreparationList() { return m_preparationList; }
	public void setPreparationList(DualListModel<Preparation> preparationList) { m_preparationList = preparationList; }

	private List<RecipeArticleRelation> m_recipeItem;
	public List<RecipeArticleRelation> getRecipeItem() { return m_recipeItem; }
	
	private List<Article> m_availableArticles;
	public List<Article> getAvailableArticles() { return m_availableArticles; }
	
	public RecipeBean() {
		super();
		List<Preparation> source = RecipeService.getInstance().findAllPreparations();
		List<Preparation> target = new ArrayList<Preparation>();
 		m_preparationList = new DualListModel<Preparation>(source, target); 
 		m_availableArticles = ArticleService.getInstance().findFoods();
 		m_recipeItem = new ArrayList<RecipeArticleRelation>();
	}


    public void testButtonActionListener(ActionEvent event) {
        System.out.println("testButtonActionListener invoked");
    }

	 public void onDrop(DragDropEvent ddEvent) {  
		 
		 System.out.println("onDrop");
		 
	        Article article = ((Article) ddEvent.getData());  	  
	        m_availableArticles.remove(article);  
//	      // carsSmall.remove(car);  
	    }  
}
