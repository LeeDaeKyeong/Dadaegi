package Mproduct.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.ProductDAO;


public class ProductDeleteService {

	public boolean deleteProduct(String delete_product_name) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		
		int deleteCount = productDAO.deleteProduct(delete_product_name);
		boolean deleteResult = false;
		if(deleteCount>0) {
			commit(con);
			deleteResult=true;
		}else {
			rollback(con);
		}
		close(con);
		return deleteResult;
	}

}
