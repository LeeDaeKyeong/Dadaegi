package Mproduct.svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.ProductDAO;
import vo.Product;

public class ProductModProService {

	public boolean productMod(Product product) throws Exception {
		// TODO Auto-generated method stub
		boolean isModifySuccess = false;
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		int modCount = productDAO.modProduct(product);
		
		if(modCount > 0) {
			commit(con);
			isModifySuccess = true;
		}else {
			rollback(con);
		}
		close(con);
		return isModifySuccess;
	}
}