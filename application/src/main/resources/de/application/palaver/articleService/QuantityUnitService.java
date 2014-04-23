package de.application.palaver.articleService;

import de.application.palaver.article.QuantityUnit;
import de.application.palaver.articleDAO.QuantityUnitDAO;



public class QuantityUnitService {
	private static QuantityUnitService m_instance = null;
	public QuantityUnitService() { }
	
	public static QuantityUnitService getInstance() {
        if (m_instance == null) {
            m_instance = new QuantityUnitService();
        }
        return m_instance;
    }

	public QuantityUnit findByArticleId(long id) {
		try {
			return QuantityUnitDAO.getInstance().findByArticleId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



}
