package de.application.palaver.articleDAO;

import java.sql.SQLException;
import java.util.List;

import de.application.palaver.ICUD;
import de.application.palaver.article.Article;
import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

public interface IArticleDAO extends ICUD {
	
	String FIELD_ID = "id";
	String FIELD_NAME = "name";
	String FIELD_NUMMER = "artikelnr";
	
	/**
	 * Nur Lebensmittel
	 * @param complete 
	 * @return
	 * @throws ConnectException
	 * @throws DAOException
	 * @throws SQLException
	 */
	List<Article> findAllFoods(boolean complete) throws ConnectException, DAOException, SQLException;
	
	
}
