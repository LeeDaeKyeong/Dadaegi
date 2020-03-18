package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import member.service.LoginService;
import vo.Member;

public class IdCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		 String check_id = request.getParameter("member_id");
	      LoginService idchecksvc = new LoginService();
	      Member member = idchecksvc.memberLogin(check_id);
	      ActionForward forward = null;
	      if (member == null) {
	         request.setAttribute("passibleId", true);
	      } else {
	         request.setAttribute("passibleId", false);
	      }
	      request.setAttribute("member_id", check_id);
	      forward = new ActionForward();
	      forward.setPath("member/idCheck.jsp");
	      return forward;

	}

}
