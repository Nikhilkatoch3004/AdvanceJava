package com.cart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		DBConnection db = new DBConnection();

//		try {
//			ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("prod");
//			if (products == null) {
//				products = new ArrayList<Product>();
//			} else {
//				products.clear();
//			}
//			products.addAll(db.getCart());
//			session.setAttribute("prod", products);
//			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//			rd.forward(request, response);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
            ArrayList<Product> products = db.getCart(); // Fetch the latest products from the database
            session.setAttribute("prod", products); // Update the session with the latest products
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


