package member.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import member.service.LoginService;
import member.service.NoteListSvc;
import vo.Member;
import vo.Note;
import vo.PageInfo;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String member_id = request.getParameter("member_id");
		String member_pw = request.getParameter("member_pw");
		ActionForward forward = null;
		Member member = null;

		LoginService loginService = new LoginService();
		NoteListSvc noteListsvc = new NoteListSvc();

		member = loginService.memberLogin(member_id);
		int noteCount = noteListsvc.getNoteCount(member_id);
		int listCount = noteListsvc.getListCount();
		int page = 1, limit = 10, limitPage = 3;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		ArrayList<Note> noteList = noteListsvc.getNoteList(page, limit, member_id);
		int maxPage = (int) ((double) listCount / limit + 0.95);
		// 0.95를 더해서 올림 처리
		// 현재 페이지에 보여줄 시작 페이지 수(1,11,21 등...)
		int startPage = (((int) ((double) page / limitPage + 0.9)) - 1) * limitPage + 1;
		// 현재 페이지에 보여줄 마지막 페이지 수(10,20,30 등...)
		int endPage = startPage + limitPage - 1;

		if (endPage > maxPage) {
			endPage = maxPage;
		}
		if (member == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디가 존재하지 않습니다.')");
			out.println("history.back();");
			out.println("</script>");
		} else {
			if (!member_pw.equals(member.getMember_pw())) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('비밀번호가 일치하지 않습니다.');");
				out.println("history.back();");
				out.println("</script>");
			} else {
				PageInfo pageInfo = new PageInfo();
				pageInfo.setEndPage(endPage);
				pageInfo.setListCount(listCount);
				pageInfo.setMaxPage(maxPage);
				pageInfo.setPage(page);
				pageInfo.setStartPage(startPage);
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				request.setAttribute("noteCount",noteCount);
				request.setAttribute("pagefile", "main.jsp");
				request.setAttribute("pageInfo", pageInfo);
				request.setAttribute("noteList", noteList);
				forward = new ActionForward("template.jsp", false);
//				forward = new ActionForward();
//				forward.setPath("template.jsp");
//				forward.setRedirect(true);
			}
		}

		return forward;
	}

}
