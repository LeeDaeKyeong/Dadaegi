package cup.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import cup.service.CupViewService;
import vo.Cup;

public class CupViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		CupViewService cupViewService = new CupViewService();
		int id = Integer.parseInt(request.getParameter("cup_index"));
		Cup cup = cupViewService.getCupView(id);
		request.setAttribute("cup", cup);
//		System.out.println(cup.getProduct_image());
		request.setAttribute("pagefile", "cupShopping/cupView.jsp");
		ActionForward forward = new ActionForward("template.jsp", false);
		
		return forward;
	}

}
