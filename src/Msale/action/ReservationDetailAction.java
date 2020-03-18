package Msale.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Msale.svc.ReservationDetailService;
import action.Action;
import action.ActionForward;
import member.service.LoginService;
import vo.Member;

import vo.Reservation;

public class ReservationDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ActionForward forward=null;
		ArrayList<Reservation> reservationDetailList = new ArrayList<Reservation>();
		int reservation_num = Integer.parseInt(request.getParameter("reservation_num"));
		String member_id = request.getParameter("member_id"); 
		ReservationDetailService reservationDetailService = new ReservationDetailService();
		reservationDetailList = reservationDetailService.getReservationDetailList(reservation_num);
		LoginService memberInfosvc = new LoginService();
		Member member = memberInfosvc.memberLogin(member_id);
		request.setAttribute("reservationDetailList", reservationDetailList);
		session.setAttribute("member",member);
		//session으로 하기 member.id
		forward = new ActionForward("Msale/reservation_detail.jsp", false);
		return forward;
	}
}
