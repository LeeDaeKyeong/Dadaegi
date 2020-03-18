package Msale.svc;

import dao.SaleDAO;
import static db.JdbcUtil.*;

import java.sql.Connection;

public class OrderModService {

	public boolean orderMod(int order_num, String order_status) throws Exception {
		// TODO Auto-generated method stub
		boolean isModifySuccess = false;
		Connection con = getConnection();
		SaleDAO saleDAO = SaleDAO.getInstance();
		saleDAO.setConnection(con);
		int modCount = saleDAO.modOrder(order_num, order_status);

		if (modCount > 0) {
			commit(con);
			isModifySuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		return isModifySuccess;
	}

}
