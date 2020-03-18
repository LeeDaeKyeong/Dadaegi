package Mqna.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.QnaDAO;
import vo.Review;

public class ReviewListSvc {

	public int getListCount() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		QnaDAO qnaDao = QnaDAO.getInstance();
		qnaDao.setConnection(con);

		int listCount = qnaDao.selectReviewCount();
		close(con);
		return listCount;
	}

	public ArrayList<Review> getReviewList(int page, int limit) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		QnaDAO qnaDao = QnaDAO.getInstance();
		qnaDao.setConnection(con);

		ArrayList<Review> reviewList = qnaDao.selectReviewList(page, limit);
		close(con);
		return reviewList;
	}

}
