package Mmember.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import vo.Member;
import vo.Rating;

public class MemberRatingListSvc {

	public int getListCount() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDao = MemberDAO.getInstance();
		memberDao.setConnection(con);

		int listCount = memberDao.selectRatingCount();

		close(con);
		return listCount;
	}

	public ArrayList<Rating> getRatingList(int page, int limit) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDao = MemberDAO.getInstance();
		memberDao.setConnection(con);

		ArrayList<Rating> ratingList = memberDao.selectRatingList(page, limit);

		close(con);
		return ratingList;
	}
}
