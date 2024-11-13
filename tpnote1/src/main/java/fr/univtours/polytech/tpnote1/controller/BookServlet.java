package fr.univtours.polytech.tpnote1.controller;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.tpnote1.business.BookBusiness;
import fr.univtours.polytech.tpnote1.model.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "bookServlet", urlPatterns = { "/book" })
public class BookServlet extends HttpServlet  {

    @Inject
    private BookBusiness bookBusiness;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BookBean> books = bookBusiness.getBooksList();
        request.setAttribute("books", books);
        request.getRequestDispatcher("BookTable.jsp").forward(request, response);   
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int bookId = Integer.parseInt(request.getParameter("bookId"));

        if ("borrow".equals(action)) {
            bookBusiness.borrowBook(bookId);
        } else if ("return".equals(action)) {
            bookBusiness.returnBook(bookId);
        }
        
        response.sendRedirect("book");
    }
    
}
