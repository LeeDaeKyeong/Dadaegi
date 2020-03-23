package Mmember.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mmember.svc.NoteAddService;

import action.Action;
import action.ActionForward;
import vo.Note;


public class SendNoteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		NoteAddService noteAddService = new NoteAddService();
		request.setCharacterEncoding("UTF-8");
		Note note = new Note();
		note.setRecv_id(request.getParameter("recv_id"));
		note.setSend_id(request.getParameter("send_id"));
		note.setNote_content(request.getParameter("note_content"));
		note.setSend_date(request.getParameter("send_date"));
		System.out.println("action"+request.getParameter("recv_id"));
		boolean notetAddSuccess = noteAddService.addNote(note);
		ActionForward forward = null;

		if (notetAddSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('쪽지 발신 성공');");
			out.println("window.close();");
			out.println("</script>");

		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('쪽지 발신 실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
