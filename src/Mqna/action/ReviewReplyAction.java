package Mqna.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mqna.svc.QuestionReplyService;
import Mqna.svc.ReviewReplyService;
import action.Action;
import action.ActionForward;
import vo.Question;
import vo.Review;

public class ReviewReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		String nowPage = request.getParameter("page");
		Review review = new Review();
		review.setReview_index(Integer.parseInt(request.getParameter("review_index")));
		review.setReview_name(request.getParameter("review_name"));
		review.setProduct_name(request.getParameter("product_name"));
		review.setMember_id(request.getParameter("member_id"));
		review.setReview_pass(request.getParameter("review_pass"));
		review.setProduct_code(request.getParameter("product_code"));
		review.setReview_subject(request.getParameter("review_subject"));
		review.setReview_date(request.getParameter("review_date"));
		review.setReview_file(request.getParameter("review_file"));
		review.setReview_content(request.getParameter("review_answer"));
		review.setReview_re_ref(Integer.parseInt(request.getParameter("review_re_ref")));
		review.setReview_re_lev(Integer.parseInt(request.getParameter("review_re_lev")));
		review.setReview_re_seq(Integer.parseInt(request.getParameter("review_re_seq")));
		ReviewReplyService reviewReplyService = new ReviewReplyService();
		
		boolean isReplySuccess = reviewReplyService.replyReview(review);
		
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
