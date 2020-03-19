package Mmember.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Msale.svc.OrderModService;
import action.Action;
import action.ActionForward;
import member.service.MemberModService;
import vo.Member;
import vo.Order;

public class MmodAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		HttpSession session = request.getSession();
//		if (session.getAttribute("member_id") == null) {
//			response.setContentType("text/html;charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
//			out.println("alert('로그인을 하세요!!!')");
//			out.println("location.href='loginForm.jsp");
//			out.println("</script>");
//		} else {
			request.setCharacterEncoding("UTF-8");
//			String id = (String) session.getAttribute("userId");
			Member member = new Member();
			
			member.setMember_id(request.getParameter("member_id"));
			member.setMember_pw(request.getParameter("member_pw"));
			member.setMember_name(request.getParameter("member_name"));
			member.setMember_phone(request.getParameter("member_phone"));
			member.setMember_birth(request.getParameter("member_birth"));
			member.setMember_gender(request.getParameter("member_gender"));
			member.setMember_rating(request.getParameter("member_rating"));
			member.setMember_email(request.getParameter("member_email"));
			member.setMember_zip(request.getParameter("member_zip"));
			member.setMember_addr(request.getParameter("member_addr"));
			member.setMember_addr_detail(request.getParameter("member_addr_detail"));
			
			boolean isModifySuccess = false;
			MemberModService membermodsvc = new MemberModService();
			isModifySuccess = membermodsvc.modMember(member);

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
//		}
		return forward;
	}

}
