package cup.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import cup.service.CupListService;
import cup.service.DrinkListService;
import vo.Cup;

public class drinkListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		DrinkListService drinkListService = new DrinkListService();
		ArrayList<Cup> cupList = drinkListService.getDrinkList();

		request.setAttribute("cupList", cupList);
		
		request.setAttribute("pagefile", "cupShopping/drinkList.jsp");
		ActionForward forward = new ActionForward("template.jsp", false);
		
		
		return forward;
	}

}
