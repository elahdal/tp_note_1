package fr.univtours.polytech.tpnote1.controller;


import java.io.IOException;

import fr.univtours.polytech.tpnote1.business.BookBusiness;
import fr.univtours.polytech.tpnote1.model.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "fillDBServlet", urlPatterns = { "/fillDB" })
public class FillDBServlet extends HttpServlet {

    @Inject
    private BookBusiness bookBusiness;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        BookBean livre = new BookBean();
        livre.setAuthor("René Barjavel");;
        livre.setTitle("La nuit des temps");
        livre.setAvailable(false);
        bookBusiness.insertBook(livre);

        BookBean livre1 = new BookBean();
        livre1.setAuthor("Tolkien");
        livre1.setTitle("Le seigneur des anneaux");
        livre1.setAvailable(false);
        bookBusiness.insertBook(livre1);

    }
}

