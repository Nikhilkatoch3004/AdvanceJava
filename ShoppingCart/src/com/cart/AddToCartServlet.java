

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

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        
        HttpSession session = request.getSession();


        DBConnection db = new DBConnection();

        try {
            boolean check = db.addProduct(name, price);

            if (check) {
                request.setAttribute("message", "Product Added");
            } else {
                request.setAttribute("message", "Product Not Added");
            }


            
         // Fetch the updated product list
            ArrayList<Product> products = db.getCart();
            session.setAttribute("prod", products); // Update the session with the latest products

            // Redirect to index.jsp
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            request.setAttribute("message", "An error occurred while adding the product.");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }
}


