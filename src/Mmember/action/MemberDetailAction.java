package Mmember.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import action.Action;
import action.ActionForward;
import member.service.LoginService;
import vo.Member;


public class MemberDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ActionForward forward = null;
		String member_id = request.getParameter("member_id");
		LoginService memberInfosvc = new LoginService();
		Member member = memberInfosvc.memberLogin(member_id);
		session.setAttribute("member", member);
		// session으로 하기 member.id
		forward = new ActionForward("Mmember/member_mod.jsp", false);
		return forward;
	}

}
