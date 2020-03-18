package cup.service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CupDAO;
import vo.Cup;

public class DrinkListService {

	public ArrayList<Cup> getDrinkList() {
		// TODO Auto-generated method stub
		CupDAO cupDAO = CupDAO.getInstance();
		Connection con = getConnection();
		cupDAO.setConnection(con);
		ArrayList<Cup> drinkList = cupDAO.selectDrinkList();
		close(con);
		
		return drinkList;
	}

}
