package de.application.palaver.recipe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.application.palaver.recipe.Preparation;
import de.application.palaver.recipe.Recipe;
import de.application.palaver.recipe.RecipeArticleRelation;
import de.application.palaver.recipe.RecipeType;
import de.helper.palaver.db.AbstractDAO;
import de.helper.palaver.db.TablesEnum;
import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

public class RecipeDAO extends AbstractDAO implements IRecipeDAO {
	private static final long serialVersionUID = 5354127150748765486L;
	private static RecipeDAO m_instance = null;
	private List<Preparation> m_preparationList;
	private List<RecipeType> m_recipeTypeList;
	private static final String GET_ALL_PREPARATIONS = "SELECT * FROM "
			+ TablesEnum.RECIPE_PREPARATION.getName();
	private static final String GET_ALL_RECIPE_TYPES = "SELECT * FROM "
			+ TablesEnum.RECIPE_TYPES.getName();
	
	public static RecipeDAO getInstance() {
        if (m_instance == null) {
            m_instance = new RecipeDAO();
        }
        return m_instance;
    }
	
	public RecipeDAO() {
		super();
	}
	
	public List<Preparation> findAllPreparations() throws ConnectException, DAOException, SQLException {
		m_preparationList = new ArrayList<Preparation>();
		m_resultSet = getManaged(GET_ALL_PREPARATIONS);
		while (m_resultSet.next()) {
				m_preparationList.add(setPreparation(m_resultSet));
		}
		return m_preparationList;
	}
	
	
	public List<RecipeType> findAllRecipeTypes() throws ConnectException, DAOException, SQLException {
		m_recipeTypeList= new ArrayList<RecipeType>();
		m_resultSet = getManaged(GET_ALL_RECIPE_TYPES);
		while (m_resultSet.next()) {
				m_recipeTypeList.add(setRecipeType(m_resultSet));
		}
		return m_recipeTypeList;
	}
	
	

	@Override
	public long create(Object o) throws ConnectException, DAOException {
		if(o instanceof Recipe) {
			Recipe recipe = (Recipe) o;
			return putManaged("INSERT INTO " + TablesEnum.RECIPE.getName() + " (" + 
					FIELD_NAME + ", " + 
					FIELD_COMMENT + ", " +
					FIELD_RECIPE_TYPE_FK + ", " +
					FIELD_EMPLOYEE_FK + ") VALUES ('" + 
					recipe.getName() + "', '" + 
					recipe.getComment() + "', " +
					recipe.getRecipeType().getId() + ", " +
					recipe.getEmployee().getId() + ")");
		}
		return -1L;
	}
	
	//TODO: use not putManaged
	public long addRelationsForRecipe(long recipeId, Object o) throws ConnectException, DAOException {
		if(o instanceof Preparation) {
			return putManaged("INSERT INTO " + TablesEnum.RECIPE_HAS_PREPARATION.getName() + " (" + 
					FIELD_RECIPE_FK + ", " + 
					FIELD_PREPARATION_FK + ") VALUES (" + 
					recipeId + ", " + 
					((Preparation) o).getId() + ")");
		} 
		if (o instanceof RecipeArticleRelation) {
			return putManaged("INSERT INTO " + TablesEnum.RECIPE_HAS_ARTICLE.getName() + " (" + 
					FIELD_RECIPE_FK + ", " + 
					FIELD_ARTICLE_FK + ", " +
					FIELD_QUANTITY + ") VALUES (" + 
					recipeId + ", " + 
					((RecipeArticleRelation) o).getArticle().getId() + ", " +
					((RecipeArticleRelation) o).getQuantity() + ")");
		}
		return -1L;
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		
	}

	
	private Preparation setPreparation(ResultSet resultSet) throws SQLException {
		return new Preparation(
				resultSet.getLong(FIELD_ID),
				resultSet.getString(FIELD_NAME));
	}
	
	private RecipeType setRecipeType(ResultSet resultSet) throws SQLException {
		return new RecipeType(
				resultSet.getLong(FIELD_ID),
				resultSet.getString(FIELD_NAME));
	}
	
	
}
