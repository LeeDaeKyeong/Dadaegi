package cup.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import cup.service.CupCartRemoveService;


public class CupCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String[] kindArray = request.getParameterValues("remove");
		CupCartRemoveService cupCartRemoveService = new CupCartRemoveService();
		cupCartRemoveService.cartRemove(request, kindArray);
		ActionForward forward = new ActionForward("cupCartList.cup", true);
		
		return forward;
	}

}
