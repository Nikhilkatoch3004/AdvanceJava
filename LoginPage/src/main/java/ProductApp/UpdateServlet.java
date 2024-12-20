package ProductApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProductManagement pm = new ProductManagement();
		doGet(request, response);
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		float price = Float.parseFloat(request.getParameter("price"));
		
		boolean updated = pm.updateProduct(id, price);
		
		if(updated) {
//			response.sendRedirect("view.html");
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<h2> Updated Successfully </h2>");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("view.html");
			dispatcher.include(request, response);
		
		
		}else {
			response.sendRedirect("error.html");
		}
		
	}

}
