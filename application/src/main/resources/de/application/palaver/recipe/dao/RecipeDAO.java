package de.application.palaver.recipe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.application.palaver.employee.Employee;
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
	
	private List<Recipe> m_recipeList;
	private List<Preparation> m_preparationList;
	private List<RecipeType> m_recipeTypeList;
	
	private static final String GET_ALL_PREPARATIONS = "SELECT * FROM "
			+ TablesEnum.RECIPE_PREPARATION.getName();
	private static final String GET_ALL_RECIPE_TYPES = "SELECT * FROM "
			+ TablesEnum.RECIPE_TYPES.getName();
	private static final String GET_ALL_RECIPES_FOR_TABLE = "SELECT " +
			"r.id, r.name, r.kommentar, r.erstellt, " +
			"e.id, e.benutzername, " +
			"t.id, t.name FROM "
			+ TablesEnum.RECIPE.getName() + " r " 
			+ "JOIN " + TablesEnum.EMPLOYEE.getName() + " e " 
			+ "ON r.mitarbeiter_fk = e.id " 
			+ "JOIN " + TablesEnum.RECIPE_TYPES.getName() + " t "
			+ "ON r.rezeptart_fk = t.id";
	
	
	public static RecipeDAO getInstance() {
		if (m_instance == null) {
			m_instance = new RecipeDAO();
		}
		return m_instance;
	}

	public RecipeDAO() {
		super();
	}
	
	/*****************/
	/***** Recipe ****/
	/**
	 * @throws SQLException 
	 * @throws DAOException 
	 * @throws ConnectException ***************/

	public List<Recipe> findAllRecipesForTable() throws ConnectException, DAOException, SQLException {
		m_recipeList = new ArrayList<Recipe>();
		m_resultSet = getManaged(GET_ALL_RECIPES_FOR_TABLE);
		while (m_resultSet.next()) {
			m_recipeList.add(setRecipeTable(m_resultSet));
		}
		return m_recipeList;
	}
	
	private Recipe setRecipeTable(ResultSet resultSet) throws SQLException {		

		Employee employee = new Employee(
				resultSet.getLong(5),
				resultSet.getString(6));
		
		RecipeType recipeType = new RecipeType(
				resultSet.getLong(7),
				resultSet.getString(8));
		
		return new Recipe(
				resultSet.getLong(FIELD_ID),
				resultSet.getString(FIELD_NAME),
				resultSet.getString(FIELD_COMMENT),
				employee, null, null, null, recipeType);
	}
	
	/*****************/
	/** Preparation **/
	/*****************/
	
	public List<Preparation> findAllPreparations() throws ConnectException,
			DAOException, SQLException {
		m_preparationList = new ArrayList<Preparation>();
		m_resultSet = getManaged(GET_ALL_PREPARATIONS);
		while (m_resultSet.next()) {
			m_preparationList.add(setPreparation(m_resultSet));
		}
		return m_preparationList;
	}
	
	private Preparation setPreparation(ResultSet resultSet) throws SQLException {
		return new Preparation(resultSet.getLong(FIELD_ID),
				resultSet.getString(FIELD_NAME));
	}
	
	
	/*****************/
	/** Recipe type **/
	/*****************/
	
	public List<RecipeType> findAllRecipeTypes() throws ConnectException,
			DAOException, SQLException {
		m_recipeTypeList = new ArrayList<RecipeType>();
		m_resultSet = getManaged(GET_ALL_RECIPE_TYPES);
		while (m_resultSet.next()) {
			m_recipeTypeList.add(setRecipeType(m_resultSet));
		}
		return m_recipeTypeList;
	}
	
	private RecipeType setRecipeType(ResultSet resultSet) throws SQLException {
		return new RecipeType(resultSet.getLong(FIELD_ID),
				resultSet.getString(FIELD_NAME));
	}
	
	
	////////////////////////////////////////////////////////////////////////////

	@Override
	public long create(Object o) throws ConnectException, DAOException {
		if (o instanceof Recipe) {
			Recipe recipe = (Recipe) o;
			return insertIntoTable("INSERT INTO " + TablesEnum.RECIPE.getName()
					+ " (" + FIELD_NAME + ", " + FIELD_COMMENT + ", "
					+ FIELD_RECIPE_TYPE_FK + ", " + FIELD_EMPLOYEE_FK
					+ ") VALUES ('" + recipe.getName() + "', '"
					+ recipe.getComment() + "', "
					+ recipe.getRecipeType().getId() + ", "
					+ recipe.getEmployee().getId() + ")");
		}
		return -1L;
	}

	public void addRelationsForRecipe(long recipeId, Object o)
			throws ConnectException, DAOException {
		if (o instanceof Preparation) {
			putManaged("INSERT INTO "
					+ TablesEnum.RECIPE_HAS_PREPARATION.getName() + " ("
					+ FIELD_RECIPE_FK + ", " + FIELD_PREPARATION_FK
					+ ") VALUES (" + recipeId + ", "
					+ ((Preparation) o).getId() + ")");
		}
		if (o instanceof RecipeArticleRelation) {
			putManaged("INSERT INTO " + TablesEnum.RECIPE_HAS_ARTICLE.getName()
					+ " (" + FIELD_RECIPE_FK + ", " + FIELD_ARTICLE_FK + ", "
					+ FIELD_QUANTITY + ") VALUES (" + recipeId + ", "
					+ ((RecipeArticleRelation) o).getArticle().getId() + ", "
					+ ((RecipeArticleRelation) o).getQuantity() + ")");
		}
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub

	}


}
