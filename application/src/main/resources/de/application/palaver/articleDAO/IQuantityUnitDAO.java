package de.application.palaver.articleDAO;

import java.sql.SQLException;

import de.application.palaver.ICUD;
import de.application.palaver.article.QuantityUnit;
import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

public interface IQuantityUnitDAO extends ICUD {
	String FIELD_ID = "id";
	String FIELD_NAME = "name";
	
	QuantityUnit findById(long id) throws SQLException, ConnectException, DAOException;
	QuantityUnit findByArticleId(long id) throws ConnectException, DAOException, SQLException;
}
