package question.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import question.service.QuestionViewService;
import vo.QuestionBean;

public class QuestionViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int question_index = Integer.parseInt(request.getParameter("question_index"));
		String page = request.getParameter("page");
		
		QuestionViewService questionViewService = new QuestionViewService();
		QuestionBean article = questionViewService.getArticle(question_index);
		ActionForward forward = new ActionForward();
		request.setAttribute("page", page);
		request.setAttribute("article", article);
		request.setAttribute("pagefile", "question/questionView.jsp");
		forward.setPath("template.jsp");
		return forward;
	}

}
