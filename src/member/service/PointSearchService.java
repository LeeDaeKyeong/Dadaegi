package member.service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import vo.Coupon;

public class PointSearchService {

	

	public ArrayList<Coupon> getTotalSaleList(String start_date, String end_date, String member_id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		ArrayList<Coupon> pointSearch = memberDAO.selectPointSearch(start_date, end_date,member_id);
		
		close(con);
		return pointSearch;
	}

}
