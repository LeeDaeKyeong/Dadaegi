package Mproduct.svc;

import dao.ProductDAO;
import vo.Product;
import static db.JdbcUtil.*;

import java.sql.Connection;

public class ProductViewService {

	public Product getProductView(String product_name) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		Product product = productDAO.selectProduct(product_name);
		close(con);
		return product;
	}
}
