package Msale.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Msale.svc.ReservationPayModService;
import action.Action;
import action.ActionForward;
import vo.Reservation;

public class ReservationPayModAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;

		String payment_status = "payment_status";
		String member_id = request.getParameter("member_id");
		int reservation_num = Integer.parseInt(request.getParameter("reservation_num").trim());
		if (request.getParameter("payment_status") != null) {
			payment_status = request.getParameter(payment_status);
		}
		Reservation reservation = new Reservation();
		boolean isModifySuccess = false;
		ReservationPayModService reservationpaymodsvc = new ReservationPayModService();
		isModifySuccess = reservationpaymodsvc.reservationpayMod(reservation_num,payment_status);
		
		if(!isModifySuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정에 오류가 발생했습니다. 다시 수정하세요.');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			forward = new ActionForward();
			request.setAttribute("reservation", reservation);
			forward.setPath("reservationdetail.sa?reservation_num="+reservation_num+"&member_id="+member_id);
		}
		return forward;
	}

}
