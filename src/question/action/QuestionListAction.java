package question.action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import question.service.QuestionListService;
import vo.QuestionBean;
import vo.PageInfo;

public class QuestionListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String sOption = "title";
		  String sValue = "";
		  
		  if(request.getParameter("sOption") != null) {
		  	sOption = request.getParameter("sOption");
		  }
		  if(request.getParameter("sValue") != null) {
		  	sValue = request.getParameter("sValue");
		  }
		  
	      ArrayList<QuestionBean> articleList = new ArrayList<QuestionBean>();
	      int page = 1;
	      int limit = 10; //페이지에 보여줄 목록수
	      int limitPage = 3; //페이지 수

	      if (request.getParameter("page") != null) {
	         page = Integer.parseInt(request.getParameter("page"));
	      }

	      QuestionListService questionListService = new QuestionListService();
	      int listCount = questionListService.getListCount(sOption, sValue);
	      // 총 리스트 수를 받아옴
	      articleList = questionListService.getArticleList(page, limit, sOption, sValue);
	      // 리스트를 받아옴
	      // 총 페이지 수
	      int maxPage = (int) ((double) listCount / limit + 0.95);
	      // 0.95를 더해서 올림 처리
	      // 현재 페이지에 보여줄 시작 페이지 수(1,11,21 등...)
	      int startPage = (((int) ((double) page / limitPage + 0.9)) - 1) * limitPage + 1;
	      // 현재 페이지에 보여줄 마지막 페이지 수(10,20,30 등...)
	      int endPage = startPage + limitPage - 1;

	      if (endPage > maxPage)
	         endPage = maxPage;

	      PageInfo pageInfo = new PageInfo();
	      pageInfo.setEndPage(endPage);
	      pageInfo.setListCount(listCount);
	      pageInfo.setMaxPage(maxPage);
	      pageInfo.setPage(page);
	      pageInfo.setStartPage(startPage);
	      request.setAttribute("pageInfo", pageInfo);
	      request.setAttribute("articleList", articleList);
	      request.setAttribute("sOption", sOption);
	      request.setAttribute("sValue", sValue);
	      request.setAttribute("pagefile", "question/questionList.jsp");
	      ActionForward forward = new ActionForward();
	      forward.setPath("/template.jsp");
	      return forward;
	   }
	}