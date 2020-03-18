package Mproduct.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mproduct.svc.ProductViewService;
import action.Action;
import action.ActionForward;
import vo.Product;

public class ProductViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String product_name = request.getParameter("product_name");
		ProductViewService productViewService = new ProductViewService();
		Product product = productViewService.getProductView(product_name);
		
		request.setAttribute("product", product);
		request.setAttribute("pagefile", "Mproduct/view.jsp");
		ActionForward forward = new ActionForward("Mtemplate.jsp", false);
		return forward;
	}

}
