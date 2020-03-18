package Msale.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.SaleDAO;
import vo.Order;

public class OrderListSvc {

	public int getListCount() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		SaleDAO orderDao = SaleDAO.getInstance();
		orderDao.setConnection(con);

		int listCount = orderDao.selectOrderCount();
		close(con);
		return listCount;
	}

	public ArrayList<Order> getOrderList(int page, int limit) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		SaleDAO orderDao = SaleDAO.getInstance();
		orderDao.setConnection(con);

		ArrayList<Order> orderList = orderDao.selectOrderList(page, limit);
		close(con);
		return orderList;
	}

}
