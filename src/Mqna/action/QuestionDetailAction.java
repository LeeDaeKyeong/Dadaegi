package Mqna.action;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mqna.svc.QnaDetailService;

import action.Action;
import action.ActionForward;
import vo.Question;


public class QuestionDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
//		ArrayList<Question> qnaDetailList = new ArrayList<Question>();
		int question_index = Integer.parseInt(request.getParameter("question_index").trim());
		String nowPage = request.getParameter("page");
		QnaDetailService qnaDetailService = new QnaDetailService();
		Question question = qnaDetailService.getQuetion(question_index);
		question = qnaDetailService.selectQuestion(question_index);
		request.setAttribute("question", question);
		request.setAttribute("page", nowPage);
//		request.setAttribute("qnaDetailList", qnaDetailList);
		// session으로 하기 member.id
		forward = new ActionForward("Mqna/question.jsp", false);
		return forward;
	}

}
