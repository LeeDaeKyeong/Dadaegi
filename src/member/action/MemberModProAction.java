package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import member.service.MemberModService;
import vo.Member;

public class MemberModProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		ActionForward forward = null;
		
//		if (session.getAttribute("member_id") == null) {			
//			out.println("<script>");
//			out.println("alert('로그인을 하세요')");
//			out.println("location.href='loginForm.log'");
//			out.println("</script>");
//		} else {
			String member_id = (String) session.getAttribute("member_id");
			Member member = new Member();
			member.setMember_id(request.getParameter("member_id"));
			member.setMember_pw(request.getParameter("member_pw"));
			member.setMember_name(request.getParameter("member_name"));
			member.setMember_phone(request.getParameter("member_phone"));
			member.setMember_birth(request.getParameter("member_birth"));
			member.setMember_gender(request.getParameter("member_gender"));
			member.setMember_email(request.getParameter("member_email"));
			member.setMember_zip(request.getParameter("member_zip"));
			member.setMember_addr(request.getParameter("member_addr"));
			member.setMember_addr_detail(request.getParameter("member_addr_detail"));
		
			boolean modResult =false;
			MemberModService memberModsvc = new MemberModService();
			modResult = memberModsvc.modMember(member);		
			
			if (!modResult) {
				out.println("<script>");
				out.println("alert('정보 수정에 오류가 발생했습니다.다시 작성하세요.')");
				out.println("location.href='memberInfo.mem?id=" + member_id + "';");
				out.println("</script>");
				
			} else {	
				forward = new ActionForward();
//				forward.setRedirect(true);
			    forward.setPath("memberInfo.mem?id=" + member.getMember_id());
			}
//		}
		
		
		return forward;
	}

}
