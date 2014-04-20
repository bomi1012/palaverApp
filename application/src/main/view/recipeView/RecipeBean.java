package recipeView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.model.DualListModel;

import de.application.palaver.recipe.Preparation;
import de.application.palaver.recipe.service.RecipeService;

@ManagedBean
@SessionScoped
public class RecipeBean implements Serializable {
	private static final long serialVersionUID = -2786447515450216664L;

	private DualListModel<Preparation> m_preparationList;
	public DualListModel<Preparation> getPreparationList() { return m_preparationList; }
	public void setPreparationList(DualListModel<Preparation> preparationList) { m_preparationList = preparationList; }

	public RecipeBean() {
		super();
		List<Preparation> source = RecipeService.getInstance().findAllPreparations();
		List<Preparation> target = new ArrayList<Preparation>();
 		m_preparationList = new DualListModel<Preparation>(source, target);  
	}

	
//	 public String testButtonAction() {
//	        System.out.println("testButtonAction invoked");
//	        return "anotherPage.xhtml";
//	    }

	    public void testButtonActionListener(ActionEvent event) {
	        System.out.println("testButtonActionListener invoked");
	    }
	
}
