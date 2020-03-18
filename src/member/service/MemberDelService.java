package member.service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class MemberDelService {

	public boolean DeleteMember(String delete_id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		boolean delResult = false;
		
		int deleteCount = memberDAO.deleteMember(delete_id);
		if(deleteCount > 0) {
			commit(con);
			delResult = true;
		}else {
			rollback(con);
		}
		
		return delResult;
	}

}
