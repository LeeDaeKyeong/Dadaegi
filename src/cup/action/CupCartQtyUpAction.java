package cup.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import cup.service.CupCartQtyUpService;

public class CupCartQtyUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String kind = request.getParameter("product_name");
		CupCartQtyUpService cupCartQtyUpService = new CupCartQtyUpService();
		cupCartQtyUpService.upCartQty(kind, request);
		ActionForward forward = new ActionForward("cupCartList.cup", true);
		
		return forward;
	}

}
