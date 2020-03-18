package member.service;

import vo.Member;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class LoginService {

	public Member memberLogin(String member_id) throws Exception {
		// TODO Auto-generated method stub
		Member member = null;
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		member = memberDAO.selectMember(member_id);
		
		close(con);
		return member;
	}

}
