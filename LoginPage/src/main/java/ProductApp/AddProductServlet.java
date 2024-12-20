package ProductApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductManagement pm = new ProductManagement();
		doGet(request, response);
		String pname = request.getParameter("name");
		float price = Float.parseFloat(request.getParameter("price"));
		boolean added = pm.AddProduct(pname,price);
		
		if(added) {
			response.sendRedirect("success.html");
		}else {
			response.sendRedirect("error.html");
		}
		
		
		

	}

}
