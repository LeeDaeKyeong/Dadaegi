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
import vo.Rating;
import vo.Review;
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

	// 객체를 이용한 회원 리스트
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

	// 회원 정보 추가
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

	// 회원 정보 수정
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

	// 회원 정보 삭제
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

	// 회원 리스트 갯수 - 검색옵션
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

	// 회원 리스트 - 검색옵션
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

	// 회원 리스트 갯수
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

	// 회원 리스트
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

	// 회원 적립금 리스트
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
			while (rs.next()) {
				coupon = new Coupon();
				coupon.setCoupon_index(rs.getInt("coupon_index"));
				coupon.setCoupon_date(rs.getString("coupon_date"));
				coupon.setCoupon_content(rs.getString("coupon_content"));
				coupon.setCoupon_price(rs.getInt("coupon_price"));
				coupon.setMember_id(rs.getString("member_id"));
				coupon.setMember_name(rs.getString("member_name"));
				coupon.setOrder_num(rs.getInt("order_num"));
				coupon.setReservation_num(rs.getInt("reservation_num"));
				memberPointList.add(coupon);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return memberPointList;
	}

	// 회원 적립금 리스트 갯수
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
		} else {
			sql += "";
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

	// 회원 등급 리스트
	public ArrayList<Rating> selectRatingList(int page, int limit) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Rating> ratingList = null;

		int startrow = (page - 1) * limit;

		String sql = "SELECT r.member_rating, rating_payment, rating_discount, rating_content, COUNT(r.member_rating)AS rating_count FROM rating r LEFT JOIN member m ON r.member_rating=m.member_rating GROUP BY r.member_rating limit ?,?";

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, limit);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				ratingList = new ArrayList<Rating>();
				do {
					Rating rating = new Rating();
					rating.setMember_rating(rs.getString("member_rating"));
					rating.setRating_payment(rs.getString("rating_payment"));
					rating.setRating_discount(rs.getString("rating_discount"));
					rating.setRating_content(rs.getString("rating_content"));
					rating.setRating_count(rs.getInt("rating_count"));
					ratingList.add(rating);
				} while (rs.next());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return ratingList;
	}

	// 회원 등급 리스트 갯수
	public int selectRatingCount() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		String sql = "select count(*) from rating";

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

	public ArrayList<Member> selectmemberRatingList(String member_rating) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> memberRatingList = null;

		String sql = "SELECT * from member where member_rating=?";

		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member_rating);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberRatingList = new ArrayList<Member>();
				do {
					Member member = new Member();
					member.setMember_rating(rs.getString("member_rating"));
					member.setMember_name(rs.getString("member_name"));
					member.setMember_id(rs.getString("member_id"));
					memberRatingList.add(member);
				} while (rs.next());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return memberRatingList;
	}

	public int modRating(Rating rating) {
		// TODO Auto-generated method stub
		int modCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update rating set rating_payment=?,rating_discount=?,rating_content=? where member_rating=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rating.getRating_payment());
			pstmt.setString(2, rating.getRating_discount());
			pstmt.setString(3, rating.getRating_content());
			pstmt.setString(4, rating.getMember_rating());

			modCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("boardModify 에러 : " + ex);
		} finally {
			close(pstmt);
		}
		return modCount;
	}

	public Rating selectRatingDetail(String member_rating) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Rating rating = null;
		try {
			pstmt = con.prepareStatement(
					"SELECT * FROM rating where member_rating=?");
			pstmt.setString(1, member_rating);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				rating = new Rating();
				rating.setMember_rating(rs.getString("member_rating"));
				rating.setRating_payment(rs.getString("rating_payment"));
				rating.setRating_discount(rs.getString("rating_discount"));
				rating.setRating_content(rs.getString("rating_content"));
			}
		} catch (Exception e) {
			System.out.println("getDetail 에러 : " + e);
		} finally {
			if (rs != null)
				close(rs);
			if (pstmt != null)
				close(pstmt);
		}
		return rating;
	}

	public Coupon selectPointDetail(int coupon_index, int order_num, int reservation_num) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Coupon coupon = null;

		String sql = "select * from coupon c inner join ";
		if (order_num==0) {
			sql += "reservation r on c.reservation_num=r.reservation_num ";
		} else {
			sql += "order_page o on c.order_num=o.order_num ";
		}
		sql+="WHERE coupon_index=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, coupon_index);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				coupon = new Coupon();
				coupon.setCoupon_index(rs.getInt("coupon_index"));
				coupon.setCoupon_date(rs.getString("coupon_date"));
				coupon.setCoupon_price(rs.getInt("coupon_price"));
				coupon.setMember_id(rs.getString("member_id"));
				coupon.setOrder_num(rs.getInt("order_num"));
				coupon.setReservation_num(rs.getInt("reservation_num"));
				coupon.setTotal_price(rs.getInt("total_price"));
			}
		} catch (Exception e) {
			System.out.println("getDetail 에러 : " + e);
		} finally {
			if (rs != null)
				close(rs);
			if (pstmt != null)
				close(pstmt);
		}
		return coupon;
	}

	public int deletePoint(int coupon_index) {
		// TODO Auto-generated method stub
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM coupon WHERE coupon_index=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, coupon_index);

			deleteCount = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("boardModify 에러 : " + ex);
		} finally {
			close(pstmt);
		}
		return deleteCount;
	}

}
