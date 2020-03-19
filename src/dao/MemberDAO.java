package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import dao.MemberDAO;
import vo.Coupon;
import vo.Member;
import vo.Total_view;

public class MemberDAO {

	DataSource ds;
	Connection con;
	private static MemberDAO memberDAO;

	private MemberDAO() {

	}

	public static MemberDAO getInstance() {
		// TODO Auto-generated method stub
		if (memberDAO == null) {
			memberDAO = new MemberDAO();
		}
		return memberDAO;
	}

	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;
	}

	public Member selectMember(String member_id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;

		try {
			pstmt = con.prepareStatement("SELECT * FROM member WHERE member_id=?");
			pstmt.setString(1, member_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setMember_id(rs.getString("member_id"));
				member.setMember_pw(rs.getString("member_pw"));
				member.setMember_name(rs.getString("member_name"));
				member.setMember_phone(rs.getString("member_phone"));
				member.setMember_birth(rs.getString("member_birth"));
				member.setMember_gender(rs.getString("member_gender"));
				member.setMember_email(rs.getString("member_email"));
				member.setMember_zip(rs.getString("member_zip"));
				member.setMember_rating(rs.getString("member_rating"));
				member.setMember_addr(rs.getString("member_addr"));
				member.setMember_addr_detail(rs.getString("member_addr_detail"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return member;
	}

	public int insertMember(Member member) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int insertCount = 0;
		try {
			pstmt = con.prepareStatement(
					"INSERT INTO member(member_id,member_pw,member_name,member_phone,member_birth,member_gender,member_email,member_zip,member_addr,member_addr_detail) VALUES (?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getMember_pw());
			pstmt.setString(3, member.getMember_name());
			pstmt.setString(4, member.getMember_phone());
			pstmt.setString(5, member.getMember_birth());
			pstmt.setString(6, member.getMember_gender());
			pstmt.setString(7, member.getMember_email());
			pstmt.setString(8, member.getMember_zip());
			pstmt.setString(9, member.getMember_addr());
			pstmt.setString(10, member.getMember_addr_detail());

			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}

	public int modMember(Member member) {
		// TODO Auto-generated method stub
		int modCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update member set member_pw=?,member_name=?,member_phone=?,member_birth=?,member_gender=?,member_email=?,member_zip=?,member_addr=?,member_addr_detail=?,member_rating=? where member_id=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(11, member.getMember_id());
			pstmt.setString(1, member.getMember_pw());
			pstmt.setString(2, member.getMember_name());
			pstmt.setString(3, member.getMember_phone());
			pstmt.setString(4, member.getMember_birth());
			pstmt.setString(5, member.getMember_gender());
			pstmt.setString(6, member.getMember_email());
			pstmt.setString(7, member.getMember_zip());
			pstmt.setString(8, member.getMember_addr());
			pstmt.setString(9, member.getMember_addr_detail());
			pstmt.setString(10, member.getMember_rating());

			modCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("boardModify 에러 : " + ex);
		} finally {
			close(pstmt);
		}
		return modCount;
	}

	public int deleteMember(String delete_id) {
		// TODO Auto-generated method stub
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM member WHERE member_id=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, delete_id);

			deleteCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("boardModify 에러 : " + ex);
		} finally {
			close(pstmt);
		}
		return deleteCount;
	}

	public int selectCount(String searchType, String keyword) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		String sql = "select count(*) from member where ";
		if (searchType.equals("member_id")) {
			sql += "member_id like ? ";
		} else if (searchType.equals("member_name")) {
			sql += "member_name like ? ";
		} else if (searchType.equals("member_gender")) {
			sql += "member_gender like ? ";
		} else if (searchType.equals("member_birth")) {
			sql += "member_birth like ? ";
		} else {
			sql += "member_addr like ? ";
		}

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
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

	public ArrayList<Member> selectMemberList(int page, int limit, String searchType, String keyword) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> memberList = null;

		int startrow = (page - 1) * limit;

		String sql = "select * from member where ";
		if (searchType.equals("member_id")) {
			sql += "member_id like ? ";
		} else if (searchType.equals("member_name")) {
			sql += "member_name like ? ";
		} else if (searchType.equals("member_gender")) {
			sql += "member_gender like ? ";
		} else if (searchType.equals("member_birth")) {
			sql += "member_birth like ? ";
		} else {
			sql += "member_addr like ? ";
		}
		sql += " limit ?,?";
		
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, limit);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberList = new ArrayList<Member>();
				do {
					Member member = new Member();
					member.setMember_id(rs.getString("member_id"));
					member.setMember_name(rs.getString("member_name"));
					member.setMember_phone(rs.getString("member_phone"));
					member.setMember_gender(rs.getString("member_gender"));
					member.setMember_email(rs.getString("member_email"));
					member.setMember_rating(rs.getString("member_rating"));
					member.setMember_addr(rs.getString("member_addr"));
					member.setMember_birth(rs.getString("member_birth"));
					member.setMember_zip(rs.getString("member_zip"));
					member.setMember_addr_detail(rs.getString("member_addr_detail"));
					memberList.add(member);
				} while (rs.next());
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return memberList;
	}

	public int selectCount() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		String sql = "select count(*) from member";

		try {
			pstmt = con.prepareStatement(sql);
			
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

	public ArrayList<Member> selectMemberList(int page, int limit) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> memberList = null;

		int startrow = (page - 1) * limit;

		String sql = "select * from member limit ?,?";
		
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, limit);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberList = new ArrayList<Member>();
				do {
					Member member = new Member();
					member.setMember_id(rs.getString("member_id"));
					member.setMember_name(rs.getString("member_name"));
					member.setMember_phone(rs.getString("member_phone"));
					member.setMember_gender(rs.getString("member_gender"));
					member.setMember_email(rs.getString("member_email"));
					member.setMember_rating(rs.getString("member_rating"));
					member.setMember_addr(rs.getString("member_addr"));
					member.setMember_birth(rs.getString("member_birth"));
					member.setMember_zip(rs.getString("member_zip"));
					member.setMember_addr_detail(rs.getString("member_addr_detail"));
					memberList.add(member);
				} while (rs.next());
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return memberList;
	}

	public ArrayList<Coupon> selectmemberPointList(String searchType, String keyword, String start_date,
			String end_date) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Coupon> memberPointList = new ArrayList<Coupon>();
		Coupon coupon = null;
		
		String sql = "SELECT * FROM coupon c INNER JOIN member m ON c.member_id=m.member_id WHERE DATE(coupon_date) BETWEEN ? AND ? ORDER BY coupon_date DESC;";
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
				coupon = new Coupon();
				coupon.setCoupon_date(rs.getString("coupon_date"));
				coupon.setCoupon_content(rs.getString("coupon_content"));
				coupon.setCoupon_price(rs.getInt("coupon_price"));
				coupon.setMember_id(rs.getString("member_id"));
				coupon.setMember_name(rs.getString("member_name"));
				coupon.setOrder_num(rs.getInt("order_num"));
				coupon.setReservation_num(rs.getInt("reservation_num"));
				memberPointList.add(coupon);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return memberPointList;
	}

	public int selectPointCount(String searchType, String keyword) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		String sql = "select count(*) from member where ";
		if (searchType.equals("member_id")) {
			sql += "member_id like ? ";
		} else if (searchType.equals("member_name")) {
			sql += "member_name like ? ";
		}else {
			sql+="";
		}

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
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

}
