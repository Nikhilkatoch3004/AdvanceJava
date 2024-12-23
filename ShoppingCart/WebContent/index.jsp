<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.cart.Product"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    .container {
        width: 80%;
        margin: auto;
        overflow: hidden;
    }
    header {
        background: #333;
        color: #fff;
        padding-top: 30px;
        min-height: 70px;
        border-bottom: #77aaff 3px solid;
    }
    header h1 {
        text-align: center;
        text-transform: uppercase;
        margin: 0;
        font-size: 24px;
    }
    table {
        width: 100%;
        margin: 20px 0;
        border-collapse: collapse;
    }
    table, th, td {
        border: 1px solid #ddd;
    }
    th, td {
        padding: 12px;
        text-align: left;
    }
    th {
        background-color: #77aaff;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    tr:hover {
        background-color: #ddd;
    }
    .message {
        background: #77aaff;
        color: #fff;
        padding: 10px;
        margin: 10px 0;
        text-align: center;
    }
    .add-product {
        display: block;
        width: 200px;
        margin: 20px auto;
        padding: 10px;
        background: #333;
        color: #fff;
        text-align: center;
        text-decoration: none;
        border-radius: 5px;
    }
    .add-product:hover {
        background: #77aaff;
    }
</style>
</head>
<body>
    <header>
        <h1>Cart</h1>
    </header>
    <div class="container">
        <% String message = (String) request.getAttribute("message"); %>
        <% if (message != null) { %>
            <div class="message"><%= message %></div>
        <% } %>

        <%
            ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("prod");
            if (products != null && !products.isEmpty()) {
        %>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
            </tr>
            <%
                for (Product p : products) {
            %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getName() %></td>
                <td><%= p.getPrice() %></td>
            </tr>
            <%
                }
            %>
        </table>
        <%
            } else {
        %>
        <p>No products in the cart.</p>
        <%
            }
        %>

        <a href="addProduct.jsp" class="add-product">ADD Product</a>
    </div>
</body>
</html>
