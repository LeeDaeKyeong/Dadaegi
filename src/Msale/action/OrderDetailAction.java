package Msale.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Msale.svc.OrderDetailService;
import action.Action;
import action.ActionForward;
import member.service.LoginService;
import vo.Member;
import vo.Order;

public class OrderDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ActionForward forward = null;
		ArrayList<Order> orderDetailList = new ArrayList<Order>();
		int order_num = Integer.parseInt(request.getParameter("order_num").trim());
		String member_id = request.getParameter("member_id");
		OrderDetailService orderDetailService = new OrderDetailService();
		orderDetailList = orderDetailService.getorderDetailList(order_num);
		LoginService memberInfosvc = new LoginService();
		Member member = memberInfosvc.memberLogin(member_id);
		session.setAttribute("member", member);
		request.setAttribute("orderDetailList", orderDetailList);
		// session으로 하기 member.id
		forward = new ActionForward("Msale/order_detail.jsp", false);
		return forward;
	}

}
