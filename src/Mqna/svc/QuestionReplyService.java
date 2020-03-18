package Mqna.svc;

import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.QnaDAO;
import vo.Question;

public class QuestionReplyService {

	public boolean replyQuestion(Question question) {
		// TODO Auto-generated method stub
		boolean isReplySuccess = false;
		boolean isModifySuccess = false;
		int insertCount = 0;
		Connection con = getConnection();
		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.setConnection(con);
		int updateCount = qnaDAO.updateQuestion(question);
		insertCount = qnaDAO.insertReplyQuestion(question);
		
		if(insertCount>0) {
			if(updateCount>0) {
				commit(con);
				isModifySuccess = true;
				isReplySuccess = true;
			}
		}else {
			rollback(con);
		}
		close(con);
		return isReplySuccess;
	}
}
