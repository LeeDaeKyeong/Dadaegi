package Mmember.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mmember.svc.RatingModService;
import action.Action;
import action.ActionForward;
import vo.Rating;

public class RatingModAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = null;

		Rating rating = new Rating();

		rating.setMember_rating(request.getParameter("member_rating"));
		rating.setRating_content(request.getParameter("rating_content"));
		rating.setRating_discount(request.getParameter("rating_discount"));
		rating.setRating_payment(request.getParameter("rating_payment"));

		boolean isModifySuccess = false;
		RatingModService ratingmodsvc = new RatingModService();
		isModifySuccess = ratingmodsvc.modRating(rating);

		if (!isModifySuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정에 오류가 발생했습니다. 다시 작성하세요.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정완료!');");
			out.println("window.close();");
			out.println("</script>");
		}
		return forward;
	}

}
