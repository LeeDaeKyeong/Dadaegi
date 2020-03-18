package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static db.JdbcUtil.*;
import javax.sql.DataSource;

import vo.Order;
import vo.Reservation;

public class SaleDAO {

	DataSource ds;
	Connection con;
	private static SaleDAO saleDao;

	private SaleDAO() {

	}

	public static SaleDAO getInstance() {
		// TODO Auto-generated method stub
		if (saleDao == null) {
			saleDao = new SaleDAO();
		}
		return saleDao;
	}

	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;
	}

	public int selectCount() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int listCount = 0;
		try {
			pstmt = con.prepareStatement("select count(*) from reservation");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<Reservation> selectReservationList(int page, int limit) {
		// TODO Auto-generated method stub

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Reservation> reservationList = null;
		String sql = "SELECT * FROM reservation a INNER JOIN member b ON a.member_id = b.member_id limit ?,? ";
		int startrow = (page - 1) * limit;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, limit);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				reservationList = new ArrayList<Reservation>();
				do {
					Reservation reservation = new Reservation();
					reservation.setReservation_num(rs.getInt("reservation_num"));
					reservation.setMember_id(rs.getString("member_id"));
					reservation.setMember_name(rs.getString("member_name"));
					reservation.setMember_phone(rs.getString("member_phone"));
					reservation.setMember_email(rs.getString("member_email"));
					reservation.setMember_birth(rs.getString("member_birth"));
					reservation.setMember_gender(rs.getString("member_gender"));
					reservation.setCoupon(rs.getInt("coupon"));
					reservation.setDemand(rs.getString("demand"));
					reservation.setReservation_date(rs.getString("reservation_date"));
					reservation.setPayment_date(rs.getString("payment_date"));
					reservation.setPayment_status(rs.getString("payment_status"));
					reservation.setReservation_status(rs.getString("reservation_status"));
					reservation.setConfirm(rs.getString("confirm"));
					reservationList.add(reservation);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return reservationList;
	}

	public ArrayList<Order> selectOrderList(int page, int limit) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Order> orderList = null;
		String sql = "SELECT * FROM order_page a INNER JOIN member b ON a.member_id = b.member_id limit ?,?";
		int startrow = (page - 1) * limit;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, limit);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				orderList = new ArrayList<Order>();
				do {
					Order order = new Order();
					order.setOrder_date(rs.getString("order_date"));
					order.setOrder_num(rs.getInt("order_num"));
					order.setMember_id(rs.getString("member_id"));
					order.setMember_name(rs.getString("member_name"));
					order.setMember_phone(rs.getString("member_phone"));
					order.setMember_email(rs.getString("member_email"));
					order.setMember_birth(rs.getString("member_birth"));
					order.setMember_gender(rs.getString("member_gender"));
					order.setPayment_status(rs.getString("payment_status"));
					order.setOrder_way(rs.getString("order_way"));
					order.setTotal_price(rs.getInt("total_price"));
					order.setOrder_status(rs.getString("order_status"));
//					order.setConfirm(rs.getString("confirm"));
					orderList.add(order);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return orderList;
	}

	public int selectOrderCount() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int listCount = 0;
		try {
			pstmt = con.prepareStatement("select count(*) from order_page");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<Order> selectOrderDetailList(int order_num) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Order> orderDetailList = null;
		String sql = "SELECT * FROM order_page o INNER JOIN (order_detail od INNER JOIN cup c ON od.product_code = c.product_code) ON o.order_num = od.order_num where o.order_num=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order_num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				orderDetailList = new ArrayList<Order>();
				do {
					Order order = new Order();
					order.setOrder_num(rs.getInt("order_num"));
					order.setMember_id(rs.getString("member_id"));
					order.setTotal_price(rs.getInt("total_price"));
					order.setOrder_status(rs.getString("order_status"));
					order.setOrder_date(rs.getString("order_date"));
					order.setPayment_way(rs.getString("payment_way"));
					order.setPayment_date(rs.getInt("payment_date"));
					order.setOrder_way(rs.getString("order_way"));
					order.setDemand(rs.getString("demand"));
					order.setPayment_status(rs.getString("payment_status"));
					order.setCoupon(rs.getInt("coupon"));
//					order.setConfirm(rs.getString("confirm"));
					order.setProduct_name(rs.getString("product_name"));
					order.setProduct_quantity(rs.getInt("product_quantity"));
					orderDetailList.add(order);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return orderDetailList;
	}

	public ArrayList<Reservation> selectReservationDetailList(int reservation_num) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Reservation> reservationDetailList = null;
		String sql = "SELECT * FROM reservation r INNER JOIN (reservation_detail rd INNER JOIN cup c ON rd.product_code = c.product_code) ON r.reservation_num = rd.reservation_num where r.reservation_num=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reservation_num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				reservationDetailList = new ArrayList<Reservation>();
				do {
					Reservation reservation = new Reservation();
					reservation.setReservation_num(rs.getInt("reservation_num"));
					reservation.setPayment_date(rs.getString("reservation_date"));
					reservation.setProduct_name(rs.getString("product_name"));
					reservation.setReservation_date(rs.getString("reservation_date"));
					reservation.setPayment_status(rs.getString("payment_status"));
					reservation.setReservation_status(rs.getString("reservation_status"));
					reservation.setConfirm(rs.getString("confirm"));
					reservation.setProduct_quantity(rs.getInt("product_quantity"));
					reservation.setTotal_price(rs.getInt("total_price"));
					reservation.setCoupon(rs.getInt("coupon"));
					reservation.setPayment_way(rs.getString("payment_way"));
					reservation.setMember_id(rs.getString("member_id"));
					reservation.setDemand(rs.getString("demand"));

					reservationDetailList.add(reservation);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return reservationDetailList;
	}

	public int modOrder(int order_num, String order_status) {
		// TODO Auto-generated method stub
		int modCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update order_page set order_status=? where order_num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, order_status);
			pstmt.setInt(2,order_num);
			modCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return modCount;
	}

	public int modPayment(int order_num, String payment_status) {
		// TODO Auto-generated method stub
		int modCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update order_page set payment_status=? where order_num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, payment_status);
			pstmt.setInt(2,order_num);
			modCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return modCount;
	}

	public int modReservation(int reservation_num, String reservation_status) {
		// TODO Auto-generated method stub
		int modCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update reservation set reservation_status=? where reservation_num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reservation_status);
			pstmt.setInt(2,reservation_num);
			modCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return modCount;
	}

	public int modReservationPay(int reservation_num, String payment_status) {
		// TODO Auto-generated method stub
		int modCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update reservation set payment_status=? where reservation_num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, payment_status);
			pstmt.setInt(2,reservation_num);
			modCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return modCount;
	}
}