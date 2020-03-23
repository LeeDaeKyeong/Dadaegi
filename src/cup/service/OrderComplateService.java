package cup.service;

import java.sql.Connection;

import dao.CupDAO;
import vo.Order_page;
import static db.JdbcUtil.*;

public class OrderComplateService {

	public boolean orderComplatePage(Order_page order_page) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		CupDAO cupDAO = CupDAO.getInstance();
		cupDAO.setConnection(con);
		
		int insertOrder = cupDAO.insertOrderPage(order_page);
		
		boolean orderResult = false;
		if(insertOrder > 0) {
			commit(con);
			orderResult = true;
		}else {
			rollback(con);
		}
		close(con);
		
		return orderResult;
	}

}
