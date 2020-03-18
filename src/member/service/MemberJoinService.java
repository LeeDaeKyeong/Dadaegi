package member.service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.Member;

public class MemberJoinService {

	public boolean joinMember(Member member) {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		int insertCount = memberDAO.insertMember(member);
		
		boolean joinResult = false;
		if(insertCount > 0) {
			commit(con);
			joinResult = true;
		}else {
			rollback(con);
		}
		close(con);
		return joinResult;
	}

}
