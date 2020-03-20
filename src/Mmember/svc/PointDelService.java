package Mmember.svc;

import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MemberDAO;

public class PointDelService {

	public boolean DeletePoint(int coupon_index) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		boolean delResult = false;
		
		int deleteCount = memberDAO.deletePoint(coupon_index);
		if(deleteCount > 0) {
			commit(con);
			delResult = true;
		}else {
			rollback(con);
		}
		
		return delResult;
	}

}
