package Mproduct.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mproduct.svc.StockAddService;
import action.Action;
import action.ActionForward;
import vo.Stock;

public class StockAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		StockAddService stockaddsvc = new StockAddService();
		
		Stock stock = new Stock();
		stock.setStock_index(0);
		stock.setProduct_code(request.getParameter("product_code"));
		stock.setInout_date(request.getParameter("inout_date"));
		stock.setInout_quantity(Integer.parseInt(request.getParameter("inout_quantity")));
		stock.setStock_status(request.getParameter("stock_status"));
		
		boolean stockAddSuccess = stockaddsvc.addStock(stock);
		ActionForward forward = null;
		
		if(stockAddSuccess) {
			forward = new ActionForward("stockdetail.pro?product_code="+stock.getProduct_code(), true);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('재고입력실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}
}
