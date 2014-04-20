package de.application.palaver.recipe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.application.palaver.recipe.Preparation;
import de.helper.palaver.db.AbstractDAO;
import de.helper.palaver.db.TablesEnum;
import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

public class RecipeDAO extends AbstractDAO implements IRecipeDAO {
	private static final long serialVersionUID = 5354127150748765486L;
	private static RecipeDAO m_instance = null;
	private List<Preparation> m_preparationList;
	private static final String GET_ALL_PREPARATIONS = "SELECT * FROM "
			+ TablesEnum.PREPARATION.getName();
	
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
	

	@Override
	public long create() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}	
	
	private Preparation setPreparation(ResultSet resultSet) throws SQLException {
		return new Preparation(
				resultSet.getLong(FIELD_ID),
				resultSet.getString(FIELD_NAME));
	}

}
