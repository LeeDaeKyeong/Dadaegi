package question.service;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.QuestionDAO;
import vo.QuestionBean;

public class QuestionListService {

	public int getListCount(String sOption, String sValue) {
		// TODO Auto-generated method stub
		int listCount = 0;
		Connection con = getConnection();
		QuestionDAO boardDAO = QuestionDAO.getInstance();
		boardDAO.setConnection(con);
		listCount = boardDAO.selectListCount(sOption, sValue);
		close(con);
		System.out.println(listCount);
		return listCount;
	}

	public ArrayList<QuestionBean> getArticleList(int page, int limit, String sOption, String sValue) {
		// TODO Auto-generated method stub
		
		ArrayList<QuestionBean> articleList = null;
		Connection con = getConnection();
		QuestionDAO boardDAO = QuestionDAO.getInstance();
		boardDAO.setConnection(con);
		articleList = boardDAO.selectArticleList(page, limit, sOption, sValue);
		close(con);
		return articleList;
	}

}
