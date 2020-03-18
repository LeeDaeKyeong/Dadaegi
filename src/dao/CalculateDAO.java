package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.Total_view;

public class CalculateDAO {

	DataSource ds;
	Connection con;
	private static CalculateDAO calculateDAO;
	
	public static CalculateDAO getInstance() {
		// TODO Auto-generated method stub
		if (calculateDAO == null) {
			calculateDAO = new CalculateDAO();
		}
		return calculateDAO;
	}

	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;
	}

	public ArrayList<Total_view> selectTotalSaleList(String way, String start_date, String end_date) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Total_view> totalsaleList = new ArrayList<Total_view>();
		Total_view total_view = null;
		
		String sql = "SELECT * FROM total_view WHERE DATE(order_date) BETWEEN ? AND ? ORDER BY order_date DESC;";
//		if(way.equals("payment_way")) {
//			sql+= " payment_way=? ";
//		}else if(way.equals("year")) {
//			sql+= " order_date=? ";
//		}else if(way.equals("month")) {
//			sql+= "";
//		}else if(way.equals("day")) {
//			sql+= "";
//		}
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, start_date);
			pstmt.setString(2, end_date);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				total_view = new Total_view();
				total_view.setOrder_date(rs.getString("order_date"));
				total_view.setPayment_way(rs.getString("payment_way"));
				total_view.setTotal_price(rs.getInt("total_price"));
				total_view.setCoupon(rs.getInt("coupon"));
				total_view.setOrder_num(rs.getInt("order_num"));
				totalsaleList.add(total_view);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return totalsaleList;
	}

}
