package Mproduct.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.ProductDAO;
import vo.Stock;

public class StockAddService {

	public boolean addStock(Stock stock) {
		// TODO Auto-generated method stub
		ProductDAO productDAO = ProductDAO.getInstance();
		Connection con = getConnection();
		productDAO.setConnection(con);
		boolean stockAddSuccess = false;
		int insertCount = productDAO.insertStock(stock);
		if(insertCount>0) {
			commit(con);
			stockAddSuccess = true;
		}else {
			rollback(con);
		}
		close(con);
		return stockAddSuccess;
	}
}