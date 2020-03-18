package Msale.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Msale.svc.ReservationModService;
import action.Action;
import action.ActionForward;
import vo.Reservation;

public class ReservationModAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
		String reservation_status = "reservation_status";
		int reservation_num = Integer.parseInt(request.getParameter("reservation_num").trim());
		String member_id = request.getParameter("member_id");
		if (request.getParameter("reservation_status") != null) {
			reservation_status = request.getParameter(reservation_status);
		}
		Reservation reservation = new Reservation();
		boolean isModifySuccess = false;
		ReservationModService reservationmodsvc = new ReservationModService();
		isModifySuccess = reservationmodsvc.reservationMod(reservation_num,reservation_status);
		
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
