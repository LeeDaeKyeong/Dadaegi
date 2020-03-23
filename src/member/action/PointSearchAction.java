package member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import member.service.LoginService;
import member.service.PointSearchService;
import vo.Coupon;
import vo.Member;

public class PointSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		
		
		String start_date = "";
		String end_date = "";
		String member_id = request.getParameter("member_id");
		if(request.getParameter("start_date")!=null) {
			start_date = request.getParameter("start_date");
		}
		if(request.getParameter("end_date")!=null) {
			end_date = request.getParameter("end_date");
		}
		
		PointSearchService pointSearchService = new PointSearchService();
		ArrayList<Coupon> pointSearch = pointSearchService.getTotalSaleList(start_date, end_date, member_id);
		
		LoginService pointSearchForm = new LoginService();
		
		Member member = pointSearchForm.memberLogin(member_id);
		
		session.setAttribute("member", member);
		request.setAttribute("pointSearch", pointSearch);
		request.setAttribute("point", "myPoint.jsp");
		forward = new ActionForward("member/memberPoint.jsp",false);
		request.setAttribute("pagefile", "member/memberPoint.jsp");
		forward = new ActionForward("template.jsp",false);
		
		return forward;
	}

}
