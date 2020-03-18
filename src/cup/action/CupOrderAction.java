package cup.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import cup.service.CupCartListService;
import cup.service.CupOrderService;
import vo.Cart;

public class CupOrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		HttpSession session = request.getSession();
		
		CupOrderService cupOrdertService = new CupOrderService();
		ArrayList<Cart> cartList = cupOrdertService.getCartList(request);
		// 총금액 계산
		int totalMoney = 0;
		int money = 0;

		if (cartList != null) {
			for (int i = 0; i < cartList.size(); i++) {
				money = cartList.get(i).getProduct_price() * cartList.get(i).getProduct_quantity();
				totalMoney += money;
			}
		}
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		request.setAttribute("pagefile", "cupShopping/cupOrder.jsp");
		forward = new ActionForward("template.jsp", false);
		
		return forward;
	}

}
