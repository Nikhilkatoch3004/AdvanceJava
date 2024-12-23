<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .form-container {
        background: #fff;
        padding: 30px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        border-radius: 10px;
        width: 350px;
        text-align: center;
    }
    h1 {
        color: #333;
        margin-bottom: 20px;
    }
    label {
        display: block;
        margin: 15px 0 5px;
        color: #555;
        font-weight: bold;
    }
    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 20px;
        border: 1px solid #ddd;
        border-radius: 5px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        width: 100%;
        padding: 12px;
        background: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        transition: background 0.3s ease;
    }
    input[type="submit"]:hover {
        background: #0056b3;
    }
</style>
</head>
<body>
    <div class="form-container">
        <h1>Add Product</h1>
        <form action="AddToCartServlet" method="post">
            <label for="name">Name:</label>
            <input type="text" name="name" required>
            <label for="price">Price:</label>
            <input type="text" name="price" required>
            <input type="submit" value="Add">
        </form>
    </div>
</body>
</html>
