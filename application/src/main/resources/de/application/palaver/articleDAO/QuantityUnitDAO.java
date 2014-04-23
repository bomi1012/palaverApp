package de.application.palaver.articleDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import de.application.palaver.article.QuantityUnit;
import de.helper.palaver.db.AbstractDAO;
import de.helper.palaver.db.TablesEnum;
import de.helper.palaver.exceptions.ConnectException;
import de.helper.palaver.exceptions.DAOException;

public class QuantityUnitDAO extends AbstractDAO implements IQuantityUnitDAO {
	private static final long serialVersionUID = 1670364747580780268L;
	private static QuantityUnitDAO m_instance = null;
	private QuantityUnit m_quantityUnit;
	
	private static final String GET_QUANTITY_UNIT_BY_ID = "SELECT * FROM "
			+ TablesEnum.QUANTITY_UNIT.getName() + " WHERE " + FIELD_ID + " = {0}";
	
	private static final String GET_QUANTITY_UNIT_BY_ARTICLE_ID = "SELECT * FROM "
			+ TablesEnum.QUANTITY_UNIT.getName() + " qu JOIN " 
			+ TablesEnum.ARTICLE.getName() + " a ON qu." + FIELD_ID + " = a.mengeneinheit_fk" + 
					" WHERE a." + FIELD_ID + " = {0}";
	

	public QuantityUnitDAO() {
		super();
	}

	public static QuantityUnitDAO getInstance() {
		if (m_instance == null) {
			m_instance = new QuantityUnitDAO();
		}
		return m_instance;
	}

	@Override
	public QuantityUnit findById(long id) throws SQLException, ConnectException, DAOException {
		m_quantityUnit = new QuantityUnit();
		m_resultSet = getManaged(MessageFormat.format(GET_QUANTITY_UNIT_BY_ID, id));
		while (m_resultSet.next()) {
			m_quantityUnit = setQuantityUnit(m_resultSet);
		}
		return m_quantityUnit;
	}
	
	@Override
	public QuantityUnit findByArticleId(long id) throws ConnectException, DAOException, SQLException {
		m_quantityUnit = new QuantityUnit();
		m_resultSet = getManaged(MessageFormat.format(GET_QUANTITY_UNIT_BY_ARTICLE_ID, id));
		while (m_resultSet.next()) {
			m_quantityUnit = setQuantityUnit(m_resultSet);
		}
		return m_quantityUnit;
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

	private QuantityUnit setQuantityUnit(ResultSet resultSet) throws SQLException {
		return new QuantityUnit(
				resultSet.getLong(FIELD_ID),
				resultSet.getString(FIELD_NAME));
	}



	
}
