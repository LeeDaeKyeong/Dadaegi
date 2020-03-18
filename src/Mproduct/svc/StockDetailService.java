package Mproduct.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDAO;
import vo.Stock;

public class StockDetailService {

	public int getListCount() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		
		int listCount = productDAO.selectStockCount();
		close(con);
		return listCount;
	}

	public ArrayList<Stock> getinstockDetailList(String product_code, int inpage, int inlimit) {
		// TODO Auto-generated method stub
		ArrayList<Stock> instockDetailList = null;
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		instockDetailList = productDAO.selectinStockDetailList(product_code, inpage, inlimit);
		close(con);
		
		return instockDetailList;
	}

	public ArrayList<Stock> getoutstockDetailList(String product_code, int outpage, int outlimit) {
		// TODO Auto-generated method stub
		ArrayList<Stock> outstockDetailList = null;
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		outstockDetailList = productDAO.selectoutStockDetailList(product_code, outpage, outlimit);
		close(con);
		
		return outstockDetailList;
	}

	public ArrayList<Stock> getstockDetailList(String product_code) {
		// TODO Auto-generated method stub
		ArrayList<Stock> stockDetailList = null;
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		stockDetailList = productDAO.selectStockDetailList(product_code);
		close(con);
		
		return stockDetailList;
	}

	public int getinListCount() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		
		int inlistCount = productDAO.selectinStockCount();
		close(con);
		return inlistCount;
	}

	public int getoutListCount() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		
		int outlistCount = productDAO.selectoutStockCount();
		close(con);
		return outlistCount;
	}

}
