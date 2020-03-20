package Mmember.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Mmember.svc.MemberRatingListSvc;
import Mmember.svc.RatingDetailSvc;
import action.Action;
import action.ActionForward;
import member.service.LoginService;
import vo.Member;
import vo.Rating;

public class RatingDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ActionForward forward = null;
		String member_rating = request.getParameter("member_rating");
		RatingDetailSvc ratingDetailList = new RatingDetailSvc();
		Rating rating = ratingDetailList.selectRatingDetail(member_rating);
		session.setAttribute("rating", rating);
		// session으로 하기 member.id
		forward = new ActionForward("Mmember/rating_mod.jsp", false);
		return forward;
	}

}
