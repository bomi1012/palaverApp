package de.view.palaver.recipeView;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "recipeListBean")
@SessionScoped
public class RecipeListBean extends RecipeBean implements Serializable{
	private static final long serialVersionUID = -7356305198019047045L;
	
	
	public RecipeListBean() {
		super();
	}

}
