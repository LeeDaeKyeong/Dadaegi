package cup.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class CupCartQtyUpService {

	public void upCartQty(String kind, HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		for(int i = 0; i < cartList.size(); i++) {
			
			if(cartList.get(i).getProduct_name().equals(kind)) {
				cartList.get(i).setProduct_quantity(cartList.get(i).getProduct_quantity()+1);
			}
		}
		
	}

}
