package pkg1;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/process")
public class ProcessFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Retrieve form data
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Create a Book object
        Book book = new Book();
        book.setB_name(name);
        book.setB_author(author);
        book.setB_price(price);
        book.setB_quant(quantity);

        // Insert into database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pr5", "root", "Dhakad123");
            PreparedStatement pst = con.prepareStatement("INSERT INTO ebookshop (booktitle, bookauthor, book_price, quantity) VALUES (?, ?, ?, ?)");
            pst.setString(1, book.getB_name());
            pst.setString(2, book.getB_author());
            pst.setInt(3, book.getB_price());
            pst.setInt(4, book.getB_quant());
            pst.executeUpdate();
            out.println("Data inserted successfully");
            response.sendRedirect("display");
            con.close();
        } catch (Exception e) {
            out.println(e);
        }

        out.close();
    }
}

