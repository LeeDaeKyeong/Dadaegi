package Msale.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.SaleDAO;

public class OrderPayModService {

	public boolean paymentMod(int order_num, String payment_status) {
		// TODO Auto-generated method stub
		boolean isModifySuccess = false;
		Connection con = getConnection();
		SaleDAO saleDAO = SaleDAO.getInstance();
		saleDAO.setConnection(con);
		int modCount = saleDAO.modPayment(order_num, payment_status);

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
