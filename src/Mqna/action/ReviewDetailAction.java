package Mqna.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mqna.svc.ReviewDetailService;
import action.Action;
import action.ActionForward;
import vo.Review;

public class ReviewDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = null;
//		ArrayList<Review> reviewDetailList = new ArrayList<Review>();
		int review_index = Integer.parseInt(request.getParameter("review_index").trim());
		String nowPage = request.getParameter("page");
		ReviewDetailService reviewDetailService = new ReviewDetailService();
//		reviewDetailList = reviewDetailService.getReviewDetailList(review_index);
//		request.setAttribute("reviewDetailList", reviewDetailList);
		Review review = reviewDetailService.getReview(review_index);
		review = reviewDetailService.selectReview(review_index);
		request.setAttribute("review", review);
		request.setAttribute("page", nowPage);
		forward = new ActionForward("Mqna/review.jsp", false);
		return forward;
	}

}
