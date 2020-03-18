package Mproduct.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Mproduct.svc.ProductModProService;
import action.Action;
import action.ActionForward;
import vo.Product;

public class ProductModProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		String realFolder = "";

		String saveFolder = "/images";
		String encType = "UTF-8";
		int maxSize = 5 * 1024 * 1024;

		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType,
				new DefaultFileRenamePolicy());
		String product_image = multi.getFilesystemName("product_image");
		Product product = new Product(0, multi.getParameter("product_code"), multi.getParameter("product_name"),
				Integer.parseInt(multi.getParameter("product_price")), product_image,
				multi.getParameter("product_content"), multi.getParameter("product_date"),
				multi.getParameter("optionValue"));

		request.setCharacterEncoding("UTF-8");

		String mod_product_name = request.getParameter("product_name");
try {
		product.setCup_index(Integer.parseInt("cup_index"));
		product.setProduct_code("product_code");
		product.setProduct_name(mod_product_name);
		product.setProduct_price(Integer.parseInt("product_price"));
		product.setProduct_image("product_image");
		product.setProduct_content("product_content");
		product.setProduct_date("product_date");
		product.setProduct_status("product_status");
}catch(Exception e) {
	
}
		boolean isModifySuccess = false;
		ProductModProService productModProService = new ProductModProService();
		isModifySuccess = productModProService.productMod(product);

		if (!isModifySuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정에 오류가 발생했습니다. 다시 작성하세요.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("view.pro?product_name=" + product.getProduct_name());
		}

		return forward;
	}
}