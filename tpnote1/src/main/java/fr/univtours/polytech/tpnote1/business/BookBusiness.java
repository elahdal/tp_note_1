package fr.univtours.polytech.tpnote1.business;

import java.util.List;

import fr.univtours.polytech.tpnote1.model.BookBean;

public interface BookBusiness {

    public void borrowBook(Integer idBook);

    public void returnBook(Integer idBook);

    public List<BookBean> listFreeBooks();

    public List<BookBean> listBorrowedBooks();

    public List<BookBean> getBooksList();

    public BookBean getBookById(Integer idBook);

    public BookBean insertBook(BookBean book);
}
