package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import member.service.LoginService;
import vo.Member;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String member_id = request.getParameter("member_id");
		String member_pw = request.getParameter("member_pw");
		ActionForward forward = null;
		Member member = null;
		
		LoginService loginService = new LoginService();
		
		member = loginService.memberLogin(member_id);
		
		if(member==null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디가 존재하지 않습니다.')");
			out.println("history.back();");
			out.println("</script>");
		}else {	
			if(!member_pw.equals(member.getMember_pw())) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('비밀번호가 일치하지 않습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				request.setAttribute("pagefile", "main.jsp");
				forward = new ActionForward("template.jsp", false);
//				forward = new ActionForward();
//				forward.setPath("template.jsp");
//				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}
