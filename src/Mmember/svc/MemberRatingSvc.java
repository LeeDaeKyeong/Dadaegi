package Mmember.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import vo.Member;

public class MemberRatingSvc {

	public ArrayList<Member> getMemberRatingList(String member_rating) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDao = MemberDAO.getInstance();
		memberDao.setConnection(con);

		ArrayList<Member> memberRatingList = memberDao.selectmemberRatingList(member_rating);
		close(con);
		
		return memberRatingList;
	}

}
