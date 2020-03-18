package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import dao.MemberDAO;
import vo.Member;

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
			pstmt=con.prepareStatement("SELECT * FROM member WHERE member_id=?");
			pstmt.setString(1, member_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setMember_id(rs.getString("member_id"));
				member.setMember_pw(rs.getString("member_pw"));
				member.setMember_name(rs.getString("member_name"));
				member.setMember_phone(rs.getString("member_phone"));
				member.setMember_birth(rs.getString("member_birth"));
				member.setMember_gender(rs.getString("member_gender"));
				member.setMember_email(rs.getString("member_email"));
				member.setMember_zip(rs.getString("member_zip"));
				member.setMember_addr(rs.getString("member_addr"));
				member.setMember_addr_detail(rs.getString("member_addr_detail"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
			pstmt=con.prepareStatement("INSERT INTO member(member_id,member_pw,member_name,member_phone,member_birth,member_gender,member_email,member_zip,member_addr,member_addr_detail) VALUES (?,?,?,?,?,?,?,?,?,?)");
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
		}catch (Exception e) {
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
		String sql = "update member set member_pw=?,member_name=?,member_phone=?,member_birth=?,member_gender=?,member_email=?,member_zip=?,member_addr=?,member_addr_detail=? where member_id=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(10, member.getMember_id());
			pstmt.setString(1, member.getMember_pw());
			pstmt.setString(2, member.getMember_name());
			pstmt.setString(3, member.getMember_phone());
			pstmt.setString(4, member.getMember_birth());
			pstmt.setString(5, member.getMember_gender());
			pstmt.setString(6, member.getMember_email());
			pstmt.setString(7, member.getMember_zip());
			pstmt.setString(8, member.getMember_addr());
			pstmt.setString(9, member.getMember_addr_detail());
			
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

}
