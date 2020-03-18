package cup.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import cup.service.CupCartListService;
import vo.Cart;


public class CupCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		CupCartListService cupCartListService = new CupCartListService();
		ArrayList<Cart> cartList = cupCartListService.getCartList(request);
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
		request.setAttribute("pagefile", "cupShopping/cupCartList.jsp");
		ActionForward forward = new ActionForward("template.jsp", false);
		
		return forward;
	}

}
