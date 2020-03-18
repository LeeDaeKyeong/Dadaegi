package Mproduct.svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDAO;
import vo.Stock;
import static db.JdbcUtil.*;


public class StockListSvc {

	public int getListCount() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		
		int listCount = productDAO.selectStockCount();
		close(con);
		return listCount;
	}

	public ArrayList<Stock> getStockList(int page, int limit) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		
		ArrayList<Stock> stockList = productDAO.selectStockList(page, limit);
		close(con);
		return stockList;
	}

}
