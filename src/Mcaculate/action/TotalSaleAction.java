package Mcaculate.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mcaculate.svc.TotalSaleListSvc;
import action.Action;
import action.ActionForward;
import vo.Total_view;

public class TotalSaleAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ActionForward forward = null;
		
		String way = "way";
		String start_date = "";
		String end_date = "";
		
		if(request.getParameter("way")!=null) {
			way = request.getParameter("way");
		}
		if(request.getParameter("start_date")!=null) {
			start_date = request.getParameter("start_date");
		}
		if(request.getParameter("end_date")!=null) {
			end_date = request.getParameter("end_date");
		}
		
		TotalSaleListSvc totalsaleListsvc = new TotalSaleListSvc();
		ArrayList<Total_view> totalsaleList = totalsaleListsvc.getTotalSaleList(way, start_date, end_date);
		request.setAttribute("totalsaleList", totalsaleList);
		request.setAttribute("way", "total_list.jsp");
		forward = new ActionForward("Mcalculate/totalsale.jsp",false);
		request.setAttribute("pagefile", "Mcalculate/totalsale.jsp");
		forward = new ActionForward("Mtemplate.jsp",false);
		return forward;
	}

}
