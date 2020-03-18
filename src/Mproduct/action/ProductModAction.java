package Mproduct.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mproduct.svc.ProductViewService;
import action.Action;
import action.ActionForward;
import vo.Product;

public class ProductModAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		Product product = new Product();
		String product_name = null;

		product_name = request.getParameter("product_name");
		if (request.getParameter("product_name") != null && product_name != null) {
			product_name = request.getParameter("product_name");
		}
	
		if (product_name != null && !product_name.equals("")) {
			ProductViewService productModService = new ProductViewService();
			product = productModService.getProductView(product_name);
			request.setAttribute("product", product);
			request.setAttribute("pagefile", "/Mproduct/mod.jsp");
			forward = new ActionForward("Mtemplate.jsp", false);
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('오류!!!')");
			out.println("location.href='list.pro");
			out.println("</script>");
		}
		
		return forward;
	}

}
