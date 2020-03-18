package cup.service;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static db.JdbcUtil.*;
import dao.CupDAO;
import vo.Cart;
import vo.Cup;

public class CupCartAddService {

	public static Cup getCartCup(int id, int qnt) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		CupDAO cupDAO = CupDAO.getInstance();
		cupDAO.setConnection(con);
		Cup cup = cupDAO.selectCup(id,qnt);
		close(con);
		
		return cup;
	}

	public void addCart(HttpServletRequest request, Cup cartCup) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		if(cartList == null) {
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		
		boolean isNewCart = true;
		//지금 장바구니에 담는 항목이 새로 추가되는 항목인지를 저장할 변수
		
		for(int i = 0; i < cartList.size(); i++) {
			if(cartCup.getProduct_name().equals(cartList.get(i).getProduct_name())) {
				isNewCart = false;
				cartList.get(i).setProduct_quantity(cartList.get(i).getProduct_quantity()+1);
				break;
			}
		}
		
		if(isNewCart) {
			Cart cart = new Cart();
			cart.setProduct_image(cartCup.getProduct_image());
			cart.setProduct_name(cartCup.getProduct_name());
			cart.setProduct_price(cartCup.getProduct_price());
			cart.setProduct_quantity(1);
			cartList.add(cart);
		}
	}

}
