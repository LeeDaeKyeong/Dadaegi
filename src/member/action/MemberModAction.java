package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import member.service.LoginService;
import vo.Member;

public class MemberModAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		
//		String member_id = (String) session.getAttribute("member_id");
			
		
		
			LoginService memberModForm = new LoginService();
			String member_id = request.getParameter("member_id");
			Member member = memberModForm.memberLogin(member_id);
			//서비스,DAO는 만들어놓은것 있음. loginAction 참고함
			session.setAttribute("member", member);
			request.setAttribute("pagefile", "member/memberModForm.jsp");
			forward = new ActionForward();
		    forward.setPath("template.jsp");
		
		
		return forward;
	}

}
