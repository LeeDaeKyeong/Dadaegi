package cup.service;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.CupDAO;
import vo.Cup;

public class CupViewService {

	public Cup getCupView(int id) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		CupDAO cupDAO = CupDAO.getInstance();
		cupDAO.setConnection(con);
		
		Cup cup = cupDAO.selectCup(id);
		System.out.println(id);
		close(con);
		
		return cup;
	}

}
