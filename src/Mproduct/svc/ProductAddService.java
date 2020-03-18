package Mproduct.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.ProductDAO;
import vo.Product;

public class ProductAddService {

	public static boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		ProductDAO productDAO = ProductDAO.getInstance();
		Connection con = getConnection();
		productDAO.setConnection(con);
		boolean productAddSuccess = false;
		int insertCount = productDAO.insertProduct(product);
		
		if (insertCount > 0) {
			commit(con);
			productAddSuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		
		return productAddSuccess;
	}

}
