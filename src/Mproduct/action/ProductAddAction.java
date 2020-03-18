package Mproduct.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Mproduct.svc.ProductAddService;
import action.Action;
import action.ActionForward;
import vo.Product;

public class ProductAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		ProductAddService productAddService = new ProductAddService();
		String realFolder = "";

		String saveFolder = "/images";
		String encType = "UTF-8";
		int maxSize = 5 * 1024 * 1024;

		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType,
				new DefaultFileRenamePolicy());
		String product_image = multi.getFilesystemName("product_image");
		Product product = new Product(0,
				multi.getParameter("product_code"), multi.getParameter("product_name"),
				Integer.parseInt(multi.getParameter("product_price")), product_image,
				multi.getParameter("product_content"), multi.getParameter("product_date"),
				multi.getParameter("optionValue"));
		boolean productAddSuccess = productAddService.addProduct(product);
		ActionForward forward = null; 
		
		if (productAddSuccess) {
			if(product.getProduct_code().equals("cake")) {
				forward = new ActionForward("list.pro?product_code=cake", true);
			}else {
				forward = new ActionForward("list.pro?product_code=drink", true);
			}
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
