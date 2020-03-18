package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.CupDAO;
import vo.Cup;
import vo.Reservation;

public class CupDAO {
	
	Connection con;
	private static CupDAO boardDAO;
	
	private CupDAO() {

	}

	public static CupDAO getInstance() {
		// TODO Auto-generated method stub
		if (boardDAO == null) {
			boardDAO = new CupDAO();
		}
		return boardDAO;
	}

	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;
	}

	public ArrayList<Cup> selectCupList() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Cup> cupList = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM cup where product_code like 'cake%'");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cupList = new ArrayList<Cup>();

				do {
					cupList.add(new Cup(rs.getInt("cup_index"), rs.getString("product_code"), rs.getString("product_name"),
							rs.getInt("product_price"), rs.getString("product_image"), rs.getString("product_content"),
							rs.getString("product_date"),rs.getString("product_status")));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return cupList;
	}


	public Cup selectCup(int id, int qnt) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Cup cup = null;

		try {
			pstmt = con.prepareStatement("SELECT * FROM order_detail od INNER JOIN cup c ON od.product_code = c.product_code WHERE cup_index=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cup = new Cup(rs.getInt("cup_index"), rs.getString("product_code"), rs.getString("product_name"),
						rs.getInt("product_price"), rs.getString("product_image"), rs.getString("product_content"),
						rs.getString("product_date"),rs.getString("product_status"),rs.getInt("product_quantity"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return cup;
	}

	public int insertReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int insertCount = 0;
		try {
			pstmt=con.prepareStatement("INSERT INTO reservation VALUES (?,?,?,?,?,?,?)");
			pstmt.setInt(1, reservation.getReservation_index());
			pstmt.setInt(2, reservation.getReservation_num());
			pstmt.setString(3, reservation.getMember_id());
			pstmt.setInt(4, reservation.getTotal_price());
			pstmt.setString(5, reservation.getReservation_date());
			pstmt.setString(6, reservation.getPayment_date());
			pstmt.setString(7, reservation.getPayment_way());
			
			insertCount = pstmt.executeUpdate();		
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}

	public ArrayList<Cup> selectDrinkList() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Cup> cupList = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM cup where product_code like 'drink%'");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cupList = new ArrayList<Cup>();

				do {
					cupList.add(new Cup(rs.getInt("cup_index"), rs.getString("product_code"), rs.getString("product_name"),
							rs.getInt("product_price"), rs.getString("product_image"), rs.getString("product_content"),
							rs.getString("product_date"),rs.getString("product_status")));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return cupList;
	}

	public Cup selectCup(int id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Cup cup = null;

		try {
			pstmt = con.prepareStatement("SELECT * FROM cup WHERE cup_index=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cup = new Cup(rs.getInt("cup_index"), rs.getString("product_code"), rs.getString("product_name"),
						rs.getInt("product_price"), rs.getString("product_image"), rs.getString("product_content"),
						rs.getString("product_date"),rs.getString("product_status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return cup;
	}

}
