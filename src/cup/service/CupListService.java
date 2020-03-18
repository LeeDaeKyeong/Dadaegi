package cup.service;

import java.sql.Connection;
import java.util.ArrayList;
import static db.JdbcUtil.*;
import dao.CupDAO;
import vo.Cup;

public class CupListService {

	public ArrayList<Cup> getCupList() {
		// TODO Auto-generated method stub
		CupDAO cupDAO = CupDAO.getInstance();
		Connection con = getConnection();
		cupDAO.setConnection(con);
		ArrayList<Cup> cupList = cupDAO.selectCupList();
		close(con);
		
		return cupList;

	}
	

}
