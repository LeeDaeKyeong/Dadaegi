package Msale.action;

import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Msale.svc.OrderModService;
import action.Action;
import action.ActionForward;
import vo.Order;

public class OrderModAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;

		String order_status = "order_status";
		int order_num = Integer.parseInt(request.getParameter("order_num").trim());
		String member_id = request.getParameter("member_id");
		if (request.getParameter("order_status") != null) {
			order_status = request.getParameter(order_status);
		}
		Order order = new Order();
		boolean isModifySuccess = false;
		OrderModService ordermodsvc = new OrderModService();
		isModifySuccess = ordermodsvc.orderMod(order_num,order_status);
		
		if(!isModifySuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정에 오류가 발생했습니다. 다시 수정하세요.');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			forward = new ActionForward();
			request.setAttribute("order", order);
			forward.setPath("orderdetail.sa?order_num="+order_num+"&member_id="+member_id);
		}
		return forward;
	}

}
