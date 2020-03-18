package Mqna.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.QnaDAO;
import vo.Review;

public class ReviewReplyService {

	public boolean replyReview(Review review) {
		// TODO Auto-generated method stub
		boolean isReplySuccess = false;
		boolean isModifySuccess = false;
		int insertCount = 0;
		QnaDAO qnaDAO = QnaDAO.getInstance();
		Connection con = getConnection();
		qnaDAO.setConnection(con);
		int updateCount = qnaDAO.updateReview(review);
		insertCount = qnaDAO.insertReplyReview(review);
		
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
