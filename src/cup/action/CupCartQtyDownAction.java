package cup.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import cup.service.CupCartQtyDownService;

public class CupCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String kind = request.getParameter("product_name");
		CupCartQtyDownService cupCartQtyDownService = new CupCartQtyDownService();
		cupCartQtyDownService.downCartQty(kind,request);
		ActionForward forward = new ActionForward("cupCartList.cup",true);
		
		return forward;
	}

}
