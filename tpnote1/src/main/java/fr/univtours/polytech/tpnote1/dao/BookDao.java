package fr.univtours.polytech.tpnote1.dao;
import java.io.Serializable;
import java.util.List;
import fr.univtours.polytech.tpnote1.model.BookBean;

public interface BookDao extends Serializable  {

    public List<BookBean> getBookList();

    public void insertBookDao(BookBean book);

    public void borrowBookDao(BookBean book);

    public void returnBookDao(BookBean book);

    public int countBorrowedBooks();
    
}
