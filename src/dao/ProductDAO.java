package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Order;
import vo.Product;
import vo.Stock;

public class ProductDAO {

	Connection con;
	private static ProductDAO productDAO;

	private ProductDAO() {

	}

	public static ProductDAO getInstance() {
		// TODO Auto-generated method stub
		if (productDAO == null) {
			productDAO = new ProductDAO();
		}
		return productDAO;
	}

	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;
	}

	public ArrayList<Product> selectProductList(int page, int limit, String product_code, String product_name) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Product> productList = new ArrayList<Product>();
		Product product = null;
		int startrow = (page - 1) * limit;
		String sql = "select * from cup where ";
		if (product_code.equals("cake")) {
			sql += " product_code like 'cake%' and ";
		} else if (product_code.equals("drink")) {
			sql += " product_code like 'drink%' and ";
		}
		sql += " product_name like ? limit ?,?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + product_name + "%");
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, limit);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				product = new Product();
				product.setCup_index(rs.getInt("cup_index"));
				product.setProduct_code(rs.getString("product_code"));
				product.setProduct_name(rs.getString("product_name"));
				product.setProduct_price(rs.getInt("product_price"));
				product.setProduct_image(rs.getString("product_image"));
				product.setProduct_content(rs.getString("product_content"));
				product.setProduct_date(rs.getString("product_date"));
				product.setProduct_status(rs.getString("product_status"));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return productList;
	}

	public int selectCount(String product_code, String product_name) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		String sql = "select count(*) from cup where ";

		if (product_code.equals("cake")) {
			sql += "product_code like 'cake%' and ";
		} else if (product_code.equals("drink")) {
			sql += "product_code like 'drink%' and ";
		}
		sql += " product_name like ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + product_name + "%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return count;
	}

	public Product selectProduct(String product_name) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;

		try {
			pstmt = con.prepareStatement("SELECT * FROM cup WHERE product_name like ?");
			pstmt.setString(1, product_name + "%");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				product = new Product(rs.getInt("cup_index"), rs.getString("product_code"),
						rs.getString("product_name"), rs.getInt("product_price"), rs.getString("product_image"),
						rs.getString("product_content"), rs.getString("product_date"), rs.getString("product_status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return product;
	}

	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";

		try {
			sql = "INSERT INTO cup (product_code, product_name, product_price, product_image, product_content, product_date, product_status) VALUES (?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getProduct_code());
			pstmt.setString(2, product.getProduct_name());
			pstmt.setInt(3, product.getProduct_price());
			pstmt.setString(4, product.getProduct_image());
			pstmt.setString(5, product.getProduct_content());
			pstmt.setString(6, product.getProduct_date());
			pstmt.setString(7, product.getProduct_status());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}

	public int modProduct(Product product) {
		// TODO Auto-generated method stub
		int modCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update cup set product_code=?, product_price=?, product_content=?, product_date=?, product_status=? where product_name=?";
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, product.getProduct_code());
			pstmt.setInt(2, product.getProduct_price());
//			pstmt.setString(4, product.getProduct_image());
			pstmt.setString(3, product.getProduct_content());
			pstmt.setString(4, product.getProduct_date());
			pstmt.setString(5, product.getProduct_status());
			pstmt.setString(6, product.getProduct_name());
			modCount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("dao" + modCount);
		return modCount;
	}

	public int deleteProduct(String delete_product_name) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String product_delete_sql = "delete from cup where product_name like ?";
		int deleteCount = 0;
		try {
			pstmt = con.prepareStatement(product_delete_sql);
			pstmt.setString(1, delete_product_name + "%");
			deleteCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
	}

	public int selectStockCount() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int listCount = 0;
		String sql = "select count(*) from stock";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<Stock> selectStockList(int page, int limit) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Stock> stockList = null;
		String sql = "select c.product_code, product_name, product_image, product_price, sum(inout_quantity) qty, stock_status from cup c left join stock s on c.product_code=s.product_code group by c.product_code, stock_status order by c.product_code, stock_status limit ?,?";
		int startrow = (page - 1) * limit;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, limit);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				stockList = new ArrayList<Stock>();
				do {
					Stock stock = new Stock();
					stock.setProduct_code(rs.getString("product_code"));
					//stock.setStock_index(rs.getInt("stock_index"));
//					stock.setInout_date(rs.getInt("inout_date"));
					stock.setInout_quantity(rs.getInt("qty"));
					stock.setStock_status(rs.getString("stock_status"));
					stock.setProduct_name(rs.getString("product_name"));
					stock.setProduct_image(rs.getString("product_image"));
					stock.setProduct_price(rs.getInt("product_price"));
					stockList.add(stock);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return stockList;
	}

	public ArrayList<Stock> selectStockDetailList(String product_code) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Stock> stockDetailList = null;
		String sql = "SELECT c.product_code, product_name, product_image, product_price, s.inout_date, s.inout_quantity, s.stock_status FROM cup c LEFT JOIN stock s ON c.product_code = s.product_code where s.product_code = ? order by s.inout_date desc";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product_code);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stockDetailList = new ArrayList<Stock>();
				do {
					Stock stock = new Stock();
					stock.setProduct_code(rs.getString("product_code"));
					stock.setProduct_image(rs.getString("product_image"));
					stock.setProduct_name(rs.getString("product_name"));
					stock.setProduct_price(rs.getInt("product_price"));
					stock.setInout_date(rs.getString("inout_date"));
					stock.setInout_quantity(rs.getInt("inout_quantity"));
					stock.setStock_status(rs.getString("stock_status"));
					stockDetailList.add(stock);
					
				} while (rs.next());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return stockDetailList;
	}

	public int insertStock(Stock stock) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";

		try {
			sql = "INSERT INTO stock (product_code, inout_date, inout_quantity, stock_status) VALUES (?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stock.getProduct_code());
			pstmt.setString(2, stock.getInout_date());
			pstmt.setInt(3, stock.getInout_quantity());
			pstmt.setString(4, stock.getStock_status());
			
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}

	public ArrayList<Stock> selectinStockDetailList(String product_code, int inpage, int inlimit) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Stock> instockDetailList = null;
		int instartrow = (inpage - 1) * inlimit;
		String sql = "SELECT c.product_code, product_name, product_image, product_price, s.inout_date, s.inout_quantity, s.stock_status FROM cup c LEFT JOIN stock s ON c.product_code = s.product_code where s.product_code = ? and stock_status='in' order by s.inout_date desc limit ?,?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product_code);
			pstmt.setInt(2, instartrow);
			pstmt.setInt(3, inlimit);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				instockDetailList = new ArrayList<Stock>();
				do {
					Stock stock = new Stock();
					stock.setProduct_code(rs.getString("product_code"));
					stock.setProduct_image(rs.getString("product_image"));
					stock.setProduct_name(rs.getString("product_name"));
					stock.setProduct_price(rs.getInt("product_price"));
					stock.setInout_date(rs.getString("inout_date"));
					stock.setInout_quantity(rs.getInt("inout_quantity"));
					stock.setStock_status(rs.getString("stock_status"));
					instockDetailList.add(stock);
					
				} while (rs.next());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return instockDetailList;
	}

	public ArrayList<Stock> selectoutStockDetailList(String product_code, int outpage, int outlimit) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Stock> outstockDetailList = null;
		int outstartrow = (outpage - 1) * outlimit;
		String sql = "SELECT c.product_code, product_name, product_image, product_price, s.inout_date, s.inout_quantity, s.stock_status FROM cup c LEFT JOIN stock s ON c.product_code = s.product_code where s.product_code = ? and stock_status='out' order by s.inout_date desc limit ?,?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product_code);
			pstmt.setInt(2, outstartrow);
			pstmt.setInt(3, outlimit);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				outstockDetailList = new ArrayList<Stock>();
				do {
					Stock stock = new Stock();
					stock.setProduct_code(rs.getString("product_code"));
					stock.setProduct_image(rs.getString("product_image"));
					stock.setProduct_name(rs.getString("product_name"));
					stock.setProduct_price(rs.getInt("product_price"));
					stock.setInout_date(rs.getString("inout_date"));
					stock.setInout_quantity(rs.getInt("inout_quantity"));
					stock.setStock_status(rs.getString("stock_status"));
					outstockDetailList.add(stock);
					
				} while (rs.next());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return outstockDetailList;
	}

	public int selectinStockCount() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int inlistCount = 0;
		String sql = "select count(*) from stock where stock_status='in'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				inlistCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return inlistCount;
	}

	public int selectoutStockCount() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int outlistCount = 0;
		String sql = "select count(*) from stock where stock_status='out'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				outlistCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return outlistCount;
	}
}
