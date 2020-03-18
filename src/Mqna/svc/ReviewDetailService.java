package Mqna.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.QnaDAO;
import vo.Question;
import vo.Review;

public class ReviewDetailService {

//	public ArrayList<Review> getReviewDetailList(int review_index) {
//		// TODO Auto-generated method stub
//		ArrayList<Review> reviewDetailList = null;
//		Connection con = getConnection();
//		QnaDAO qnaDAO = QnaDAO.getInstance();
//		qnaDAO.setConnection(con);
//		reviewDetailList = qnaDAO.selectReviewDetailList(review_index);
//		close(con);
//		
//		return reviewDetailList;
//	}

	public Review getReview(int review_index) {
		// TODO Auto-generated method stub
		Review review = null;
		Connection con = getConnection();
		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.setConnection(con);
		int updateCount = qnaDAO.updateReadCount1(review_index);
		
		if(updateCount > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return review;
	}

	public Review selectReview(int review_index) {
		// TODO Auto-generated method stub
		Review review = null;
		Connection con = getConnection();
		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.setConnection(con);
		review = qnaDAO.selectReview(review_index);
		close(con);
		return review;
	}

}
