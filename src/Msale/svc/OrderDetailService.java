package Msale.svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.SaleDAO;
import vo.Order;


import static db.JdbcUtil.*;

public class OrderDetailService {

	public ArrayList<Order> getorderDetailList(int order_num) {
		// TODO Auto-generated method stub
		ArrayList<Order> orderDetailList = null;
		Connection con = getConnection();
		SaleDAO saleDAO = SaleDAO.getInstance();
		saleDAO.setConnection(con);
		orderDetailList = saleDAO.selectOrderDetailList(order_num);
		close(con);
		
		return orderDetailList;
	}
}
