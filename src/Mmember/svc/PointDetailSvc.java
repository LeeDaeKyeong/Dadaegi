package Mmember.svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.MemberDAO;
import vo.Coupon;

public class PointDetailSvc {

	public Coupon selectPointDetail(int coupon_index, int order_num, int reservation_num) {
		// TODO Auto-generated method stub
		Coupon coupon = null;
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		coupon = memberDAO.selectPointDetail(coupon_index, order_num, reservation_num);
		close(con);
		return coupon;
	}

}
