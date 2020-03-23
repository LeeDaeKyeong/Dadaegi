package cup.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import cup.service.OrderComplateService;
import vo.Order_page;

public class OrderComplateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Order_page order_page = new Order_page();
		
		String member_id = (String) session.getAttribute("member_id");
		order_page.setMember_id(request.getParameter("member_id"));
		order_page.setTotal_price(Integer.parseInt(request.getParameter("total_price")));
		order_page.setOrder_status(request.getParameter("order_status"));
		order_page.setOrder_date(request.getParameter("order_date"));
		order_page.setPayment_way(request.getParameter("payment_way"));
		order_page.setPayment_date(request.getParameter("payment_date"));
		order_page.setOrder_way(request.getParameter("order_way"));
		order_page.setCoupon(Integer.parseInt(request.getParameter("coupon")));
		order_page.setDemand(request.getParameter("demand"));
		order_page.setPayment_status(request.getParameter("payment_status"));
		
		OrderComplateService orderComplateService = new OrderComplateService();
		boolean orderResult = orderComplateService.orderComplatePage(order_page);
		ActionForward forward = null;
		
		if(!orderResult) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('주문과정에 오류가 발생했습니다. 다시 주문하세요.')");
			out.println("history.back();");
			out.println("</script>");
		}else {
			forward = new ActionForward();
			forward.setPath("orderComplate.jsp?member_id=" + order_page.getMember_id());
		}
		return forward;
	}

}
