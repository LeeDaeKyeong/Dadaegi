package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import cup.action.CupCartAddAction;
import cup.action.CupCartListAction;
import cup.action.CupCartQtyDownAction;
import cup.action.CupCartQtyUpAction;
import cup.action.CupCartRemoveAction;
import cup.action.CupListAction;
import cup.action.CupOrderAction;
import cup.action.CupViewAction;
import cup.action.cupDirectOrderAction;
import cup.action.drinkListAction;



/**
 * Servlet implementation class CupController
 */
@WebServlet("*.cup")
public class CupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		if (command.equals("/main.cup")) {
			request.setAttribute("pagefile", "main.jsp");
			forward = new ActionForward();
			forward.setPath("template.jsp");

		} else if (command.equals("/review.cup")) {
			request.setAttribute("pagefile", "review.jsp");
			forward = new ActionForward();
			forward.setPath("template.jsp");

		} else if (command.equals("/introduce.cup")) {
			request.setAttribute("pagefile", "introduce.jsp");
			forward = new ActionForward();
			forward.setPath("template.jsp");

		} else if (command.equals("/cupList.cup")) {
			action = new CupListAction();
			try {
				forward = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/drinkList.cup")) {
			action = new drinkListAction();
			try {
				forward = action.execute(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/cupView.cup")) {
			action = new CupViewAction();
			// 프로젝트명+기능+형태(?)
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/cupCartList.cup")) {
			action = new CupCartListAction();
			//프로젝트명+기능+형태(?)
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/cupCartAdd.cup")) {
			action = new CupCartAddAction();
			//프로젝트명+기능+형태(?)
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/cupCartRemove.cup")) {
			action = new CupCartRemoveAction();
			//프로젝트명+기능+형태(?)
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/cupCartQtyUp.cup")) {
			action = new CupCartQtyUpAction();
			//모듈+기능+패턴
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/cupCartQtyDown.cup")) {
			action = new CupCartQtyDownAction();
			//프로젝트명+기능+형태(?)
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/cupOrder.cup")) {
			action = new CupOrderAction();
			//프로젝트명+기능+형태(?)
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/cupWay.cup")) {
			request.setAttribute("pagefile", "cupShopping/cupWay.jsp");
			forward = new ActionForward();
			forward.setPath("template.jsp");
			
		}else if(command.equals("/cupDirectOrder.cup")) {
			action = new cupDirectOrderAction();
			//프로젝트명+기능+형태(?)
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/orderComplate.cup")) {
			request.setAttribute("pagefile", "cupShopping/orderComplate.jsp");
			forward = new ActionForward();
			forward.setPath("template.jsp");
			
		}
		

		// System.out.println(forward.getPath());

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
}
