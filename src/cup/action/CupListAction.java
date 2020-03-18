package cup.action;

import java.util.ArrayList;

//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import cup.service.CupListService;
import vo.Cup;

public class CupListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		

		CupListService cupListService = new CupListService();
		ArrayList<Cup> cupList = cupListService.getCupList();

		request.setAttribute("cupList", cupList);
		
		request.setAttribute("pagefile", "cupShopping/cupList.jsp");
		ActionForward forward = new ActionForward("template.jsp", false);
		
		
		return forward;
	}

}
