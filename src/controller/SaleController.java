package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mproduct.action.ProductListAction;
import Mproduct.action.ProductViewAction;
import Msale.action.OrderDetailAction;
import Msale.action.OrderListAction;
import Msale.action.OrderModAction;
import Msale.action.OrderPayModAction;
import Msale.action.ReservationDetailAction;
import Msale.action.ReservationListAction;
import Msale.action.ReservationModAction;
import Msale.action.ReservationPayModAction;
import action.Action;
import action.ActionForward;

/**
 * Servlet implementation class SaleController
 */
@WebServlet("*.sa")
public class SaleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaleController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	request.setCharacterEncoding("UTF-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
//		System.out.println(RequestURI);
//		System.out.println(contextPath);
		System.out.println(command);
		
		if(command.equals("/reservation.sa")) {
			action = new ReservationListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/order.sa")) {
			action = new OrderListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/reservationdetail.sa")) {
			action = new ReservationDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/orderdetail.sa")) {
			action = new OrderDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/dashboard.sa")) {
			forward = new ActionForward();
			request.setAttribute("pagefile", "/dashboard.jsp");
			forward.setPath("Mtemplate.jsp");
		}else if(command.equals("/ordermod.sa")) {
			action = new OrderModAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/paymentmod.sa")) {
			action = new OrderPayModAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/reservationmod.sa")) {
			action = new ReservationModAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/reservationpaymod.sa")) {
			action = new ReservationPayModAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/calendar.sa")) {
			forward = new ActionForward();
			request.setAttribute("pagefile", "/Msale/calendar.jsp");
			forward.setPath("Mtemplate.jsp");
		}
		
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
