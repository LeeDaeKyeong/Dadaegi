package Mmember.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Mmember.svc.PointDetailSvc;

import action.Action;
import action.ActionForward;
import vo.Coupon;


public class PointDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ActionForward forward = null;
		int order_num = 0;
		int reservation_num = 0;
		int coupon_index = Integer.parseInt(request.getParameter("coupon_index"));
		if (request.getParameter("order_num") != null) {
			order_num = Integer.parseInt(request.getParameter("order_num"));
		}
		if (request.getParameter("reservation_num") != null) {
			reservation_num = Integer.parseInt(request.getParameter("reservation_num"));
		}
		PointDetailSvc pointDetailList = new PointDetailSvc();
		Coupon coupon = pointDetailList.selectPointDetail(coupon_index, order_num, reservation_num);
		session.setAttribute("coupon", coupon);
		// session으로 하기 member.id
		forward = new ActionForward("Mmember/point_detail.jsp", false);
		return forward;
	}

}
