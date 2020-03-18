package Mqna.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mqna.svc.QuestionReplyService;
import action.Action;
import action.ActionForward;
import vo.Question;

public class QuestionReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		String nowPage = request.getParameter("page");
		Question question = new Question();
		question.setQuestion_index(Integer.parseInt(request.getParameter("question_index")));
		question.setQuestion_name(request.getParameter("question_name"));
		question.setProduct_name(request.getParameter("product_name"));
		question.setMember_id(request.getParameter("member_id"));
		question.setQuestion_pass(request.getParameter("question_pass"));
		question.setProduct_code(request.getParameter("product_code"));
		question.setQuestion_subject(request.getParameter("question_subject"));
		question.setQuestion_date(request.getParameter("question_date"));
		question.setQuestion_file(request.getParameter("question_file"));
		question.setQuestion_content(request.getParameter("question_answer"));
		question.setQuestion_re_ref(Integer.parseInt(request.getParameter("question_re_ref")));
		question.setQuestion_re_lev(Integer.parseInt(request.getParameter("question_re_lev")));
		question.setQuestion_re_seq(Integer.parseInt(request.getParameter("question_re_seq")));
		QuestionReplyService questionReplyService = new QuestionReplyService();
		
		boolean isReplySuccess = questionReplyService.replyQuestion(question);
		
		
		if (isReplySuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('답변성공');");
			out.println("window.close();");
			out.println("</script>");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('답변실패');");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
