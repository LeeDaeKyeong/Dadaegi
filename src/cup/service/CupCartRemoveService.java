package cup.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class CupCartRemoveService {

	public static void cartRemove(HttpServletRequest request, String[] kindArray) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		for(int i = 0; i < kindArray.length; i++) {
			
			for(int j = 0;  j < cartList.size(); j++) {
				
				if(cartList.get(j).getProduct_name().equals(kindArray[i])) {
					cartList.remove(cartList.get(j));
				}
			}
		}
		
	}

}
