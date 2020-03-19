package Mmember.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import Mmember.svc.MemberListSvc;
import vo.Member;
import vo.PageInfo;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		HttpSession session = request.getSession();
		
		String searchType = "member_id";
		String keyword="";
		
		if(request.getParameter("searchType")!=null) {
			searchType = request.getParameter("searchType");
		}
		if(request.getParameter("keyword")!=null) {
			keyword = request.getParameter("keyword");
		}

//		if ((session.getAttribute("id") == null) || (!((String) session.getAttribute("id")).equals("admin"))) {
//			response.setContentType("text/html;charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
//			out.println("alert('관리자로 로그인하세요!!');");
//			out.println("location.href='loginForm.log'");
//			out.println("</script>");
//		} else {
			MemberListSvc memberListsvc = new MemberListSvc();
			int listCount = memberListsvc.getListCount(searchType, keyword);
			int page = 1, limit = 10, limitPage = 3;
			
			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			
			ArrayList<Member> memberList = memberListsvc.getMemberList(page, limit, searchType, keyword);
			
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
			request.setAttribute("memberList", memberList);
			request.setAttribute("pagefile", "Mmember/member_list.jsp");
			
			forward = new ActionForward("/Mtemplate.jsp",false);
//		}
		return forward;
	}

}
