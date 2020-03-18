package Msale.svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.SaleDAO;
import vo.Reservation;
import static db.JdbcUtil.*;

public class ReservationListService {

	public int getListCount() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		SaleDAO reservationDao = SaleDAO.getInstance();
		reservationDao.setConnection(con);

		int listCount = reservationDao.selectCount();
		close(con);
		return listCount;
	}

	public ArrayList<Reservation> getMemberList(int page, int limit) {
		// TODO Auto-generated method stub

		Connection con = getConnection();
		SaleDAO reservationDao = SaleDAO.getInstance();
		reservationDao.setConnection(con);

		ArrayList<Reservation> reservationList = reservationDao.selectReservationList(page, limit);
		close(con);
		return reservationList;
	}

}
