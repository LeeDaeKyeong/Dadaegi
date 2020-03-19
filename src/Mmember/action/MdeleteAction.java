package Mmember.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import member.service.MemberDelService;

public class MdeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		ActionForward forward = null;

		String delete_id = request.getParameter("member_id");
		request.setAttribute("member_id", delete_id);
		MemberDelService memberDelsvc = new MemberDelService();
		boolean result = memberDelsvc.DeleteMember(delete_id);

		if (!result) {
			out.println("<script>");
			out.println("alert('회원정보 삭제에 오류가 발생했습니다.다시 시도하세요.')");
			out.println("history.back();");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('" + delete_id + "님의 회원정보 삭제가 완료되었습니다.')");
			session.invalidate();
			out.println("location.href='memberList.mem'");
			out.println("</script>");
		}

		return forward;
	}

}
