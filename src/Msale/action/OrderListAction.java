package Msale.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Msale.svc.OrderListSvc;
import action.Action;
import action.ActionForward;
import vo.Order;
import vo.PageInfo;


public class OrderListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		OrderListSvc orderListsvc = new OrderListSvc();
		int listCount = orderListsvc.getListCount();
		int page = 1, limit = 10, limitPage = 3;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		ArrayList<Order> orderList = orderListsvc.getOrderList(page, limit);

		int maxPage = (int) ((double) listCount / limit + 0.95);
		// 0.95를 더해서 올림 처리
		// 현재 페이지에 보여줄 시작 페이지 수(1,11,21 등...)
		int startPage = (((int) ((double) page / limitPage + 0.9)) - 1) * limitPage + 1;
		// 현재 페이지에 보여줄 마지막 페이지 수(10,20,30 등...)
		int endPage = startPage + limitPage - 1;

		if (endPage > maxPage) {
			endPage = maxPage;
		}
		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("orderList", orderList);
		request.setAttribute("pagefile", "/Msale/order.jsp");
		forward = new ActionForward("Mtemplate.jsp", false);
		return forward;
	}

}
