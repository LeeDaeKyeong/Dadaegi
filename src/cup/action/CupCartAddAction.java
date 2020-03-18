package cup.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionForward;
import cup.service.CupCartAddService;
import vo.Cup;

public class CupCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		HttpSession session = request.getSession();
		String member_id = (String)session.getAttribute("member_id");
//		if(member_id == null) {
//			response.setContentType("text/html;charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.print("<script>");
//			out.print("alert('로그인을 하세요');");
//			out.print("location.href=encodeURI('loginForm.log');");
//			out.print("</script>");
//		}else {
		CupCartAddService cupCartAddService = new CupCartAddService();
		int id = Integer.parseInt(request.getParameter("cup_index"));
		int qnt = Integer.parseInt(request.getParameter("product_quantity"));
		System.out.println("수량 : " + qnt);
		Cup cartCup = CupCartAddService.getCartCup(id, qnt);
		
		
		cupCartAddService.addCart(request, cartCup);
		
		forward = new ActionForward("cupCartList.cup", true);	
		
//		}
		return forward;
	}

}
