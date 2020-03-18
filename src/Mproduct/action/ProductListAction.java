package Mproduct.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mproduct.svc.ProductListService;
import action.Action;
import action.ActionForward;
import vo.PageInfo;
import vo.Product;

public class ProductListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String product_name = "";
		String product_code="";
		if (request.getParameter("product_name") != null) {
			product_name = request.getParameter("product_name");
		}
		if (request.getParameter("product_code") != null) {
			product_code = request.getParameter("product_code");
		}
		
		ArrayList<Product> productList = new ArrayList<Product>();
		int page = 1;
		int limit = 10; //페이지에 보여줄 목록 수
		int limitPage = 3; //페이지 수
		int listCount = 0;
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		ProductListService productListService = new ProductListService();
		
		listCount = productListService.getListCount(product_code,product_name);
		productList = productListService.getCupList(page,limit,product_code,product_name);
		
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
		request.setAttribute("product_code",product_code);
		request.setAttribute("product_name", product_name);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("productList", productList);
		request.setAttribute("pagefile", "/Mproduct/list.jsp");
		ActionForward forward = new ActionForward("Mtemplate.jsp", false);
		return forward;

	}

}
