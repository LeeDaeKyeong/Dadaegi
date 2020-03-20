package Mmember.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Mmember.svc.PointDelService;
import action.Action;
import action.ActionForward;

public class PointDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		ActionForward forward = null;
		
		int coupon_index = Integer.parseInt(request.getParameter("coupon_index"));
		request.setAttribute("coupon_index", coupon_index);
		String member_id = request.getParameter("member_id");
		
		PointDelService pointDelsvc = new PointDelService();
		boolean result = pointDelsvc.DeletePoint(coupon_index);
		
		if (!result) {
			out.println("<script>");
			out.println("alert('탈퇴에 오류가 발생했습니다.다시 시도하세요.')");
			out.println("history.back();");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('" + member_id + "님의 적립금이 삭제되었습니다.')");
			out.println("location.href='memberPoint.mem'");
			out.println("</script>");
		}
		
		return forward;
	}

}
