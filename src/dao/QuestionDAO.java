package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import dao.QuestionDAO;
import vo.QuestionBean;

public class QuestionDAO {
	
	DataSource ds;
	Connection con;
	private static QuestionDAO boardDAO;

	private QuestionDAO() {

	}

	public static QuestionDAO getInstance() {
		// TODO Auto-generated method stub
		if (boardDAO == null) {
			boardDAO = new QuestionDAO();
		}
		return boardDAO;
	}

	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;
	}

	public ArrayList<QuestionBean> selectArticleList(int page, int limit, String sOption, String sValue) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String question_list_sql = "select * from question where ";
			if(sOption.equals("title")) {
				question_list_sql += " question_subject like ?";
			}else {
				question_list_sql += " question_name like ?";
			}
			question_list_sql += " order by question_re_ref desc, question_re_seq asc limit ?, ?";
		ArrayList<QuestionBean> articleList = new ArrayList<QuestionBean>();
		QuestionBean question = null;
		int startrow = (page - 1) * limit; // 읽기 시작할 row 번호

		try {
			pstmt = con.prepareStatement(question_list_sql);
			pstmt.setString(1, "%" + sValue + "%");
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, limit);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				question = new QuestionBean();
				question.setQuestion_index(rs.getInt("question_index"));
				question.setMember_id(rs.getString("member_id"));
				question.setQuestion_name(rs.getString("question_name"));
				question.setQuestion_pass(rs.getString("question_pass"));
				question.setQuestion_subject(rs.getString("question_subject"));
				question.setQuestion_content(rs.getString("question_content"));
				question.setQuestion_file(rs.getString("question_file"));
				question.setQuestion_re_ref(rs.getInt("question_re_ref"));
				question.setQuestion_re_lev(rs.getInt("question_re_lev"));
				question.setQuestion_re_seq(rs.getInt("question_re_seq"));
				question.setQuestion_readcount(rs.getInt("question_readcount"));
				question.setQuestion_date(rs.getDate("question_date"));
				articleList.add(question);
			}
		} catch (Exception ex) {
			System.out.println("getBoardList 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return articleList;
	}

	//글의 개수
	public int selectListCount(String sOption, String sValue) {
		// TODO Auto-generated method stub
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		String sql="select count(*) from question where ";

		if(sOption.equals("title")) {
			sql += "question_subject like ?";
		}else {
			sql += "question_name like ?";
		}
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + sValue + "%");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception ex) {
			System.out.println("getListCount 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return listCount;
	}

	// 조회수 업데이트
	public int updateReadCount(int question_index) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "update question set question_readcount = " + "question_readcount+1 where question_index = " + question_index;

		try {
			pstmt = con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("setReadCountUpdate 에러 : " + ex);
		} finally {
			close(pstmt);
		}

		return updateCount;
	}

	// 글 내용 보기
	public QuestionBean selectArticle(int question_index) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QuestionBean questionBean = null;

		try {
			pstmt = con.prepareStatement("select * from board where Board_num = ?");
			pstmt.setInt(1, question_index);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				questionBean = new QuestionBean();
				questionBean.setQuestion_index(rs.getInt("question_index"));
				questionBean.setMember_id(rs.getString("member_id"));
				questionBean.setQuestion_name(rs.getString("question_name"));
				questionBean.setQuestion_pass(rs.getString("question_pass"));
				questionBean.setQuestion_subject(rs.getString("question_subject"));
				questionBean.setQuestion_content(rs.getString("question_content"));
				questionBean.setQuestion_file(rs.getString("question_file"));
				questionBean.setQuestion_re_ref(rs.getInt("question_re_ref"));
				questionBean.setQuestion_re_lev(rs.getInt("question_re_lev"));
				questionBean.setQuestion_re_seq(rs.getInt("question_re_seq"));
				questionBean.setQuestion_readcount(rs.getInt("question_readcount"));
				questionBean.setQuestion_date(rs.getDate("question_date"));
			}
		} catch (Exception ex) {
			System.out.println("getDetail 에러 : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}

		return questionBean;
	}

}
