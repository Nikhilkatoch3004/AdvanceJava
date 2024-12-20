package loginPage;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Registration.Regestration;
import Registration.RegestrationDAO;
import Service.UserService;

@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService uService = new UserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("username");
		String pss = request.getParameter("password");
		RegestrationDAO rd = new RegestrationDAO();

		try {
			boolean isValidUser = rd.loginCheck(user, pss);
			if (isValidUser) {
				response.sendRedirect("Menu.html");
			} else {
				response.sendRedirect("error.html");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html"); // Redirect to error page on exception
		}
	}

}
