
package com.cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnection {

    public ArrayList<Product> getCart() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dac_db", "root", "Sanm@3004");

        String query = "Select * from products";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery(query);

        ArrayList<Product> al = new ArrayList<>();

        while (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt(1));
            p.setName(rs.getString(2));
            p.setPrice(rs.getDouble(3));
            al.add(p);
        }

        return al;
    }

    public boolean addProduct(String name, double price) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dac_db", "root", "Sanm@3004");

        
        String query2 = "insert into products(name , price) values(?,?)";
        PreparedStatement ps1 = con.prepareStatement(query2);
        
        ps1.setNString(1, name);
        ps1.setDouble(2, price);

        int num = ps1.executeUpdate();
        
        ps1.close();
        con.close();

        return num > 0;
    }
}



