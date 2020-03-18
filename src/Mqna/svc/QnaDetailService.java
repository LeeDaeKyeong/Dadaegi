package Mqna.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.QnaDAO;
import vo.Question;

public class QnaDetailService {

//	public ArrayList<Question> getqnaDetailList(int question_index) {
//		// TODO Auto-generated method stub
//		ArrayList<Question> qnaDetailList = null;
//		Connection con = getConnection();
//		QnaDAO qnaDAO = QnaDAO.getInstance();
//		qnaDAO.setConnection(con);
//		qnaDetailList = qnaDAO.selectQnaDetailList(question_index);
//		close(con);
//		
//		return qnaDetailList;
//	}

	public Question getQuetion(int question_index) throws Exception {
		// TODO Auto-generated method stub
		Question question = null;
		Connection con = getConnection();
		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.setConnection(con);
		int updateCount = qnaDAO.updateReadCount(question_index);

		if (updateCount > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);
		return question;
	}

	public Question selectQuestion(int question_index) {
		// TODO Auto-generated method stub
		Question question = null;
		Connection con = getConnection();
		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.setConnection(con);
		question = qnaDAO.selectQuestion(question_index);
		close(con);
		return question;
	}

}
