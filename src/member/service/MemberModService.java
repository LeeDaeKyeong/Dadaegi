package member.service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.Member;

public class MemberModService {

	public boolean modMember(Member member) {
		// TODO Auto-generated method stub
		boolean modResult = false;
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		int modCount = memberDAO.modMember(member);
		if(modCount > 0) {
			commit(con);
			modResult = true;
		}
		else {
			rollback(con);
		}
		
		close(con);
		return modResult;
	}

}
