package Mproduct.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mproduct.svc.ProductDeleteService;
import action.Action;
import action.ActionForward;

public class ProductDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		String product_name = null;

		product_name = request.getParameter("product_name");
		if(product_name==null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('오류류!!')");
			out.println("</script>");
		}else {
			String delete_product_name =request.getParameter("product_name");
			System.out.println("action"+delete_product_name);
			ProductDeleteService productDeleteService = new ProductDeleteService();
			request.setAttribute("delete_product_name", delete_product_name);
			boolean deleteResult = productDeleteService.deleteProduct(delete_product_name);
			if(!deleteResult) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('상품 정보가 삭제되지 않았습니다.')");
				out.println("location.href='Mproduct/list.jsp'");
				out.println("</script>");
			}else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('"+delete_product_name+"가 삭제되었습니다!')");
				out.println("location.href='list.pro?product_code=cake'");
				out.println("</script>");
			}
		}
		return forward;
	}

}
