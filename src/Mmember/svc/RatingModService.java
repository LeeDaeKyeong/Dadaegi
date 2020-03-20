package Mmember.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.Rating;

public class RatingModService {

	public boolean modRating(Rating rating) {
		// TODO Auto-generated method stub
		boolean modResult = false;
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);

		int modCount = memberDAO.modRating(rating);
		if (modCount > 0) {
			commit(con);
			modResult = true;
		} else {
			rollback(con);
		}

		close(con);
		return modResult;
	}

}
