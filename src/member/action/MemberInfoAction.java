package member.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import member.service.LoginService;
import vo.Member;

public class MemberInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		ActionForward forward = null;
		response.setContentType("text/html;charset=UTF-8");
				
		LoginService memberInfosvc = new LoginService();
		
		String info_id = request.getParameter("member_id");
		Member member = memberInfosvc.memberLogin(info_id);

		//서비스,DAO는 만들어놓은것 있음. loginAction 참고함
		session.setAttribute("member", member);
		request.setAttribute("pagefile", "member/memberInfoForm.jsp");
		forward = new ActionForward();
	    forward.setPath("/template.jsp");
	    
	    return forward;
		
	}
	
}
