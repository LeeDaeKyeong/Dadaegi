package question.service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.QuestionDAO;
import vo.QuestionBean;

public class QuestionViewService {

	public QuestionBean getArticle(int question_index) {
		// TODO Auto-generated method stub
		QuestionBean article = null;
		Connection con = getConnection();
		QuestionDAO questionDAO = QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		int updateCount = questionDAO.updateReadCount(question_index);
		
		if(updateCount > 0) {
			commit(con);
		}
		else {
			rollback(con);
		}
		
		article = questionDAO.selectArticle(question_index);
		close(con);
		return article;
	}

}
