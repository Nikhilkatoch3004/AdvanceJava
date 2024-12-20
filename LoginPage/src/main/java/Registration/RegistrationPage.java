package Registration;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Service.UserService;

@WebServlet("/RegistrationPage")
public class RegistrationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService uService = new UserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get parameters from request
		String Name = request.getParameter("name");
		String email = request.getParameter("email");
		String uname = request.getParameter("username");
		String pwd = request.getParameter("Password");

//		// Input validation (basic example)
//		if (name == null || email == null || uname == null || pwd == null || name.isEmpty() || email.isEmpty()
//				|| uname.isEmpty() || pwd.isEmpty()) {
//			response.sendRedirect("error.html"); // Redirect to error page if validation fails
//			return;
//		}

		// Create a new registration object and add to user service
		Regestration reg1 = new Regestration(Name, email, uname, pwd);

		// Adding to database by sending the object of class
		RegestrationDAO dao = new RegestrationDAO();
		try {
			boolean check = dao.register(reg1);
			if (check) {
				response.sendRedirect("success.html");
			} else {
				response.sendRedirect("error.html");
			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

//        uService.rg.add(reg1);

		// Debugging: Print out all registered users
//		System.out.println("In the registration Page Loop");
//		for (Regestration r : uService.rg) {
//
//			System.out.println("Username: " + r.uname);
//			System.out.println("Password: " + r.pwd);
//		}
//		System.out.println("Outside  the registration Page Loop");
//
//		// Redirect to new user page
//		response.sendRedirect("newuser.html");
	}
}
