package de.application.palaver.articleDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.application.palaver.article.Article;
import de.helper.palaver.db.AbstractDAO;
import de.helper.palaver.db.TablesEnum;
import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

public class ArticleDAO extends AbstractDAO implements IArticleDAO {
	private static final long serialVersionUID = 1670364747580780268L;
	private static ArticleDAO m_instance = null;
	private ArrayList<Article> m_articleList;
	
	//TODO: Jetzt nimmt alles --> später abfragen nur lebensmittel
	private static final String GET_FOOD_LIST = "SELECT * FROM "
			+ TablesEnum.ARTICLE.getName();
	

	public ArticleDAO() {
		super();
	}

	public static ArticleDAO getInstance() {
		if (m_instance == null) {
			m_instance = new ArticleDAO();
		}
		return m_instance;
	}

	@Override
	public List<Article> findAllFoods(boolean complete) throws ConnectException,
			DAOException, SQLException {
		m_articleList = new ArrayList<Article>();
		m_resultSet = getManaged(GET_FOOD_LIST);
		while (m_resultSet.next()) {
			if(!complete) {
				m_articleList.add(setArticle(m_resultSet));
			} else {
				// m_articleList.add(setArticleComplete(m_resultSet));
			}
		}
		return m_articleList;
	}
	

	private Article setArticle(ResultSet resultSet) throws SQLException {
		return new Article(
				resultSet.getLong(FIELD_ID),
				resultSet.getString(FIELD_NAME), 
				resultSet.getString(FIELD_NUMMER));
	}

	@Override
	public long create(Object o) {
		// TODO Auto-generated method stub
		return 0;
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
