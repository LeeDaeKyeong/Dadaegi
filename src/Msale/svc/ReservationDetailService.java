package Msale.svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.SaleDAO;

import vo.Reservation;
import static db.JdbcUtil.*;

public class ReservationDetailService {

	public ArrayList<Reservation> getReservationDetailList(int reservation_num) {
		// TODO Auto-generated method stub
		ArrayList<Reservation> reservationDetailList = null;
		Connection con = getConnection();
		SaleDAO saleDAO = SaleDAO.getInstance();
		saleDAO.setConnection(con);
		reservationDetailList = saleDAO.selectReservationDetailList(reservation_num);
		close(con);
		return reservationDetailList;
	}

}
