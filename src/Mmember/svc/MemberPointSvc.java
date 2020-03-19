package Mmember.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import vo.Coupon;
import vo.Member;

public class MemberPointSvc {

	public ArrayList<Coupon> memberPointList(String searchType, String keyword, String start_date, String end_date) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		ArrayList<Coupon> memberPointList = memberDAO.selectmemberPointList(searchType,keyword, start_date, end_date);
		
		close(con);
		return memberPointList;
	}

	public int getListCount(String searchType, String keyword) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDao = MemberDAO.getInstance();
		memberDao.setConnection(con);

		int listCount = memberDao.selectPointCount(searchType, keyword);

		close(con);
		return listCount;
	}

}
