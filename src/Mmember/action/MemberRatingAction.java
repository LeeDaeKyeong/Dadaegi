package Mmember.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mmember.svc.MemberRatingSvc;
import action.Action;
import action.ActionForward;
import vo.Member;

public class MemberRatingAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		String member_rating = request.getParameter("member_rating");
		MemberRatingSvc memberRatingsvc = new MemberRatingSvc();
		ArrayList<Member> memberRatingList = memberRatingsvc.getMemberRatingList(member_rating);

		request.setAttribute("memberRatingList", memberRatingList);
		forward = new ActionForward("Mmember/member_rating.jsp", false);
		return forward;
	}

}
