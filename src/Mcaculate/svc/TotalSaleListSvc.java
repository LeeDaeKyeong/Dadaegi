package Mcaculate.svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CalculateDAO;
import vo.Total_view;
import static db.JdbcUtil.*;


public class TotalSaleListSvc {

	public ArrayList<Total_view> getTotalSaleList(String way, String start_date, String end_date) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		CalculateDAO calculateDAO = CalculateDAO.getInstance();
		calculateDAO.setConnection(con);
		
		ArrayList<Total_view> totalsaleList = calculateDAO.selectTotalSaleList(way, start_date, end_date);
		
		close(con);
		return totalsaleList;
	}

}
