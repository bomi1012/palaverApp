package de.application.palaver.articleService;

import java.util.List;

import de.application.palaver.article.Article;
import de.application.palaver.articleDAO.ArticleDAO;


public class ArticleService implements IArticleService{
	private static ArticleService m_instance = null;
	public ArticleService() { }
	
	public static ArticleService getInstance() {
        if (m_instance == null) {
            m_instance = new ArticleService();
        }
        return m_instance;
    }

	@Override
	public List<Article> findFoods() {
		try {
			return ArticleDAO.getInstance().findAllFoods(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; 
	}


}
