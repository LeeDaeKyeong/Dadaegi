package Mmember.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mmember.svc.MemberPointSvc;
import action.Action;
import action.ActionForward;
import vo.Coupon;
import vo.Member;
import vo.PageInfo;


public class MemberPointAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
ActionForward forward = null;
		
		String searchType = "member_id";
		String keyword="";
		String start_date = "";
		String end_date = "";
		
		if(request.getParameter("searchType")!=null) {
			searchType = request.getParameter("searchType");
		}
		if(request.getParameter("keyword")!=null) {
			keyword = request.getParameter("keyword");
		}
		if(request.getParameter("start_date")!=null) {
			start_date = request.getParameter("start_date");
		}
		if(request.getParameter("end_date")!=null) {
			end_date = request.getParameter("end_date");
		}
		MemberPointSvc memberpointsvc = new MemberPointSvc();
		ArrayList<Coupon> memberPointList = memberpointsvc.memberPointList(searchType,keyword, start_date, end_date);
		int listCount = memberpointsvc.getListCount(searchType, keyword);
		int page = 1, limit = 10, limitPage = 3;
		
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
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
		request.setAttribute("pageInfo", pageInfo);
		
		request.setAttribute("memberPointList", memberPointList);
		request.setAttribute("point", "point_list.jsp");
		forward = new ActionForward("Mmember/member_point.jsp",false);
		request.setAttribute("pagefile", "Mmember/member_point.jsp");
		forward = new ActionForward("Mtemplate.jsp",false);
		return forward;
	}

}
