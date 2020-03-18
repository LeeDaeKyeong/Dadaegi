package Mqna.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.QnaDAO;
import vo.Question;

public class QnaListSvc {

	public int getListCount() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		QnaDAO qnaDao = QnaDAO.getInstance();
		qnaDao.setConnection(con);

		int listCount = qnaDao.selectQnaCount();
		close(con);
		return listCount;
	}

	public ArrayList<Question> getQnaList(int page, int limit) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		QnaDAO qnaDao = QnaDAO.getInstance();
		qnaDao.setConnection(con);

		ArrayList<Question> qnaList = qnaDao.selectQnaList(page, limit);
		close(con);
		return qnaList;
	}

}
