package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mmember.action.MdeleteAction;
import Mmember.action.MemberDetailAction;
import Mmember.action.MemberListAction;
import Mmember.action.MemberPointAction;
import Mmember.action.MemberRatingAction;
import Mmember.action.MemberRatingListAction;
import Mmember.action.MmodAction;
import Mmember.action.PointDeleteAction;
import Mmember.action.PointDetailAction;
import Mmember.action.RatingDeleteAction;
import Mmember.action.RatingDetailAction;
import Mmember.action.RatingModAction;
import action.Action;
import member.action.IdCheckAction;
import member.action.MemberDelAction;
import member.action.MemberInfoAction;
import member.action.MemberJoinProAction;
import member.action.MemberModAction;
import member.action.MemberModProAction;
import action.ActionForward;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.mem")
public class MemberController extends javax.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());

		ActionForward forward = null;
		Action action = null;

//    	System.out.println(command);
		if (command.equals("/joinForm.mem")) {
			forward = new ActionForward();
			request.setAttribute("pagefile", "member/joinForm.jsp");	
			forward.setPath("/template.jsp");
		} else if (command.equals("/memberJoinProcess.mem")) {
			action = new MemberJoinProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberInfo.mem")) {
			action = new MemberInfoAction();	
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberMod.mem")) {
			action = new MemberModAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}					
		}else if (command.equals("/memberModPro.mem")) {
			action = new MemberModProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}					
		}else if (command.equals("/memberDelete.mem")) {
			action = new MemberDelAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}					
		}else if (command.equals("/idCheck.mem")) {
			action = new IdCheckAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}					
		}else if (command.equals("/memberList.mem")) {
			action = new MemberListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}					
		}else if (command.equals("/ratingList.mem")) {
			action = new MemberRatingListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}					
		}else if (command.equals("/memberPoint.mem")) {
			action = new MemberPointAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}					
		}else if (command.equals("/pointList.mem")) {
			forward = new ActionForward();
    		request.setAttribute("pagefile", "Mmember/member_point.jsp");
    		forward.setPath("Mtemplate.jsp");
		}else if (command.equals("/memberDetail.mem")) {
			action = new MemberDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}else if (command.equals("/Mmod.mem")) {
			action = new MmodAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}					
		}else if (command.equals("/Mdelete.mem")) {
			action = new MdeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}					
		}else if (command.equals("/memberRating.mem")) {
			action = new MemberRatingAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}					
		}else if (command.equals("/ratingMod.mem")) {
			action = new RatingModAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}					
		}else if (command.equals("/ratingDetail.mem")) {
			action = new RatingDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}					
		}else if (command.equals("/ratingDelete.mem")) {
			action = new RatingDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}					
		}else if (command.equals("/pointDetail.mem")) {
			action = new PointDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}					
		}else if (command.equals("/pointDelete.mem")) {
			action = new PointDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}					
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