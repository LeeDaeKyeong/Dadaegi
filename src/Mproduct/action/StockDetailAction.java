package Mproduct.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Mproduct.svc.StockDetailService;

import action.Action;
import action.ActionForward;
import vo.PageInfo;
import vo.PageInfo_in;
import vo.PageInfo_out;
import vo.Stock;

public class StockDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		ArrayList<Stock> stockDetailList = new ArrayList<Stock>();
		ArrayList<Stock> instockDetailList = new ArrayList<Stock>();
		ArrayList<Stock> outstockDetailList = new ArrayList<Stock>();
		
		StockDetailService stockDetailService = new StockDetailService();
		String product_code = request.getParameter("product_code").trim();
	
		int inpage = 1, inlimit = 10, inlimitPage = 10;
		int outpage = 1, outlimit = 10, outlimitPage = 10;

		if (request.getParameter("in_page") != null) {
			inpage = Integer.parseInt(request.getParameter("in_page"));
		}
		//입고 페이지
		if (request.getParameter("out_page") != null) {
			outpage = Integer.parseInt(request.getParameter("out_page"));
		}
		//출고 페이지
		
		int inlistCount = stockDetailService.getinListCount();
		//입고 리스트 카운트
		int outlistCount = stockDetailService.getoutListCount();
		//출고 리스트 카운트
		stockDetailList = stockDetailService.getstockDetailList(product_code);
		//재고 정보
		instockDetailList = stockDetailService.getinstockDetailList(product_code, inpage, inlimit);
		//입고 정보
		outstockDetailList = stockDetailService.getoutstockDetailList(product_code, outpage, outlimit);
		//출고 정보
		
	
		int inmaxPage = (int) ((double) inlistCount / inlimit + 0.95);
		// 0.95를 더해서 올림 처리
		// 현재 페이지에 보여줄 시작 페이지 수(1,11,21 등...)
		int instartPage = (((int) ((double) inpage / inlimitPage + 0.9)) - 1) * inlimitPage + 1;
		// 현재 페이지에 보여줄 마지막 페이지 수(10,20,30 등...)
		int inendPage = instartPage + inlimitPage - 1;
		
		if (inendPage > inmaxPage) {
			inendPage = inmaxPage;
		}
		PageInfo_in inpageInfo = new PageInfo_in();
		inpageInfo.setIn_endPage(inendPage);
		
		inpageInfo.setIn_maxPage(inmaxPage);
		inpageInfo.setIn_page(inpage);
		inpageInfo.setIn_startPage(instartPage);
		
		
		int outmaxPage = (int) ((double) outlistCount / outlimit + 0.95);
		// 0.95를 더해서 올림 처리
		// 현재 페이지에 보여줄 시작 페이지 수(1,11,21 등...)
		int outstartPage = (((int) ((double) outpage / outlimitPage + 0.9)) - 1) * outlimitPage + 1;
		// 현재 페이지에 보여줄 마지막 페이지 수(10,20,30 등...)
		int outendPage = outstartPage + outlimitPage - 1;

		if (outendPage > outmaxPage) {
			outendPage = outmaxPage;
		}
		
		PageInfo_out outpageInfo = new PageInfo_out();
		outpageInfo.setOut_endPage(outendPage);
		
		
		outpageInfo.setOut_maxPage(outmaxPage);
		outpageInfo.setOut_page(outpage);
		outpageInfo.setOut_startPage(outstartPage);
		
		inpageInfo.setIn_listCount(inlistCount);
		outpageInfo.setOut_listCount(outlistCount);
		request.setAttribute("inpageInfo", inpageInfo);
		request.setAttribute("outpageInfo", outpageInfo);
		request.setAttribute("stockDetailList", stockDetailList);
		request.setAttribute("instockDetailList", instockDetailList);
		request.setAttribute("outstockDetailList", outstockDetailList);
		forward = new ActionForward("Mproduct/stock_detail.jsp", false);
		return forward;
	}

}
