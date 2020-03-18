package Mproduct.svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDAO;

import static db.JdbcUtil.*;
import vo.Product;

public class ProductListService {

	public ArrayList<Product> getCupList(int page, int limit, String product_code , String product_name) {
		// TODO Auto-generated method stub
		ArrayList<Product> productList = null;
		ProductDAO productDAO = ProductDAO.getInstance();
		Connection con = getConnection();
		productDAO.setConnection(con);
		productList = productDAO.selectProductList(page, limit, product_code, product_name);
		close(con);
		
		return productList;
	}

	public int getListCount(String product_code , String product_name) {
		// TODO Auto-generated method stub
		int listCount = 0;
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		
		listCount = productDAO.selectCount(product_code,product_name);
		close(con);
		return listCount;
	}

}
