package Mmember.svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.MemberDAO;
import vo.Rating;

public class RatingDetailSvc {

	public Rating selectRatingDetail(String member_rating) {
		// TODO Auto-generated method stub
		Rating rating = null;
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		rating = memberDAO.selectRatingDetail(member_rating);
		close(con);
		return rating;
	}

}
