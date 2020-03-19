package Mmember.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import vo.Member;

public class MemberListSvc {

	public int getListCount(String searchType, String keyword) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDao = MemberDAO.getInstance();
		memberDao.setConnection(con);

		int listCount = memberDao.selectCount(searchType, keyword);

		close(con);
		return listCount;
	}

	public ArrayList<Member> getMemberList(int page, int limit, String searchType, String keyword) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDao = MemberDAO.getInstance();
		memberDao.setConnection(con);

		ArrayList<Member> memberList = memberDao.selectMemberList(page, limit, searchType, keyword);

		close(con);
		return memberList;
	}

	public int getListCount() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDao = MemberDAO.getInstance();
		memberDao.setConnection(con);

		int listCount = memberDao.selectCount();

		close(con);
		return listCount;
	}

	public ArrayList<Member> getMemberList(int page, int limit) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDao = MemberDAO.getInstance();
		memberDao.setConnection(con);

		ArrayList<Member> memberList = memberDao.selectMemberList(page, limit);

		close(con);
		return memberList;
	}

}
