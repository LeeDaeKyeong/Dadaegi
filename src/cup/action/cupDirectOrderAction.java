package cup.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;

public class cupDirectOrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		String product_name =request.getParameter("product_name");
//		System.out.println(product_name);
		request.setAttribute("product_name", product_name);
		request.setAttribute("pagefile", "cupShopping/cupDirectOrder.jsp");
		ActionForward forward = new ActionForward("template.jsp", false);
		
		return forward;
	}

}
