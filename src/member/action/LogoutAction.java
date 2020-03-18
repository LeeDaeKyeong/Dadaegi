package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;

public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ActionForward forward = new ActionForward();
		
		HttpSession session = request.getSession();
		session.invalidate();
		request.setAttribute("pagefile", "main.jsp");
		forward = new ActionForward("template.jsp", false);
		
		return forward;
	}

}
