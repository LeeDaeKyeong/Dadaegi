package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import member.service.MemberJoinService;
import vo.Member;

public class MemberJoinProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
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
				
		MemberJoinService memberJoinService = new MemberJoinService();
		boolean joinResult = memberJoinService.joinMember(member);
		ActionForward forward = null;
		
		if(!joinResult) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원 가입에 오류가 발생했습니다. 다시 작성하세요.')");
			out.println("history.back();");
			out.println("</script>");
		}else {
			forward = new ActionForward();
			forward.setPath("loginForm.log");
		}
		return forward;
	}

}
